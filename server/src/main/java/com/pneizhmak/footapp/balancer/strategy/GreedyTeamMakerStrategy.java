package com.pneizhmak.footapp.balancer.strategy;

import java.security.InvalidParameterException;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        if ((getModel().getPlayersPicked() + 1) % getModel().getTeamsCount() == 0) {
            getModel().setStartingTeamIndexThisRound((getModel().getStartingTeamIndexThisRound() + 1) % getModel().getTeamsCount());
            getModel().setCurrentTeamIndex(getModel().getStartingTeamIndexThisRound());
        } else {
            getModel().setCurrentTeamIndex((getModel().getCurrentTeamIndex() + 1) % getModel().getTeamsCount());
        }
    }

    @Override
    protected PlayerProfile findPlayerProfileToPick() {
        // Pick maximum weight for not existing position in team.
        // If all positions exist, then pick maximum weight between all positions
        Stream<PlayerProfile> stream = getModel().getPlayerProfiles().stream();
        if (existPositionNotFilledInTeam()) {
            stream = stream
                .filter(playerProfile1 -> !getModel().getCurrentTeam()
                                                     .getPlayers()
                                                     .stream()
                                                     .collect(Collectors.groupingBy(PlayerProfile::getPosition))
                                                     .containsKey(playerProfile1.getPosition()));
        }
        Optional<PlayerProfile> playerProfile = stream.max(Comparator.comparing(PlayerProfile::getWeight));
        if (playerProfile.isPresent()) {
            return playerProfile.get();
        } else {
            throw new InvalidParameterException("Something went wrong during get max profile.");
        }
    }

    private boolean existPositionNotFilledInTeam() {
        return getModel().getPlayerProfiles().stream()
                         .collect(Collectors.groupingBy(PlayerProfile::getPosition))
                         .keySet()
                         .stream()
                         .filter(position -> !getModel().getCurrentTeam().getPlayers().stream()
                                                        .collect(Collectors.groupingBy(PlayerProfile::getPosition))
                                                        .keySet()
                                                        .contains(position))
                         .count() > 0;
    }

}
