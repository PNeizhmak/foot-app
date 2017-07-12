package com.pneizhmak.footapp.controller.model;

import com.pneizhmak.footapp.db.model.Team;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

/**
 * @author Pavel Neizhmak
 */
public class GameDetails {

    @Getter
    @Setter
    private String date;

    @Getter
    @Setter
    private String time;

    @Getter
    @Setter
    private Collection<Team> teams;
}
