package com.pneizhmak.footapp.db.repository;

import com.pneizhmak.footapp.db.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.stream.Stream;

/**
 * @author Pavel Neizhmak
 */
public interface PositionRepository extends JpaRepository<Position, Integer> {

    @Query("select p from Position p where p.name = :name")
    Position findByName(@Param("name") String name);

    default Position findByName(Position position) {
        return findByName(position == null ? null : position.getName());
    }

    @Query("select p from Position p")
    Stream<Position> streamAllPositions();
}
