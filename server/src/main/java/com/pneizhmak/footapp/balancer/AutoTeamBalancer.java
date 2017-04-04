package com.pneizhmak.footapp.balancer;

import com.pneizhmak.footapp.balancer.converter.TeamToImageConverter;
import com.pneizhmak.footapp.db.model.Player;
import com.pneizhmak.footapp.db.model.PlayerProfile;
import com.pneizhmak.footapp.db.model.Team;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;
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

        final int[] seed = {0};

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

                    proceedMakeTeam(teamList, seed, playerProfile, teamsCount);
                }
            });
        }

        for (int index = 0; index < teams.size(); index++) {

            int teamWeight = teamList[index].stream().mapToInt(PlayerProfile::getWeight).sum();

            teams.get(index).setPlayers(teamList[index]);
            teams.get(index).setTeamWeight(teamWeight);

            result.add(teams.get(index));
        }

        BufferedImage image = TeamToImageConverter.createImage(result);
        try {
            ImageIO.write(image, "png", new File("teams.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }


    private void proceedMakeTeam(List<PlayerProfile>[] teamList, int[] seed, PlayerProfile playerProfile, int teamsCount) {
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
}
