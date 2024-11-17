package com.sevensky.hibernate_advance.inheritance.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
public class ElectricGuitar extends Guitar {
    private Integer numberOfPickups;

    public Integer getNumberOfPickups() {
        return numberOfPickups;
    }

    public void setNumberOfPickups(Integer numberOfPickups) {
        this.numberOfPickups = numberOfPickups;
    }
}
