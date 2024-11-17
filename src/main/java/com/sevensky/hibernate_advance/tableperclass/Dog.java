package com.sevensky.hibernate_advance.tableperclass;

import jakarta.persistence.Entity;

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
