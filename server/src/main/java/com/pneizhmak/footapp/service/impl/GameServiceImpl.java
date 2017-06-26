package com.pneizhmak.footapp.service.impl;

import com.pneizhmak.footapp.db.model.Game;
import com.pneizhmak.footapp.db.repository.GameRepository;
import com.pneizhmak.footapp.service.GameService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Pavel Neizhmak
 */
@Service
@Transactional
public class GameServiceImpl implements GameService {

    @Resource
    private GameRepository gameRepository;

    @Override
    public Game saveGame(Game game) {
        return gameRepository.saveAndFlush(game);
    }

    @Override
    public Game editGame(Game game) {
        return gameRepository.saveAndFlush(game);
    }

    @Override
    public Object[] findAll() {
        return gameRepository.findAll().toArray();
    }

    @Override
    public Game getOne(Integer id) {
        return gameRepository.getOne(id);
    }
}
