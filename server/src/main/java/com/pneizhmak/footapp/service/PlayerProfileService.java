package com.pneizhmak.footapp.service;

import com.pneizhmak.footapp.db.model.PlayerProfile;

/**
 * @author Pavel Neizhmak
 */
public interface PlayerProfileService {

    void savePlayerProfile(PlayerProfile playerProfile);

    Object[] findAll();

    void deletePlayerProfile(Integer id);

    PlayerProfile editPlayerProfile(PlayerProfile playerProfile);
}
