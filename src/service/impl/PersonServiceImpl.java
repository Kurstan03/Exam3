package service.impl;

import dao.Database;
import gender.Gender;
import model.Person;
import model.User;
import service.GenericService;

import javax.security.sasl.SaslClient;
import java.util.*;

public class PersonServiceImpl implements GenericService<Person> {
    private Database database = new Database();
    @Override
    public String add(List<Person> t) {
        database.getPeople().addAll(t);
        return "Persons successfully added!";
    }

    @Override
    public Person getById(Long id) {
        Person person1 = null;
        for (Person person : database.getPeople()) {
            if (person.getId().equals(id)){
                person1 = person;
            }
        }
        return person1;
    }

    @Override
    public String removeByName(String name) {
        Person person = null;
        for (Person p : database.getPeople()) {
            if (p.getName().equalsIgnoreCase(name)) {
                person = p;
            }
        }
        database.getPeople().remove(person);
        return "Person successfully removed!";
    }

    @Override
    public List<Person> getAll() {
        return database.getPeople();
    }

    @Override
    public List<Person> sortByName() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();;
        if (n == 1){
            Collections.sort(database.getPeople(), PersonServiceImpl.as);
            return database.getPeople();
        } else if (n ==2){
            Collections.sort(database.getPeople(), PersonServiceImpl.des);
            return database.getPeople();
        }
        return null;
    }
    public static Comparator <Person> as = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };
    public static Comparator <Person> des = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o2.getName().compareTo(o1.getName());
        }
    };

    @Override
    public List<Person> filterByGender() {
        Scanner scanner = new Scanner(System.in);
        List<Person> sortPerson = new ArrayList<>();
        int n = scanner.nextInt();
        if (n == 1){
//            return database.getPeople().stream().filter(x-> x.getGender().equals(Gender.M)).toList();
            for (Person p : database.getPeople()) {
                if (p.getGender().equals(Gender.M)){
                    sortPerson.add(p);
                }
            }
            return sortPerson;
        } else {
//            return database.getPeople().stream().filter(x-> x.getGender().equals(Gender.F)).toList();
            for (Person person : database.getPeople()) {
                if (person.getGender().equals(Gender.F)) {
                    sortPerson.add(person);
                }
            }
            return sortPerson;
        }

    }

    @Override
    public List<Person> clear() {
        database.getPeople().clear();
        return database.getPeople();
    }
}
