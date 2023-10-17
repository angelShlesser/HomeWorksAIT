package de.ait.homeworks36;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    void testAddSuperhero() {
        assertTrue(superheroManager.addSuperhero(superhero1));
        assertTrue(superheroManager.addSuperhero(superhero2));

        // Попробуем добавить супергероя с тем же именем (не должен добавиться)
        assertTrue(superheroManager.addSuperhero(new Superhero("Superman", 9, 32)));
    }
    @Test
    void testAddSuperheronDouble(){
       superheroManager.addSuperhero(superhero1);
       assertFalse(superheroManager.addSuperhero(superhero1));
    }
    @Test
    @DisplayName("Обновление силы более 10")
    void testPowerUpdate(){
        Superhero superheroBatgirl = new Superhero("Batgirl", 100, 29);
        assertEquals(10,superheroBatgirl.getPower());
        superheroBatgirl.setPower(100);
        assertEquals(10,superheroBatgirl.getPower());
    }

    @Test
    @DisplayName("Обновление силы более 10")
    void testPowerUpdateLess(){
        Superhero superheroBatgirl = new Superhero("Batgirl", -14, 29);
        assertEquals(1,superheroBatgirl.getPower());
        superheroBatgirl.setPower(-54);
        assertEquals(1,superheroBatgirl.getPower());
    }

    @Test
    void testRemoveSuperhero() {
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
    void testGetSuperhero() {
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
    void testGetAllSuperheroes() {
        Assertions.assertNull(superheroManager.getAllSuperheroes());
        // Добавим супергероев
        superheroManager.addSuperhero(superhero1);
        superheroManager.addSuperhero(superhero2);

        // Получим всех супергероев
        assertEquals(2, superheroManager.getAllSuperheroes().size());
    }

    @Test
    void testUpdateSuperhero() {
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
    @Test
    void testToString(){
        superheroManager.addSuperhero(superhero1);
        String result = "Имя: [Superman] Сила: [10] Возраст: [35]";
        String resultSuperManager = "[Имя: [Superman] Сила: [10] Возраст: [35]]";
        assertEquals(result, superhero1.toString());
        assertEquals(resultSuperManager,superheroManager.toString());
    }
}