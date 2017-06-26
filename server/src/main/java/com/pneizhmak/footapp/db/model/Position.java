package com.pneizhmak.footapp.db.model;

import lombok.*;

import javax.persistence.*;

/**
 * @author Pavel Neizhmak
 */
@Entity
@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "position")
@TableGenerator(name = "position_table", allocationSize = 100)
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "position_table")
    @Getter
    private Integer id;

    @Getter
    @Setter
    @NonNull
    private String name;
}
