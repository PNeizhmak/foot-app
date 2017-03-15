package com.pneizhmak.footapp.controller;

import com.pneizhmak.footapp.db.model.Player;
import com.pneizhmak.footapp.db.model.PlayerPosition;
import com.pneizhmak.footapp.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.HashSet;

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
    public String savePlayer(@RequestParam String name) {

        Player player = new Player(name, new HashSet<PlayerPosition>() {{
            add(PlayerPosition.UNIVERSAL);
        }});
        playerService.savePlayer(player);

        return "User successfully saved!";
    }

    @ResponseBody
    @RequestMapping(value = "/all")
    public String getAll() {
        return Arrays.toString(playerService.findAll());
    }

    @ResponseBody
    @RequestMapping(value = "/delete")
    public String deletePlayer(@RequestParam int id) {
        playerService.deletePlayer(id);
        return "User successfully deleted!";
    }

    @ResponseBody
    @RequestMapping(value = "/get-by-name")
    public String getByName(@RequestParam String name) {
        Player player = playerService.findPlayerByName(name);
        return "Requested player is : " + player.getId() + "-" + player.getName();
    }
}