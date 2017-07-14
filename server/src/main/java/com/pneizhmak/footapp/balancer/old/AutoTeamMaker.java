package com.pneizhmak.footapp.balancer.old;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.pneizhmak.footapp.db.model.Player;
import com.pneizhmak.footapp.db.model.PlayerProfile;
import com.pneizhmak.footapp.db.model.Team;

public class AutoTeamMaker implements OldTeamMakerInterface {

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

        Map<String, List<PlayerProfile>> positionToProfile = playerProfiles.stream().collect(Collectors.groupingBy(
                (profile) -> profile.getPosition().getName(), Collectors.mapping((profile) -> profile, Collectors.toList())));

        final int[] seed = {0};

        while (teamList[teamsCount - 1].size() != playersInTeam) {
            positionToProfile.forEach((position, profiles) -> {

                removeSelectedProfiles(playersToDelete, profilesToDelete, profiles);

                if (!profiles.isEmpty()) {
                    @SuppressWarnings("ConstantConditions")
                    PlayerProfile playerProfile = profiles.stream().max(Comparator.comparing(PlayerProfile::getWeight)).get();
                    player[0] = playerProfile.getPlayer();
                    playersToDelete.add(player[0]);

                    proceedAutoBalance(teamList, seed, playerProfile, teamsCount);
                }
            });
        }

        produceTeams(result, teams, teamList);

        return result;
    }

    private void proceedAutoBalance(List<PlayerProfile>[] teamList, int[] seed, PlayerProfile playerProfile, int teamsCount) {
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
