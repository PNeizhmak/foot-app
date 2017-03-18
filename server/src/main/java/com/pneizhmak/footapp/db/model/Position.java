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
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "position")
@TableGenerator(name="position_table", allocationSize=100)
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "position_table")
    @Getter
    Integer id;

    @Getter
    @Setter
    @NonNull
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Objects.equals(id, position.id) &&
                Objects.equals(name, position.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
