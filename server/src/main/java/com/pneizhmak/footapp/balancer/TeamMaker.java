package com.pneizhmak.footapp.balancer;

import com.pneizhmak.footapp.db.model.PlayerProfile;
import com.pneizhmak.footapp.db.model.Team;

import java.util.Collection;
import java.util.List;

/**
 * @author Pavel Neizhmak
 */
public interface TeamMaker {

    Collection<Team> execute(List<PlayerProfile> playerProfiles, int playersCount, int teamsCount);
}
