package com.pneizhmak.footapp.service.impl;

import com.pneizhmak.footapp.db.model.Team;
import com.pneizhmak.footapp.db.repository.TeamRepository;
import com.pneizhmak.footapp.service.TeamService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Pavel Neizhmak
 */
@Service
@Transactional
public class TeamServiceImpl implements TeamService {

    @Resource
    private TeamRepository teamRepository;

    @Override
    public void saveTeam(Team team) {
        teamRepository.save(team);
    }

    @Override
    public Team editTeam(Team team) {
        return teamRepository.saveAndFlush(team);
    }

    @Override
    public Object[] findAll() {
        return teamRepository.streamAllTeams().toArray();
    }

    @Override
    public Team getOne(Integer id) {
        return teamRepository.findOne(id);
    }

    @Override
    public List<Team> findTeamsByGameId(Integer id) {
        return teamRepository.findTeamsByGameId(id);
    }
}
