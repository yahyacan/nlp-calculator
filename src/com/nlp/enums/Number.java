package com.nlp.enums;

/**
 * @author yahya
 */
public enum Number {

    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10);

    private int value;

    Number(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Number findByName(String name) {
        for (Number number : Number.values()) {
            if (number.name().equalsIgnoreCase(name))
                return number;
        }
        return null;
    }
}
