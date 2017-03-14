package com.pneizhmak.footapp.db.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author Pavel Neizhmak
 */
@Converter(autoApply = true)
public class PlayerPositionConverter implements AttributeConverter<PlayerPosition, Integer> {

    @Override
    public Integer convertToDatabaseColumn(PlayerPosition attribute) {
        switch (attribute) {
            case GOALKEEPER:
                return 1;
            case DEFENDER:
                return 2;
            case MIDFIELD:
                return 3;
            case FORWARD:
                return 4;
            case UNIVERSAL:
                return 5;
            default:
                throw new IllegalArgumentException("Unknown value: " + attribute);
        }
    }

    @Override
    public PlayerPosition convertToEntityAttribute(Integer dbData) {
        switch (dbData) {
            case 1:
                return PlayerPosition.GOALKEEPER;
            case 2:
                return PlayerPosition.DEFENDER;
            case 3:
                return PlayerPosition.MIDFIELD;
            case 4:
                return PlayerPosition.FORWARD;
            case 5:
                return PlayerPosition.UNIVERSAL;
            default:
                throw new IllegalArgumentException("Unknown value: " + dbData);
        }
    }
}
