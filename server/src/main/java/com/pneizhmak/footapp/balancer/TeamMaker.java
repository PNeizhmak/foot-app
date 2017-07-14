package com.pneizhmak.footapp.balancer;

import java.util.Collection;
import java.util.List;

import com.pneizhmak.footapp.db.model.PlayerProfile;
import com.pneizhmak.footapp.db.model.Team;

public interface TeamMaker {
    Collection<Team> makeTeams(List<PlayerProfile> playerProfiles, int playersCount, int teamsCount);
}
