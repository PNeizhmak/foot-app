package com.pneizhmak.footapp.db.model;

import lombok.*;

import javax.persistence.*;

/**
 * @author Pavel Neizhmal
 */
@Entity
@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "game")
@TableGenerator(name = "game_table", allocationSize = 100)
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "game_table")
    @Getter
    private Integer id;

    @Getter
    @Setter
    @NonNull
    @Column(name = "game_date")
    String gameDate;

    @Getter
    @Setter
    @NonNull
    @Column(name = "game_time")
    String gameTime;

    @Getter
    @Setter
    @Column(name = "game_result")
    String gameResult = "0 - 0";
}
