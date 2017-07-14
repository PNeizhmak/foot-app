package com.pneizhmak.footapp.service;

import com.pneizhmak.footapp.db.model.Team;

import java.util.Collection;
import java.util.List;

public interface TeamMakerService {

    Collection<Team> makeTeams(List<Integer> playerIds, int teamsCount, boolean balanceWithParent, boolean createPng);
}
