package com.pneizhmak.footapp.service;

import com.pneizhmak.footapp.db.model.Player;

import java.util.List;

/**
 * @author Pavel Neizhmak
 */
public interface PlayerService {

    List<Player> findAll();

    void savePlayer(Player player);

    void deletePlayer(Integer id);

    Player findPlayerByName(String name);

    Player editPlayer(Player player);
}
