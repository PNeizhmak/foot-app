package com.pneizhmak.footapp.controller;

import com.pneizhmak.footapp.db.model.Player;
import com.pneizhmak.footapp.db.model.PlayerProfile;
import com.pneizhmak.footapp.db.model.Position;
import com.pneizhmak.footapp.service.PlayerProfileService;
import com.pneizhmak.footapp.service.PlayerService;
import com.pneizhmak.footapp.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Pavel Neizhmak
 */
@Controller
@RequestMapping("/player-profile")
public class PlayerProfileController {

    private final PlayerProfileService playerProfileService;

    private final PlayerService playerService;

    private final PositionService positionService;

    @Autowired
    public PlayerProfileController(PlayerProfileService playerProfileService, PlayerService playerService, PositionService positionService) {
        this.playerProfileService = playerProfileService;
        this.playerService = playerService;
        this.positionService = positionService;
    }

    @ResponseBody
    @RequestMapping(value = "/save")
    public String savePlayerProfile(
            @RequestParam Integer playerId,
            @RequestParam Integer positionId,
            @RequestParam Integer weight) {

        try {
            Player player = playerService.getOne(playerId);
            Position position = positionService.getOne(positionId);

            PlayerProfile playerProfile = new PlayerProfile();

            playerProfile.setPlayer(player);
            playerProfile.setPosition(position);
            playerProfile.setWeight(weight);

            playerProfileService.savePlayerProfile(playerProfile);
        } catch (Exception ex) {
            return "Smth went wrong, look at application flow or/and request params";
        }
        return "Player Profile successfully saved!";
    }

    @ResponseBody
    @RequestMapping(value = "/all", produces = "application/json;charset=UTF-8")
    public Object[] getAll() {
        return playerProfileService.findAll();
    }
}
