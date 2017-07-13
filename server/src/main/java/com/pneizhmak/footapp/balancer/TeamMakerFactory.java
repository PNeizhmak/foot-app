package com.pneizhmak.footapp.balancer;

public class TeamMakerFactory {

    public static TeamMaker getTeamMaker(boolean balanceWithParent) {
        if (balanceWithParent) {
            return new PlayWithParentMaker();
        } else {
            return new AutoTeamMaker();
        }
    }
}
