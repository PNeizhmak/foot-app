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

    default void produceTeams(Collection<Team> result, List<Team> teams, List<PlayerProfile>[] teamList) {
        for (int index = 0; index < teams.size(); index++) {

            int teamWeight = teamList[index].stream().mapToInt(PlayerProfile::getWeight).sum();

            teams.get(index).setPlayers(teamList[index]);
            teams.get(index).setTeamWeight(teamWeight);

            result.add(teams.get(index));
        }
    }
}
