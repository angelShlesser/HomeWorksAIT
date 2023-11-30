package de.ait.homeworks54;

import java.util.List;

public class MusicLibraryTest {
    public static void main(String[] args) {
        // Создаем объект MusicLibrary
        MusicLibrary library = new MusicLibrary();

        // Создаем несколько тестовых альбомов
        Album album1 = new Album("Thriller", "Michael Jackson", MusicGenre.POP);
        Album album2 = new Album("Back in Black", "AC/DC", MusicGenre.ROCK);
        Album album3 = new Album("Kind of Blue", "Miles Davis", MusicGenre.JAZZ);

        // Добавляем альбомы в библиотеку
        library.addAlbum(album1);
        library.addAlbum(album2);
        library.addAlbum(album3);

        // Ищем альбомы в жанре POP
        MusicGenre searchGenre = MusicGenre.POP;
        List<Album> popAlbums = library.getAlbumsByGenre(searchGenre);

        // Выводим результаты тестирования
        System.out.println("Альбомы в жанре " + searchGenre + ":");
        for (Album album : popAlbums) {
            System.out.println("Название: " + album.getTitle() + ", Артист: " + album.getArtist());
        }
    }
}
