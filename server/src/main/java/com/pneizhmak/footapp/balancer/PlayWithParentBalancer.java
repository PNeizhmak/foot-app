package com.pneizhmak.footapp.balancer;

import com.pneizhmak.footapp.balancer.converter.TeamToPngConverter;
import com.pneizhmak.footapp.db.model.Player;
import com.pneizhmak.footapp.db.model.PlayerProfile;
import com.pneizhmak.footapp.db.model.Team;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Pavel Neizhmak
 */
public class PlayWithParentBalancer implements TeamMaker {

    @Override
    public Collection<Team> execute(List<PlayerProfile> playerProfiles, int playersCount, int teamsCount, boolean createPng) {

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
                    @SuppressWarnings("ConstantConditions")
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

        parentIdToChildProfile.values().forEach(pp -> proceedMakeTeam2(teamList, seed, pp, teamsCount, playersInTeam));

        while (teamList[teamsCount - 1].size() != playersInTeam) {
            positionToProfile.forEach((position, profiles) -> {
                removeSelectedProfiles(playersToDelete, profilesToDelete, profiles);

                if (!profiles.isEmpty()) {
                    @SuppressWarnings("ConstantConditions")
                    PlayerProfile playerProfile = profiles.stream().max(Comparator.comparing(PlayerProfile::getWeight)).get();
                    player[0] = playerProfile.getPlayer();
                    playersToDelete.add(player[0]);

                    proceedMakeTeam2(teamList, seed, Collections.singletonList(playerProfile), teamsCount, playersInTeam);
                }
            });
        }

        produceTeams(result, teams, teamList);

        if (createPng) {
            TeamToPngConverter.createImage(result);
        }

        return result;
    }
}
