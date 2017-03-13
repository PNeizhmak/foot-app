package com.pneizhmak.footapp.service.impl;

import com.pneizhmak.footapp.db.model.Player;
import com.pneizhmak.footapp.db.repository.PlayerRepository;
import com.pneizhmak.footapp.service.PlayerService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Pavel Neizhmak
 */
@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {

    @Resource
    private PlayerRepository playerRepository;

    @Override
    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    @Override
    public void savePlayer(Player player) {
        playerRepository.save(player);
    }

    @Override
    public void deletePlayer(Integer id) {
        playerRepository.delete(id);
    }

    @Override
    public Player findPlayerByName(String name) {
        return playerRepository.findByName(name);
    }

    @Override
    public Player editPlayer(Player player) {
        return playerRepository.saveAndFlush(player);
    }

    @Cacheable("players")
    public Player findOne(Integer id) {
        return playerRepository.findOne(id);
    }
}
