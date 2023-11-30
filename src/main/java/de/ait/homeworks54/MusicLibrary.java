package de.ait.homeworks54;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class MusicLibrary {
    private static final Logger LOGGER = LoggerFactory.getLogger(MusicLibrary.class);
    private List<Album> albums;

    public MusicLibrary() {
        // Инициализация списка альбомов при создании объекта
        this.albums = new ArrayList<>();
    }

    // Добавление альбома в библиотеку
    public void addAlbum(Album album) {
        albums.add(album);
        LOGGER.info("Добавлен новый альбом: {}", album.getTitle());
    }

    // Получение списка альбомов по указанному жанру
    public List<Album> getAlbumsByGenre(MusicGenre genre) {
        List<Album> result = new ArrayList<>();
        for (Album album : albums) {
            if (album.getGenre() == genre) {
                result.add(album);
            }
        }
        LOGGER.info("Получены альбомы в жанре {}: {}", genre, result.size());
        return result;
    }
}
