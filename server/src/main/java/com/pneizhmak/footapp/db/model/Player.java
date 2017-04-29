package com.pneizhmak.footapp.db.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Pavel Neizhmak
 */
@Entity
@Getter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "players")
@TableGenerator(name="players_table", allocationSize=100)
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "players_table")
    @Getter
    Integer id;

    @Getter
    @Setter
    @NonNull
    private String name;

    @Getter
    @Setter
    @NonNull
    @Column(name = "parent_id")
    private Integer parentId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(id, player.id) &&
                Objects.equals(name, player.name) &&
                Objects.equals(parentId, player.parentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, parentId);
    }
}