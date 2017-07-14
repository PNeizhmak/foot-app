package com.pneizhmak.footapp.balancer.strategy;

import java.security.InvalidParameterException;
import java.util.Comparator;
import java.util.Optional;

import com.pneizhmak.footapp.balancer.model.GreedyTeamMakerModel;
import com.pneizhmak.footapp.db.model.PlayerProfile;

public class GreedyTeamMakerStrategy extends AbstractTeamMakerStrategy<GreedyTeamMakerModel> {

    public GreedyTeamMakerStrategy() {
        super(new GreedyTeamMakerModel());
    }

    @Override
    protected void defineTeamForPick() {
        getModel().setCurrentTeam(getModel().getTeams().get(getModel().getCurrentTeamIndex()));
        //condition means new round
        if (getModel().getPlayersPicked() > 0 && getModel().getPlayersPicked() % getModel().getTeamsCount() == 0) {
            getModel().setStartingTeamIndexThisRound((getModel().getStartingTeamIndexThisRound() + 1) % getModel().getTeamsCount());
            getModel().setCurrentTeamIndex(getModel().getStartingTeamIndexThisRound());
        } else {
            getModel().setCurrentTeamIndex((getModel().getCurrentTeamIndex() + 1) % getModel().getTeamsCount());
        }
    }

    @Override
    protected PlayerProfile findPlayerProfileToPick() {
        Optional<PlayerProfile> playerProfile = getModel().getPlayerProfiles().stream().max(Comparator.comparing(PlayerProfile::getWeight));
        if (playerProfile.isPresent()) {
            return playerProfile.get();
        } else {
            throw new InvalidParameterException("Something went wrong during get max profile.");
        }
    }

}
