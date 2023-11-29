package de.ait.enums;

public enum Seasons {
    WINTER("Холодно"), SPRING("Тепло"), SUMMER("Жарко"), AUTUMN("Сыро");

    private final String description;

    Seasons(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
