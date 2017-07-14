package com.pneizhmak.footapp.balancer.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.pneizhmak.footapp.db.model.PlayerProfile;
import com.pneizhmak.footapp.db.model.Team;
import lombok.Getter;
import lombok.Setter;

public abstract class AbstractTeamMakerModel {
    @Getter
    @Setter
    private int playersPicked = 0;
    @Getter
    @Setter
    private int playersCount = 0;
    @Getter
    @Setter
    private int currentTeamIndex = 0;
    @Getter
    @Setter
    private int teamsCount = 0;
    @Getter
    @Setter
    private List<PlayerProfile> playerProfiles = new ArrayList<>();
    @Getter
    @Setter
    private List<Team> teams = new ArrayList<>();
    @Getter
    @Setter
    private Team currentTeam;

    public void init(List<PlayerProfile> playerProfiles, int playersCount, int teamsCount) {
        setPlayerProfiles(playerProfiles);
        setPlayersCount(playersCount);
        setTeamsCount(teamsCount);
        initTeams(teamsCount);
    }

    private void initTeams(int teamsCount) {
        for (int i = 0; i < teamsCount; i++) {
            Team team = new Team();
            team.setPlayers(new LinkedList<>());
            teams.add(team);
        }
    }
}
