package com.pneizhmak.footapp.controller;

import com.pneizhmak.footapp.db.model.Player;
import com.pneizhmak.footapp.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Pavel Neizhmak
 */
@Controller
@RequestMapping("/players")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @ResponseBody
    @RequestMapping(value = "/save")
    public String savePlayer(@RequestParam String name, @RequestParam Integer relatedPlayerId) {

        Player player = new Player(name, relatedPlayerId);
        playerService.savePlayer(player);

        return "Player successfully saved!";
    }

    @ResponseBody
    @RequestMapping(value = "/edit")
    public String editPlayer(@RequestParam Integer id, @RequestParam String nameToSet) {

        Player player = playerService.getOne(id);
        player.setName(nameToSet);

        playerService.editPlayer(player);

        return "Player successfully edited!";
    }

    @ResponseBody
    @RequestMapping(value = "/all", produces = "application/json;charset=UTF-8")
    public Object[] getAll() {
        return playerService.findAll();
    }

    @ResponseBody
    @RequestMapping(value = "/delete")
    public String deletePlayer(@RequestParam int id) {
        playerService.deletePlayer(id);
        return "Player successfully deleted!";
    }

    @ResponseBody
    @RequestMapping(value = "/get-by-name", produces = "application/json;charset=UTF-8")
    public String getByName(@RequestParam String name) {
        Player player = playerService.findPlayerByName(name);
        return "Requested player is : " + player.getId() + "-" + player.getName();
    }

    @ResponseBody
    @RequestMapping(value = "/get-by-id", produces = "application/json;charset=UTF-8")
    public Player getById(@RequestParam int id) {
        return playerService.getOne(id);
    }
}