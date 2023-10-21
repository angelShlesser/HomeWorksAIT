package de.ait.homeworks38;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class UniqueNamesApp {
    public static void main(String[] args) {
        Set<String> nameList = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имена (или введите 'стоп' для завершения):");
        while (true){
            String input = scanner.nextLine().trim();
            if (input.equals("стоп")){
                break;
            }
            nameList.add(input);
        }
        scanner.close();

        System.out.println("---------");
        System.out.println("Уникальные имена:");
        Iterator<String> iterator = nameList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
