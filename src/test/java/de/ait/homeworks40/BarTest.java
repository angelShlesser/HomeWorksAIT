package de.ait.homeworks40;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BarTest {
    private Bar bar;
    private Drink drink;
    private Drink drink2;
    @BeforeEach
    void setUp() {
        bar = new Bar();
        drink = new Drink("Coca Cola", "безалкогольный", 330.0);
        drink2= new Drink("Pepsi", "безалкогольный", 355.0);
    }
    @Test
    void testAddDrink() {
        bar.addDrink("drink1", drink);
        Assertions.assertEquals(drink,bar.getDrink("drink1"));
    }
    @Test
    void testAddDrinkWithExistingID() {
        bar.addDrink("drink1", drink);
        // Попытка добавить напиток с тем же ID
        bar.addDrink("drink1", drink2);
        // Должно быть добавлено только первое значение
        Assertions.assertEquals(drink, bar.getDrink("drink1"));
    }

    @Test
    void testGetDrink() {
        bar.addDrink("drink1", drink);
        Assertions.assertEquals(drink, bar.getDrink("drink1"));
    }

    @Test
    void testGetNonExistingDrink() {
        Assertions.assertNull(bar.getDrink("nonexistent"));
    }
}