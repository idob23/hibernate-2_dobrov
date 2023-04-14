package com.javarush.dobrov.entity;

public enum Rating {

    G("G"),
    PG("PG"),
    PG13("PG-13"),
    RATING("R"),
    NC17("NC-17");

    private final String value;

    Rating(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
