package com.pneizhmak.footapp.balancer;

import java.util.Collection;
import java.util.List;

import com.pneizhmak.footapp.balancer.strategy.TeamMakerStrategy;
import com.pneizhmak.footapp.db.model.PlayerProfile;
import com.pneizhmak.footapp.db.model.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class DefaultTeamMaker implements TeamMaker {

    @Getter
    @Setter
    private TeamMakerStrategy strategy;

    @Override
    public Collection<Team> makeTeams(List<PlayerProfile> playerProfiles, int playersCount, int teamsCount) {
        Collection<Team> teams = getStrategy().execute(playerProfiles, playersCount, teamsCount);
        fillWeights(teams);
        return teams;
    }

    private void fillWeights(Collection<Team> teams) {
        teams.forEach(team -> team.setTeamWeight(team.getPlayers().stream().mapToInt(PlayerProfile::getWeight).sum()));
    }
}
