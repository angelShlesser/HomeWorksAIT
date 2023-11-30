package de.ait.homeworks54;

public class Album {
    private String title;
    private String artist;
    private MusicGenre genre;

    public Album(String title, String artist, MusicGenre genre) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public MusicGenre getGenre() {
        return genre;
    }
}