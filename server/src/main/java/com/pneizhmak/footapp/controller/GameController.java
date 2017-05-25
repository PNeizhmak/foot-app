package com.pneizhmak.footapp.controller;

import com.pneizhmak.footapp.db.model.*;
import com.pneizhmak.footapp.service.GameService;
import com.pneizhmak.footapp.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

/**
 * @author Pavel Neizhmak
 */
@Controller
@RequestMapping("/game")
public class GameController {

    private final GameService gameService;

    private final TeamService teamService;

    @Autowired
    public GameController(GameService gameService, TeamService teamService) {
        this.gameService = gameService;
        this.teamService = teamService;
    }


    @ResponseBody
    @RequestMapping(value = "/save")
    public String saveGame(@RequestParam String date, @RequestParam Collection<Team> teams) {

        Game game = new Game(date);
        final Game savedGame = gameService.saveGame(game);

        teams.forEach(team -> {
            team.setGame(savedGame);
            teamService.saveTeam(team);
        });

        return "Game and Team successfully saved!";
    }

    @ResponseBody
    @RequestMapping(value = "/find-teams-by-game-id", produces = "application/json;charset=UTF-8")
    public Object[] findTeamsByGameId(@RequestParam Integer gameId) {
        return teamService.findTeamsByGameId(gameId).toArray();
    }

    @ResponseBody
    @RequestMapping(value = "/get-team", produces = "application/json;charset=UTF-8")
    public String getTeam(@RequestParam Integer teamId) {
        return teamService.getOne(teamId).toString();
    }

    @ResponseBody
    @RequestMapping(value = "/edit-team")
    public String editTeam(@RequestParam Integer teamId) {

        return "Unsupported!";
    }

    @ResponseBody
    @RequestMapping(value = "/edit-game")
    public Game editGame(@RequestParam Integer gameId, @RequestParam String gameDate) {

        final Game game = gameService.getOne(gameId);
        game.setGameDate(gameDate);

        return gameService.editGame(game);
    }

    @ResponseBody
    @RequestMapping(value = "/all", produces = "application/json;charset=UTF-8")
    public Object[] getAll() {
        return teamService.findAll();
    }
}
