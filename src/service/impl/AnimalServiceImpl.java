package service.impl;

import dao.Database;
import gender.Gender;
import model.Animal;
import model.User;
import service.GenericService;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnimalServiceImpl implements GenericService<Animal> {
    private Database database = new Database();

    @Override
    public String add(List<Animal> t) {
        database.getAnimals().addAll(t);
        return "Animals successfully added!";
    }

    @Override
    public Animal getById(Long id) {

        return database.getAnimals().stream().filter(x-> x.getId().equals(id)).findAny().get();
    }

    @Override
    public String removeByName(String name) {
        Animal animal = database.getAnimals().stream().filter(x -> x.getName().equalsIgnoreCase(name)).findAny().get();
        database.getAnimals().remove(animal);
        return "Animal successfully removed!";
    }

    @Override
    public List<Animal> getAll() {
        return database.getAnimals();
    }

    @Override
    public List<Animal> sortByName() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 1){
            return database.getAnimals().stream().sorted(Comparator.comparing(Animal::getName)).toList();
        }else {
            return database.getAnimals().stream().sorted(Comparator.comparing(Animal::getName).reversed()).toList();
        }
    }

    @Override
    public List<Animal> filterByGender() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 2) {
            return database.getAnimals().stream().filter(x -> x.getGender().equals(Gender.M)).toList();
        } else {
            return database.getAnimals().stream().filter(x -> x.getGender().equals(Gender.F)).toList();
        }
    }

    @Override
    public List<Animal> clear() {
        database.getAnimals().clear();
        return database.getAnimals();
    }
}
