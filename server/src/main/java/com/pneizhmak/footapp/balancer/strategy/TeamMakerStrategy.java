package com.pneizhmak.footapp.balancer.strategy;

import java.util.Collection;
import java.util.List;

import com.pneizhmak.footapp.db.model.PlayerProfile;
import com.pneizhmak.footapp.db.model.Team;

public interface TeamMakerStrategy {
    Collection<Team> execute(List<PlayerProfile> playerProfiles, int playersCount, int teamsCount);
}
