package de.ait.homeworks36;

import java.util.ArrayList;
import java.util.List;

public class SuperheroManager {
    private List<Superhero> superheroes = new ArrayList<>();

    //void addSuperhero(Superhero superhero): метод для добавления супергероя в коллекцию.
    public boolean addSuperhero(Superhero superhero) {
        if (!superheroes.contains(superhero)) {
            superheroes.add(superhero);
            return true; // Возвращаем true, если супергерой был успешно добавлен
        } else {
            System.out.println("Супергерой с именем " + superhero.getName() + " уже существует и не может быть добавлен.");
            return false; // Возвращаем false, если супергерой не был добавлен
        }
    }

    //void removeSuperhero(String name): метод для удаления супергероя по имени.
    public Superhero removeSuperhero(String name) {
        //проверяем на пустой список
        Superhero removedSuperhero = null;
        //идем по поиску
        for (Superhero superhero : superheroes) {
            if (superhero.getName().equals(name)) {
                removedSuperhero = superhero;
                superheroes.remove(superhero);
                break;
            }
        }
        return removedSuperhero;
    }

    //Superhero getSuperhero(String name): метод, который возвращает супергероя по имени.
    public Superhero getSuperhero(String name) {
        for (Superhero superhero : superheroes) {
            if (superhero.getName().equals(name)) {
                return superhero;
            }
        }
        return null;
    }

    //List<Superhero> getAllSuperheroes(): метод, который возвращает список всех супергероев.
    public List<Superhero> getAllSuperheroes() {
        if (!superheroes.isEmpty()) {
            return new ArrayList<>(superheroes);
        }
        return null;
    }

    @Override
    public String toString() {
        return superheroes.toString();
    }

    //Реализуйте дополнительный метод void updateSuperhero(String name,
    // Superhero newSuperhero) в классе SuperheroManager,
    // который позволяет обновить информацию о супергерое по имени.
    public void updateSuperhero(String name, Superhero newSuperhero) {
        // Найдем супергероя по имени
        Superhero existingSuperhero = getSuperhero(name);

        if (existingSuperhero != null) {
            // Удаляем существующего супергероя
            superheroes.remove(existingSuperhero);
            // Добавляем нового супергероя
            superheroes.add(newSuperhero);
        }
    }

}
