package com.pneizhmak.footapp.controller;

import com.pneizhmak.footapp.db.model.Team;
import com.pneizhmak.footapp.service.TeamMakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.List;

/**
 * @author Pavel Neizhmak
 */
@Controller
@RequestMapping("/team-balancer")
public class TeamBalancerController {

    private final TeamMakerService teamMakerService;

    @Autowired
    public TeamBalancerController(TeamMakerService teamMakerService) {
        this.teamMakerService = teamMakerService;
    }

    @ResponseBody
    @RequestMapping(value = "/makeTeams", produces = "application/json;charset=UTF-8")
    public Collection<Team> makeTeams(@RequestParam List<Integer> playerIds,
                                      @RequestParam int teamsCount,
                                      @RequestParam boolean balanceWithParent,
                                      @RequestParam boolean createPng) {

        return teamMakerService.makeTeams(playerIds, teamsCount, balanceWithParent, createPng);
    }
}
