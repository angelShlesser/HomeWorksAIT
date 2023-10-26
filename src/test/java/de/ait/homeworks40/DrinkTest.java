package de.ait.homeworks40;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class DrinkTest {
    private Drink drink;

    @BeforeEach
    void setUp() {
        drink = new Drink("Coca Cola", "безалкогольный", 330.0);
    }
    @Test
    void setDrink(){
        Assertions.assertEquals("Coca Cola", drink.getName());
        Assertions.assertEquals("безалкогольный", drink.getType());
        Assertions.assertEquals(330.0, drink.getVolume());
    }
}