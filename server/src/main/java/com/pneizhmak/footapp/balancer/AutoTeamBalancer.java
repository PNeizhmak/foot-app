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

        Team team1 = new Team();
        Team team2 = new Team();

        List<Player> playersTeam1 = new ArrayList<>();
        List<Player> playersTeam2 = new ArrayList<>();

        Map<String, Set<PlayerProfile>> positionToProfile = playerProfiles.stream().collect(Collectors.groupingBy(
                (profile) -> profile.getPosition().getName(), Collectors.mapping((profile) -> profile, Collectors.toSet())));

        final int playersInTeam = playersCount / teamsCount;
        final int[] i = {0};
        final Player[] player = new Player[1];
        List<Player> playersToDelete = new ArrayList<>();
        List<PlayerProfile> profilesToDelete = new ArrayList<>();

        while(playersTeam1.size() != playersInTeam) {
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
                    player[0] = profiles.stream().max(Comparator.comparing(PlayerProfile::getWeight)).get().getPlayer();
                    playersToDelete.add(player[0]);

                    ++i[0];
                    if (i[0] % 2 == 0) {
                        playersTeam1.add(player[0]);
                    } else {
                        playersTeam2.add(player[0]);
                    }
                }
            });
        }

        team1.setPlayers(playersTeam1);
        team2.setPlayers(playersTeam2);

        result.add(team1);
        result.add(team2);

        return result;
    }
}
