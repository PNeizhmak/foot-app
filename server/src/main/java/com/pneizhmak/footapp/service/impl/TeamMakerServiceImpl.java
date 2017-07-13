package com.pneizhmak.footapp.service.impl;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import com.pneizhmak.footapp.balancer.TeamMaker;
import com.pneizhmak.footapp.balancer.TeamMakerFactory;
import com.pneizhmak.footapp.balancer.converter.TeamToPngConverter;
import com.pneizhmak.footapp.db.model.PlayerProfile;
import com.pneizhmak.footapp.db.model.Team;
import com.pneizhmak.footapp.db.repository.PlayerProfileRepository;
import com.pneizhmak.footapp.service.TeamMakerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TeamMakerServiceImpl implements TeamMakerService {

    @Resource
    private PlayerProfileRepository playerProfileRepository;

    @Override
    public Collection<Team> makeTeams(List<Integer> playerIds, int teamsCount, boolean balanceWithParent, boolean createPng) {

        List<PlayerProfile> profiles = playerProfileRepository.findProfilesByPlayerId(playerIds);

        TeamMaker teamMaker = TeamMakerFactory.getTeamMaker(balanceWithParent);

        Collection<Team> result = teamMaker.makeTeams(profiles, playerIds.size(), teamsCount);

        if (createPng) {
            TeamToPngConverter.createImage(result);
        }

        return result;
    }
}
