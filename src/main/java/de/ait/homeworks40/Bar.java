package de.ait.homeworks40;

import java.util.HashMap;
import java.util.Map;

public class Bar {
    //Внутри этого класса создайте HashMap,
    //где ключом будет являться String (ID напитка), а значением — объект класса Drink.
    private Map<String, Drink> drinkCollection = new HashMap<>();
    //addDrink(String id, Drink drink): добавляет напиток в коллекцию.
    public boolean addDrink(String id, Drink drink){
        if (id == null || drink == null){
            System.err.println("Некорректные данные!");
        return false;
        }
        else if (!drinkCollection.containsKey(id)){
            System.out.println("Добавлен напиток с ID " + id + " Название " + drink.getName());
        drinkCollection.put(id,drink);
        return true;
        }
        else {
            System.err.println("Данный напиток уже с списке:\n" + drinkCollection.get(id));
        return false;
        }
    }
    //getDrink(String id): возвращает напиток по ID.
    public Drink getDrink(String id){
        if(drinkCollection.containsKey(id)) {
            return drinkCollection.get(id);
        }
        else {
            System.out.println("Данного напитка нет в базе с ID: " + id);
            return null;
        }
    }
    public Map<String, Drink> getDrinkCollection() {
        Map<String, Drink> drinkCollectionToReturn = new HashMap<>(drinkCollection);
        return drinkCollectionToReturn;
    }
}