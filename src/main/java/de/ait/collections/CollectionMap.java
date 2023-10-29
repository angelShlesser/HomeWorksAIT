package de.ait.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CollectionMap {

    public static void main(String[] args) {
        Map<String, String> phones = new HashMap<>();

        phones.put("12", "Iphone 14 Max");
        phones.put("124", "Iphone 12");
        phones.put("125", "Samsung Galaxy S21");

        System.out.println(phones.get("123"));
        System.out.println(phones.get("124"));
        System.out.println(phones.get("125"));

        phones.put("126", "Samsung Galaxy S21");
        System.out.println(phones.get("126"));

        phones.put(null, "Samsung Galaxy S28");
        System.out.println(phones.get("126"));
        System.out.println(phones.get(null));


        phones.put("123", "Iphone 15 Max");
        System.out.println(phones.get("123"));

        System.out.println(phones.size());

        System.out.println("------");

        phones.remove("123");
        //phones.remove("123", "Iphone 15 Max");

        phones.remove(null);

        //System.out.println(phones);

        //Перебор коллекций варианты кода

        System.out.println("---Вариант 1---");
        for (Map.Entry<String, String> phoneMap : phones.entrySet()) {
            System.out.println(phoneMap.getKey() + " " + phoneMap.getValue());
        }

        System.out.println("---Вариант 2---");
        for (String phoneKey : phones.keySet()) {
            System.out.println(phones.get(phoneKey));
        }


        System.out.println("---Вариант 3---");
        Iterator<Map.Entry<String, String>> iteratorPhone = phones.entrySet().iterator();
        while (iteratorPhone.hasNext()) {
            System.out.println(iteratorPhone.next());
        }

        System.out.println("---Вариант 4---");
        phones.forEach((key, value) -> System.out.println(key + " " + value));


    }
}
