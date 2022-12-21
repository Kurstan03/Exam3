import gender.Gender;
import model.Animal;
import model.Person;
import service.impl.AnimalServiceImpl;
import service.impl.PersonServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person(1L,"Kurstan", 19, Gender.M));
        people.add(new Person(2L,"Akylai", 13, Gender.F));
        people.add(new Person(3L,"Syimyk", 21, Gender.M));
        people.add(new Person(4L,"Baiysh", 22, Gender.M));
        people.add(new Person(5L,"Jarkynai", 20, Gender.F));

        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal(1L, "dog", 2, Gender.F));
        animals.add(new Animal(2L, "cat", 7, Gender.M));
        animals.add(new Animal(2L, "hourse", 5, Gender.M));
        animals.add(new Animal(3L, "cow", 1, Gender.F));


//        PersonServiceImpl personService = new PersonServiceImpl();
//        System.out.println(personService.add(people));
//        System.out.println(personService.getById(1L));
//        System.out.println(personService.removeByName("Kurstan"));
//        System.out.println(personService.getAll());
//        System.out.println(personService.sortByName());
//        System.out.println(personService.filterByGender());
//        System.out.println(personService.clear());


        AnimalServiceImpl animalService = new AnimalServiceImpl();
        System.out.println(animalService.add(animals));
        System.out.println(animalService.getById(1L));
        System.out.println(animalService.removeByName("dog"));
        System.out.println(animalService.getAll());
        System.out.println(animalService.sortByName());
        System.out.println(animalService.filterByGender());
        System.out.println(animalService.clear());
    }
}