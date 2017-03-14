package com.pneizhmak.footapp.db.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/**
 * @author Pavel Neizhmak
 */
@AllArgsConstructor
public enum PlayerPosition {

    GOALKEEPER("goalkeeper"),
    DEFENDER("defender"),
    MIDFIELD("midfield"),
    FORWARD("forward"),
    UNIVERSAL("universal");

    @Getter
    private final String playerPosition;

    static {
        List<PlayerPosition> values = Arrays.asList(PlayerPosition.values());
        values.forEach(value -> setEnumOrdinal(value, value.ordinal() + 1));
    }

    public static void setEnumOrdinal(Enum object, int ordinalToSet) {
        Field field;
        try {
            field = object.getClass().getSuperclass().getDeclaredField("ordinal");
            field.setAccessible(true);
            field.set(object, ordinalToSet);
        } catch (Exception ex) {
            throw new RuntimeException("Can't update enum ordinal: " + ex);
        }
    }
}
