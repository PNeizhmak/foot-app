package com.pneizhmak.footapp.balancer;

import com.pneizhmak.footapp.db.model.Player;
import com.pneizhmak.footapp.db.model.PlayerProfile;
import com.pneizhmak.footapp.db.model.Team;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Pavel Neizhmak
 */
public class AutoTeamBalancer implements TeamMaker {

    @Override
    public Collection<Team> execute(List<PlayerProfile> playerProfiles, int playersCount, int teamsCount) {

        Collection<Team> result = new ArrayList<>();

        List<Team> teams = new ArrayList<>();

        @SuppressWarnings("unchecked")
        List<PlayerProfile>[] teamList = (List<PlayerProfile>[]) new ArrayList[teamsCount];

        for (int i = 0; i < teamsCount; i++) {
            teamList[i] = new ArrayList<>();
            teams.add(new Team());
        }

        Map<String, Set<PlayerProfile>> positionToProfile = playerProfiles.stream().collect(Collectors.groupingBy(
                (profile) -> profile.getPosition().getName(), Collectors.mapping((profile) -> profile, Collectors.toSet())));

        final int playersInTeam = playersCount / teamsCount;
        final Player[] player = new Player[1];
        List<Player> playersToDelete = new ArrayList<>();
        List<PlayerProfile> profilesToDelete = new ArrayList<>();

        final int[] seed2 = {0};
        final int[] seed3 = {0};

        while (teamList[teamsCount - 1].size() != playersInTeam) {
            positionToProfile.forEach((position, profiles) -> {
                if (!playersToDelete.isEmpty()) {
                    profiles.forEach((profile) -> playersToDelete.forEach((playerToDelete) -> {
                        if (profile.getPlayer().getId().equals(playerToDelete.getId())) {
                            profilesToDelete.add(profile);
                        }
                    }));
                    profiles.removeAll(profilesToDelete);
                }

                if (!profiles.isEmpty()) {
                    PlayerProfile playerProfile = profiles.stream().max(Comparator.comparing(PlayerProfile::getWeight)).get();
                    player[0] = playerProfile.getPlayer();
                    playersToDelete.add(player[0]);


                    if (teamList.length == 2) {
                        makeTwoTeams(teamList, seed2, playerProfile);
                    } else if (teamList.length == 3) {
                        makeThreeTeams(teamList, seed3, playerProfile);
                    }
                }
            });
        }

        for (int index = 0; index < teams.size(); index++) {

            int teamWeight = teamList[index].stream().mapToInt(PlayerProfile::getWeight).sum();

            teams.get(index).setPlayers(teamList[index]);
            teams.get(index).setTeamWeight(teamWeight);

            result.add(teams.get(index));
        }

        return result;
    }

    private void makeThreeTeams(List<PlayerProfile>[] teamList, int[] seed3, PlayerProfile playerProfile) {
        ++seed3[0];
        if (seed3[0] > 3) {
            seed3[0] = 1;
        }
        if (seed3[0] == 1) teamList[0].add(playerProfile);
        else if (seed3[0] == 2) teamList[1].add(playerProfile);
        else if (seed3[0] == 3) teamList[2].add(playerProfile);
    }

    private void makeTwoTeams(List<PlayerProfile>[] teamList, int[] seed2, PlayerProfile playerProfile) {
        ++seed2[0];
        if (seed2[0] > 2) {
            seed2[0] = 1;
        }
        if (seed2[0] == 1) teamList[0].add(playerProfile);
        else if (seed2[0] == 2) teamList[1].add(playerProfile);
    }
}
