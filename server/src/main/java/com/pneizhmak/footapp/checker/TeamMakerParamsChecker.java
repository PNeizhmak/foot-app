package com.pneizhmak.footapp.checker;

import java.util.List;

import com.pneizhmak.footapp.db.model.PlayerProfile;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TeamMakerParamsChecker {

    public static boolean checkParams(List<PlayerProfile> playerProfiles, int playersCount, int teamsCount) {
        if (teamsCount < 2 || teamsCount > playersCount) {
            log.error("Wrong teamsCount = " + teamsCount);
            return false;
        }
        if (playersCount < 2) {
            log.error("Wrong playersCount = " + playersCount);
            return false;
        }
        if (playerProfiles == null || playerProfiles.isEmpty() || playerProfiles.size() < playersCount) {
            log.error("PlayerProfiles is empty or its size is incompatible. ");
            return false;
        }
        return true;
    }

}
