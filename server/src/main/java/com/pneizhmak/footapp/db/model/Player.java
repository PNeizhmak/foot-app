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
@EqualsAndHashCode
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "players")
@TableGenerator(name = "players_table", allocationSize = 100)
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "players_table")
    @Getter
    private Integer id;

    @Getter
    @Setter
    @NonNull
    private String name;

    @Getter
    @Setter
    @NonNull
    @Column(name = "parent_id")
    private Integer parentId;
}