package de.ait.homeworks40;

import java.util.HashMap;
import java.util.Map;

public class Bar {
    //Внутри этого класса создайте HashMap,
    //где ключом будет являться String (ID напитка), а значением — объект класса Drink.
    private Map<String, Drink> drinkMap = new HashMap<>();
    //addDrink(String id, Drink drink): добавляет напиток в коллекцию.
    public void addDrink(String id, Drink drink){
        if (!drinkMap.containsKey(id)){
        drinkMap.put(id,drink);
        }
    }
    //getDrink(String id): возвращает напиток по ID.
    public Drink getDrink(String id){
        return drinkMap.get(id);
    }
}