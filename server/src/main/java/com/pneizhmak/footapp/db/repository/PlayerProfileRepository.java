package com.pneizhmak.footapp.db.repository;

import com.pneizhmak.footapp.db.model.PlayerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author Pavel Neizhmak
 */
public interface PlayerProfileRepository extends JpaRepository<PlayerProfile, Integer> {

//    todo: find by weight

    @Query("select pp from PlayerProfile pp")
    Stream<PlayerProfile> streamAllProfiles();

    @Query("select pp from PlayerProfile pp where pp.player.id in :playerIds")
    List<PlayerProfile> findProfilesByPlayerId(@Param("playerIds") List<Integer> playerIds);
}
