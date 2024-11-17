package com.sevensky.hibernate_advance.inheritance.tableperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity(name = "Dog")
public class Dog extends Mammal{
    private String breed;

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
