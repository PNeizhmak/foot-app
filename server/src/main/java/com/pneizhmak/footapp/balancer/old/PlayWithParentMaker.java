package com.pneizhmak.footapp.balancer.old;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.pneizhmak.footapp.db.model.Player;
import com.pneizhmak.footapp.db.model.PlayerProfile;
import com.pneizhmak.footapp.db.model.Team;

import static java.util.Comparator.comparingInt;

@SuppressWarnings("ConstantConditions")
public class PlayWithParentMaker implements OldTeamMakerInterface {

    @Override
    public Collection<Team> makeTeams(List<PlayerProfile> playerProfiles, int playersCount, int teamsCount) {

        Collection<Team> result = new ArrayList<>();

        List<Team> teams = new ArrayList<>();

        @SuppressWarnings("unchecked")
        List<PlayerProfile>[] teamList = (List<PlayerProfile>[]) new ArrayList[teamsCount];

        for (int i = 0; i < teamsCount; i++) {
            teamList[i] = new ArrayList<>();
            teams.add(new Team());
        }

        final int playersInTeam = playersCount / teamsCount;
        final Player[] player = new Player[1];
        List<Player> playersToDelete = new ArrayList<>();
        List<PlayerProfile> profilesToDelete = new ArrayList<>();
        List<PlayerProfile> childParentTeam = new ArrayList<>();

        Map<String, List<PlayerProfile>> positionToChildProfiles = playerProfiles.stream()
                .filter(p -> p.getPlayer().getParentId() != 0).collect(Collectors.groupingBy(
                        (profile) -> profile.getPosition().getName(), Collectors.mapping((profile) -> profile, Collectors.toList())));

        playerProfiles.removeAll(playerProfiles.stream().filter(p -> p.getPlayer().getParentId() != 0).collect(Collectors.toList()));

        int i = 0;
        while (i++ < 4) {
            positionToChildProfiles.forEach((position, profiles) -> {

                removeSelectedProfiles(playersToDelete, profilesToDelete, profiles);

                if (!profiles.isEmpty()) {
                    PlayerProfile playerProfile = profiles.stream().max(Comparator.comparing(PlayerProfile::getWeight)).get();
                    player[0] = playerProfile.getPlayer();
                    playersToDelete.add(player[0]);

                    childParentTeam.add(playerProfile);
                }
            });
        }

        Map<Integer, List<PlayerProfile>> parentIdToChildProfile =
                childParentTeam.stream().collect(Collectors.groupingBy(pp -> pp.getPlayer().getParentId()));

        parentIdToChildProfile.keySet().forEach(id -> {
            try {
                //noinspection ConstantConditions
                PlayerProfile parentProfile = playerProfiles.stream().filter(pp -> Objects.equals(pp.getPlayer().getId(), id)).findAny().get();
                parentIdToChildProfile.get(id).add(parentProfile);
            } catch (NoSuchElementException e) {
                System.out.println(id + " - parent is absent");
            }
        });

        final List<PlayerProfile> parentsToRemove = playerProfiles.stream()
                .filter(pp -> parentIdToChildProfile.keySet().contains(pp.getPlayer().getId())).collect(Collectors.toList());
        playerProfiles.removeAll(parentsToRemove);

        Map<String, List<PlayerProfile>> positionToProfile = playerProfiles.stream().collect(Collectors.groupingBy(
                (profile) -> profile.getPosition().getName(), Collectors.mapping((profile) -> profile, Collectors.toList())));

        final int[] seed = {0};

        parentIdToChildProfile.values().forEach(pp -> proceedPlayWithParentBalance(teamList, seed, pp, teamsCount, playersInTeam));

        while (teamList[teamsCount - 1].size() != playersInTeam) {
            positionToProfile.forEach((position, profiles) -> {
                removeSelectedProfiles(playersToDelete, profilesToDelete, profiles);

                if (!profiles.isEmpty()) {

                    List<Integer> bucketWeightList = new ArrayList<>(teamsCount);
                    final int[] bucketIndex = {0};
                    Arrays.stream(teamList).forEach(bucket -> {
                        if (teamList[bucketIndex[0]].size() > 0) {
                            final int[] bucketWeight = new int[1];
                            bucket.forEach(pp -> bucketWeight[0] += pp.getWeight());
                            bucketWeightList.add(bucketWeight[0]);
                            bucketIndex[0]++;
                        }
                    });

                    int minTeamWeightBucket;
                    minTeamWeightBucket = IntStream.range(0, bucketWeightList.size()).boxed()
                            .min(comparingInt(bucketWeightList::get))
                            .get();

                    if (teamList[minTeamWeightBucket].size() == playersInTeam) {
                        int finalMinTeamWeightBucket = minTeamWeightBucket;
                        minTeamWeightBucket = IntStream.range(0, bucketWeightList.size()).filter(index -> index != finalMinTeamWeightBucket).boxed()
                                .min(comparingInt(bucketWeightList::get))
                                .get();
                    }

                    final PlayerProfile playerProfile = profiles.stream().max(Comparator.comparing(PlayerProfile::getWeight)).get();

                    player[0] = playerProfile.getPlayer();
                    playersToDelete.add(player[0]);

                    teamList[minTeamWeightBucket].add(playerProfile);
                }
            });
        }

        produceTeams(result, teams, teamList);

        return result;
    }

    private void proceedPlayWithParentBalance(List<PlayerProfile>[] teamList, int[] seed, List<PlayerProfile> playerProfiles, int teamsCount, int playersInTeam) {
        ++seed[0];
        if (seed[0] > teamsCount) {
            seed[0] = 1;
        }
        for (int team = 1; team <= teamsCount; team++) {
            if (seed[0] == team) {
                if (teamList[team - 1].size() + playerProfiles.size() > playersInTeam) {
                    ++seed[0];
                    continue;
                }
                teamList[team - 1].addAll(playerProfiles);
                break;
            }
        }
    }

    //keep this change
    private double getTeamWeightAvg(List<PlayerProfile> playerProfiles, int playersInTeam) {
        int[] teamWeightSum = {0};
        playerProfiles.forEach(pp -> teamWeightSum[0] += pp.getWeight());

        return teamWeightSum[0] / playerProfiles.size() * playersInTeam;
    }
}
