package com.pneizhmak.footapp.balancer.model;

import lombok.Getter;
import lombok.Setter;

public class GreedyTeamMakerModel extends AbstractTeamMakerModel {
    @Getter
    @Setter
    private int startingTeamIndexThisRound = 0;
}
