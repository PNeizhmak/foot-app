package com.pneizhmak.footapp.db.repository;

import com.pneizhmak.footapp.db.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Pavel Neizhmak
 */
public interface GameRepository extends JpaRepository<Game, Integer> {
}
