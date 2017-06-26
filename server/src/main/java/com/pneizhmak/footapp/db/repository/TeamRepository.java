package com.pneizhmak.footapp.db.repository;

import com.pneizhmak.footapp.db.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author Pavel Neizhmak
 */
public interface TeamRepository extends JpaRepository<Team, Integer> {

    @Query("select t from Team t where t.game.id = :gameId")
    List<Team> findTeamsByGameId(@Param("gameId") Integer gameId);

    @Query("select t from Team t")
    Stream<Team> streamAllTeams();
}
