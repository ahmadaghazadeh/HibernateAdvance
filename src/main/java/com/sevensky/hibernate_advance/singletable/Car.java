package com.sevensky.hibernate_advance.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class Car extends Vehicle {

    public String getTrimLevel() {
        return trimLevel;
    }

    public void setTrimLevel(String trimLevel) {
        this.trimLevel = trimLevel;
    }

    private String trimLevel;
}
