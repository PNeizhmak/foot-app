package com.pneizhmak.footapp.db.model;

import lombok.*;

import javax.persistence.*;
import java.util.*;

/**
 * @author Pavel Neizhmak
 */
@Entity
@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "team")
@TableGenerator(name = "team_table", allocationSize = 100)
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "team_table")
    @Getter
    private Integer id;

    @Getter
    @Setter
    @ManyToMany
    @JoinTable
            (
                    name = "pp_in_team",
                    joinColumns = {@JoinColumn(name = "team_id", referencedColumnName = "id")},
                    inverseJoinColumns = {@JoinColumn(name = "pp_id", referencedColumnName = "id")}
            )
    private List<PlayerProfile> players;

    @Getter
    @Setter
    @Column(name = "team_weight")
    private Integer teamWeight;

    @Getter
    @Setter
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "game_id")
    private Game game;

    //  @Getter
//    @Setter
//    Map<Integer, Integer> playerToGoal;
}
