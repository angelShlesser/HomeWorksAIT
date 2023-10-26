package de.ait.homeworks40;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

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
    void testAddDrinkSuccess() {
        Map<String,Drink> resultAllDrinks = bar.getDrinkCollection();
        Assertions.assertEquals(0,resultAllDrinks.size());
        Assertions.assertTrue(bar.addDrink("1",drink));
        resultAllDrinks =bar.getDrinkCollection();
        Assertions.assertEquals(1,resultAllDrinks.size());

    }
    @Test
    void testAddDrinkDoubleID() {
        bar.addDrink("drink1", drink);
        // Попытка добавить напиток с тем же ID
        bar.addDrink("drink1", drink2);
        // Должно быть добавлено только первое значение
        Assertions.assertEquals(drink, bar.getDrink("drink1"));
    }
    @Test
    void testAddIdkFailNull(){
        Assertions.assertFalse(bar.addDrink(null,drink));
    }

    @Test
    void testAddDrinkFailNull(){
        Assertions.assertFalse(bar.addDrink("1",null));
    }

    @Test
    void testGetDrinkSuccess() {
       Assertions.assertTrue(bar.addDrink("1",drink));
       Assertions.assertNotNull(bar.getDrink("1"));
       Assertions.assertEquals(drink,bar.getDrink("1"));
    }
    @Test
    void testGetDrinkFail(){
        Assertions.assertNull(bar.getDrink("3"));
    }
    @Test
    void testGetCollection(){
        Assertions.assertNotNull(bar.getDrinkCollection());
    }
}