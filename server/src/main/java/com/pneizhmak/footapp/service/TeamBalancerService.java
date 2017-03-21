package com.pneizhmak.footapp.service;

import com.pneizhmak.footapp.db.model.Team;

import java.util.Collection;
import java.util.List;

/**
 * @author Pavel Neizhmak
 */
public interface TeamBalancerService {

    Collection<Team> makeTeams(List<Integer> playerIds, int teamsCount);
}
