package com.pneizhmak.footapp.balancer.factory;

import com.pneizhmak.footapp.balancer.DefaultTeamMaker;
import com.pneizhmak.footapp.balancer.TeamMaker;
import com.pneizhmak.footapp.balancer.strategy.GreedyTeamMakerStrategy;

public class TeamMakerFactory {

    public static TeamMaker getTeamMaker(boolean balanceWithParent) {
        return new DefaultTeamMaker(new GreedyTeamMakerStrategy());
//        if (balanceWithParent) {
//            return new PlayWithParentMaker();
//        } else {
//            return new AutoTeamMaker();
//        }
    }
}
