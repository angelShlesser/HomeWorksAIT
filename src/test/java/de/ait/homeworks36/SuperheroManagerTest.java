package de.ait.homeworks36;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuperheroManagerTest {
    private SuperheroManager superheroManager;
    private Superhero superhero1;
    private Superhero superhero2;
    @BeforeEach
    void setUp() {
        superheroManager = new SuperheroManager();
        superhero1 = new Superhero("Superman", 10, 35);
        superhero2 = new Superhero("Spider-Man", 8, 30);
    }

    @Test
    void addSuperhero() {
        superheroManager.addSuperhero(superhero1);
        superheroManager.addSuperhero(superhero2);
        // Проверяем, что супергерои superhero1 и superhero2 присутствуют в списке
        assertTrue(superheroManager.getAllSuperheroes().contains(superhero1));
        assertTrue(superheroManager.getAllSuperheroes().contains(superhero2));
        // Проверяем, что супергерой с дублирующимся именем не был добавлен
        assertEquals(2, superheroManager.getAllSuperheroes().size());
    }

    @Test
    void removeSuperhero() {
        // Добавим несколько супергероев
        superheroManager.addSuperhero(superhero1);
        superheroManager.addSuperhero(superhero2);

        // Удалим супергероя по имени
        Superhero removedSuperhero = superheroManager.removeSuperhero("Superman");
        assertNotNull(removedSuperhero);
        assertEquals("Superman", removedSuperhero.getName());

        // Попробуем удалить несуществующего супергероя
        assertNull(superheroManager.removeSuperhero("Hulk"));
    }

    @Test
    void getSuperhero() {
        // Добавим несколько супергероев
        superheroManager.addSuperhero(superhero1);
        superheroManager.addSuperhero(superhero2);

        // Попробуем получить супергероя по имени
        Superhero foundSuperhero = superheroManager.getSuperhero("Superman");
        assertNotNull(foundSuperhero);
        assertEquals("Superman", foundSuperhero.getName());

        // Попробуем получить несуществующего супергероя
        assertNull(superheroManager.getSuperhero("Hulk"));
    }

    @Test
    void getAllSuperheroes() {
        Assertions.assertNull(superheroManager.getAllSuperheroes());
        // Добавим супергероев
        superheroManager.addSuperhero(superhero1);
        superheroManager.addSuperhero(superhero2);

        // Получим всех супергероев
        assertEquals(2, superheroManager.getAllSuperheroes().size());
    }
    @Test
    void updateSuperhero() {
        // Добавим супергероя с именем "Superman"
        superheroManager.addSuperhero(superhero1);

        // Создадим нового супергероя с тем же именем "Superman" и обновленными данными
        Superhero updatedSuperhero = new Superhero("Superman", 9, 32);

        // Обновим информацию о супергерое
        superheroManager.updateSuperhero("Superman", updatedSuperhero);

        // Получим обновленного супергероя
        Superhero retrievedSuperhero = superheroManager.getSuperhero("Superman");

        // Проверим, что информация о супергерое была успешно обновлена
        assertNotNull(retrievedSuperhero);
        assertEquals("Superman", retrievedSuperhero.getName());
        assertEquals(9, retrievedSuperhero.getPower());
        assertEquals(32, retrievedSuperhero.getAge());
    }
}