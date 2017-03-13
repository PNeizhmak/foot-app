package com.pneizhmak.footapp.db.repository;

import com.pneizhmak.footapp.db.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.stream.Stream;

/**
 * @author Pavel Neizhmak
 */
public interface PlayerRepository extends JpaRepository<Player, Integer> {

    @Query("select p from Player p where p.name = :name")
    Player findByName(@Param("name") String name);

    default Player findByName(Player player) {
        return findByName(player == null ? null : player.getName());
    }

    @Query("select p from Player p")
    Stream<Player> streamAllPlayers();
}