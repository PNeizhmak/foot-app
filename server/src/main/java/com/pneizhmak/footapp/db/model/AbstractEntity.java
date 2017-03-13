package com.pneizhmak.footapp.db.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author Pavel Neizhmak
 */
@MappedSuperclass
abstract class AbstractEntity {

    @Id
    @GeneratedValue
    @Getter
    @Setter
    Integer id;
}
