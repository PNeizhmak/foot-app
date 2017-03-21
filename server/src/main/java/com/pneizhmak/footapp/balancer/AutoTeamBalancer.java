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

        List<PlayerProfile> playersTeam1 = new ArrayList<>();
        List<PlayerProfile> playersTeam2 = new ArrayList<>();

        Map<String, Set<PlayerProfile>> positionToProfile = playerProfiles.stream().collect(Collectors.groupingBy(
                (profile) -> profile.getPosition().getName(), Collectors.mapping((profile) -> profile, Collectors.toSet())));

        final int playersInTeam = playersCount / teamsCount;
        final int[] i = {0};
        final Player[] player = new Player[1];
        List<Player> playersToDelete = new ArrayList<>();
        List<PlayerProfile> profilesToDelete = new ArrayList<>();

        while (playersTeam1.size() != playersInTeam) {
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

                    ++i[0];
                    if (i[0] % 2 == 0) {
                        playersTeam1.add(playerProfile);
                    } else {
                        playersTeam2.add(playerProfile);
                    }
                }
            });
        }

        int weightTeam1 = playersTeam1.stream().mapToInt(PlayerProfile::getWeight).sum();
        int weightTeam2 = playersTeam2.stream().mapToInt(PlayerProfile::getWeight).sum();

        team1.setPlayers(playersTeam1);
        team2.setPlayers(playersTeam2);

        team1.setTeamWeight(weightTeam1);
        team2.setTeamWeight(weightTeam2);

        result.add(team1);
        result.add(team2);

        return result;
    }
}
