package com.pneizhmak.footapp.service;

import com.pneizhmak.footapp.db.model.Game;

/**
 * @author Pavel Neizhmak
 */
public interface GameService {

    Game saveGame(Game game);

    Game editGame(Game game);

    Object[] findAll();

    Game getOne(Integer id);
}
