package de.ait.homeworks38;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class UniqueNamesApp {
    public static void main(String[] args) {
        Set<String> nameList = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имена (или введите 'стоп' для завершения):");
        while (true) {
            String input = scanner.nextLine().trim();
            // equalsIgnoreCase изменяем для ввода не учитывать регистр (Стоп, СТОП, СтоП и тд)
            if (input.equalsIgnoreCase("стоп")) {
                break;
            }
            // Проверка на отсутствие цифр в имени
            if (!containsDigits(input)) {
                if (nameList.add(input)) {
                    System.out.println("Имя '" + input + "' добавлено.");
                } else {
                    System.out.println("Имя '" + input + "' не было добавлено, так как оно уже существует.");
                }
            } else {
                System.out.println("Имя не должно содержать цифры. Попробуйте снова.");
            }
        }
        scanner.close();

        System.out.println("---------");
        System.out.println("Уникальные имена:");

        if (nameList.isEmpty()) {
            System.out.println("Список имен пуст.");
        } else {
            Iterator<String> iterator = nameList.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }
    }

    // Метод для проверки наличия цифр в строке
    private static boolean containsDigits(String s) {
        return Pattern.compile("[0-9]").matcher(s).find();
    }
}
