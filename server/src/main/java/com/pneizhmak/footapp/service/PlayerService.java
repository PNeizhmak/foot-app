package com.pneizhmak.footapp.service;

import com.pneizhmak.footapp.db.model.Player;

/**
 * @author Pavel Neizhmak
 */
public interface PlayerService {

    Object[] findAll();

    void savePlayer(Player player);

    void deletePlayer(Integer id);

    Player findPlayerByName(String name);

    Player editPlayer(Player player);

    Player getOne(Integer id);
}
