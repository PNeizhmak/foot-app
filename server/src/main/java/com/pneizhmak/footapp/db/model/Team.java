package com.pneizhmak.footapp.db.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Map;

/**
 * @author Pavel Neizhmak
 */
public class Team {

    @Getter
    @Setter
    Collection<Player> players;

    /**
     * BI part
     */
    Map<Integer, Integer> playerToGoal;
}
