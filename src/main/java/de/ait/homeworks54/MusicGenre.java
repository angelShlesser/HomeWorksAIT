package de.ait.homeworks54;

public enum MusicGenre {
    POP("Popular and mainstream music"),
    ROCK("Rock and roll"),
    JAZZ("Jazz improvisation"),
    CLASSICAL("Classical orchestral music"),
    ELECTRONIC("Electronic dance music"),
    HIPHOP("Hip hop and rap");

    private final String description;

    MusicGenre(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

