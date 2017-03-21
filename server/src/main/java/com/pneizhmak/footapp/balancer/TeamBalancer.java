package com.pneizhmak.footapp.balancer;

import com.pneizhmak.footapp.db.model.PlayerProfile;
import com.pneizhmak.footapp.db.model.Team;

import java.util.Collection;
import java.util.List;

/**
 * @author Pavel Neizhmak
 */
public class TeamBalancer {

    private TeamMaker teamMaker;

    public TeamBalancer(TeamMaker teamMaker) {
        this.teamMaker = teamMaker;
    }

    public Collection<Team> execute(List<PlayerProfile> playerProfiles, int playerCount, int teamsCount) {
        return teamMaker.execute(playerProfiles, playerCount, teamsCount);
    }
}
