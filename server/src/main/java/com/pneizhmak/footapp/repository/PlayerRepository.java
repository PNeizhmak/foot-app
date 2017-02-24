package com.pneizhmak.footapp.repository;

import com.pneizhmak.footapp.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Pavel Neizhmak
 */
@RepositoryRestResource
public interface PlayerRepository extends JpaRepository<Player, Long> {
}