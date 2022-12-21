package model;

import gender.Gender;

public class Person extends User{

    public Person(Long id, String name, int age, Gender gender) {
        super(id, name, age, gender);
    }
}
