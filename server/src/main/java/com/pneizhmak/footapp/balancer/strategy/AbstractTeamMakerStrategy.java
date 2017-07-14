package com.pneizhmak.footapp.balancer.strategy;

import java.util.Collection;
import java.util.List;

import com.pneizhmak.footapp.balancer.model.AbstractTeamMakerModel;
import com.pneizhmak.footapp.db.model.Player;
import com.pneizhmak.footapp.db.model.PlayerProfile;
import com.pneizhmak.footapp.db.model.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public abstract class AbstractTeamMakerStrategy<T extends AbstractTeamMakerModel> implements TeamMakerStrategy {

    @Getter
    @Setter
    private T model;

    @Override
    public Collection<Team> execute(List<PlayerProfile> playerProfiles, int playersCount, int teamsCount) {
        getModel().init(playerProfiles, playersCount, teamsCount);
        while (hasMorePicks()) {
            defineTeamForPick();
            pickPlayer();
        }
        return getModel().getTeams();
    }

    protected boolean hasMorePicks() {
        return getModel().getPlayersPicked() < getModel().getPlayersCount();
    }

    protected void defineTeamForPick() {
        getModel().setCurrentTeam(getModel().getTeams().get(getModel().getCurrentTeamIndex()));
        getModel().setCurrentTeamIndex((getModel().getCurrentTeamIndex() + 1) % getModel().getTeamsCount());
    }

    protected void pickPlayer() {
        PlayerProfile playerProfile = findPlayerProfileToPick();
        getModel().getCurrentTeam().getPlayers().add(playerProfile);
        removeAllProfilesForPlayer(playerProfile.getPlayer());
        getModel().setPlayersPicked(getModel().getPlayersPicked() + 1);
    }

    protected PlayerProfile findPlayerProfileToPick() {
        return null;
    }

    private void removeAllProfilesForPlayer(Player player) {
        getModel().getPlayerProfiles().removeIf(profile -> profile.getPlayer().getId().equals(player.getId()));
    }

}
