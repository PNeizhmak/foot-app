package com.pneizhmak.footapp.service.impl;

import com.pneizhmak.footapp.balancer.AutoTeamBalancer;
import com.pneizhmak.footapp.balancer.PlayWithParentBalancer;
import com.pneizhmak.footapp.balancer.TeamBalancerFactory;
import com.pneizhmak.footapp.balancer.converter.TeamToPngConverter;
import com.pneizhmak.footapp.db.model.PlayerProfile;
import com.pneizhmak.footapp.db.model.Team;
import com.pneizhmak.footapp.db.repository.PlayerProfileRepository;
import com.pneizhmak.footapp.service.TeamBalancerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * @author Pavel Neizhmak
 */
@Service
@Transactional
public class TeamBalancerServiceImpl implements TeamBalancerService {

    @Resource
    private PlayerProfileRepository playerProfileRepository;

    @Override
    public Collection<Team> makeTeams(List<Integer> playerIds, int teamsCount, boolean balanceWithParent, boolean createPng) {

        List<PlayerProfile> profiles = playerProfileRepository.findProfilesByPlayerId(playerIds);

        TeamBalancerFactory teamBalancer;
        if (balanceWithParent) {
            teamBalancer = new TeamBalancerFactory(new PlayWithParentBalancer());
        } else {
            teamBalancer = new TeamBalancerFactory(new AutoTeamBalancer());
        }

        Collection<Team> result = teamBalancer.execute(profiles, playerIds.size(), teamsCount);

        if (createPng) {
            TeamToPngConverter.createImage(result);
        }

        return result;
    }
}
