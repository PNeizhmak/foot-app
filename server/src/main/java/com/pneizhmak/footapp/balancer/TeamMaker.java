package com.pneizhmak.footapp.balancer;

import com.pneizhmak.footapp.db.model.Player;
import com.pneizhmak.footapp.db.model.PlayerProfile;
import com.pneizhmak.footapp.db.model.Team;

import java.util.Collection;
import java.util.List;

/**
 * @author Pavel Neizhmak
 */
public interface TeamMaker {

    Collection<Team> execute(List<PlayerProfile> playerProfiles, int playersCount, int teamsCount, boolean createPng);

    default void removeSelectedProfiles(List<Player> playersToDelete, List<PlayerProfile> profilesToDelete, List<PlayerProfile> profiles) {
        if (!playersToDelete.isEmpty()) {
            profiles.forEach((profile) -> playersToDelete.forEach((playerToDelete) -> {
                if (profile.getPlayer().getId().equals(playerToDelete.getId())) {
                    profilesToDelete.add(profile);
                }
            }));
            profiles.removeAll(profilesToDelete);
        }
    }

    default void proceedMakeTeam1(List<PlayerProfile>[] teamList, int[] seed, PlayerProfile playerProfile, int teamsCount) {
        ++seed[0];
        if (seed[0] > teamsCount) {
            seed[0] = 1;
        }
        for (int team = 1; team <= teamsCount; team++) {
            if (seed[0] == team) {
                teamList[team - 1].add(playerProfile);
                break;
            }
        }
    }

    default void proceedMakeTeam2(List<PlayerProfile>[] teamList, int[] seed, List<PlayerProfile> playerProfiles, int teamsCount, int playersInTeam) {
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

    default void produceTeams(Collection<Team> result, List<Team> teams, List<PlayerProfile>[] teamList) {
        for (int index = 0; index < teams.size(); index++) {

            int teamWeight = teamList[index].stream().mapToInt(PlayerProfile::getWeight).sum();

            teams.get(index).setPlayers(teamList[index]);
            teams.get(index).setTeamWeight(teamWeight);

            result.add(teams.get(index));
        }
    }
}
