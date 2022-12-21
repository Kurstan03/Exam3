package model;

import gender.Gender;

public class Animal extends User{

    public Animal(Long id, String name, int age, Gender gender) {
        super(id, name, age, gender);
    }
}
