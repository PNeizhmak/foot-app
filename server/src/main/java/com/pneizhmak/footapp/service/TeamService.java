package com.pneizhmak.footapp.service;

import com.pneizhmak.footapp.db.model.Team;

import java.util.List;

/**
 * @author Pavel Neizhmak
 */
public interface TeamService {

    void saveTeam(Team team);

    Team editTeam(Team team);

    Object[] findAll();

    Team getOne(Integer id);

    List<Team> findTeamsByGameId(Integer id);
}
