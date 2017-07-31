package com.pneizhmak.footapp.balancer.strategy;

import java.util.Random;

import com.pneizhmak.footapp.balancer.model.AbstractTeamMakerModel;
import com.pneizhmak.footapp.db.model.PlayerProfile;

public class RandomTeamMakerStrategy extends AbstractTeamMakerStrategy<AbstractTeamMakerModel> {

    private Random random = new Random();

    public RandomTeamMakerStrategy(AbstractTeamMakerModel model) {
        super(model);
    }

    @Override
    protected PlayerProfile findPlayerProfileToPick() {
        return getModel().getPlayerProfiles().get(random.nextInt(getModel().getPlayerProfiles().size()));
    }

}
