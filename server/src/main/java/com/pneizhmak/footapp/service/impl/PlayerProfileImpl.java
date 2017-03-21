package com.pneizhmak.footapp.service.impl;

import com.pneizhmak.footapp.db.model.PlayerProfile;
import com.pneizhmak.footapp.db.repository.PlayerProfileRepository;
import com.pneizhmak.footapp.service.PlayerProfileService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Pavel Neizhmak
 */
@Service
@Transactional
public class PlayerProfileImpl implements PlayerProfileService {

    @Resource
    private PlayerProfileRepository playerProfileRepository;

    @Override
    public void savePlayerProfile(PlayerProfile playerProfile) {
        playerProfileRepository.save(playerProfile);
    }

    @Override
    public Object[] findAll() {
        return playerProfileRepository.streamAllProfiles().toArray();
    }

    @Override
    public void deletePlayerProfile(Integer id) {

    }

    @Override
    public PlayerProfile editPlayerProfile(PlayerProfile playerProfile) {
        return null;
    }
}
