package com.pneizhmak.footapp.db.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Collection;
import java.util.Map;

/**
 * @author Pavel Neizhmak
 */
@ToString
@Getter
@Setter
public class Team {

    @Getter
    @Setter
    Collection<PlayerProfile> players;

    @Getter
    @Setter
    Integer teamWeight;

    /**
     * BI part
     */
    Map<Integer, Integer> playerToGoal;
}
