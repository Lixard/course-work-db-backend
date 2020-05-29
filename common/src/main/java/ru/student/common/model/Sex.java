package ru.student.common.model;

import java.util.Optional;

public enum Sex {

    MALE("M"),
    FEMALE("F"),
    UNDEFINED("U"),
    ;

    private final String literal;

    Sex(final String literal) {
        this.literal = literal;
    }

    public static Optional<Sex> of(final String literal) {
        if (literal == null) {
            return Optional.empty();
        }

        for (var value : Sex.values()) {
            if (value.literal.equals(literal)) {
                return Optional.of(value);
            }
        }

        return Optional.empty();
    }

    public String getLiteral() {
        return literal;
    }
}
