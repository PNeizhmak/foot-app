package com.pneizhmak.footapp.db.model;

import lombok.*;

import javax.persistence.*;

/**
 * @author Pavel Neizhmak
 */
@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "player_profile")
@TableGenerator(name = "player_profile_table", allocationSize = 100)
public class PlayerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "player_profile_table")
    @Getter
    Integer id;

    @Getter
    @Setter
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "player_id")
    private Player player;

    @Getter
    @Setter
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id")
    private Position position;

    @Getter
    @Setter
    private Integer weight;
}
