package com.pneizhmak.footapp.db.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * @author Pavel Neizhmak
 */
@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "players")
public class Player extends AbstractEntity {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    @ElementCollection(targetClass = PlayerPosition.class)
    @CollectionTable(name = "players_position",
            joinColumns = @JoinColumn(name = "player_id"))
    @Column(name = "position_id")
    @Convert(converter = PlayerPositionConverter.class)
    private Set<PlayerPosition> positions;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) &&
                Objects.equals(positions, player.positions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, positions);
    }
}