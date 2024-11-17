package com.sevensky.hibernate_advance.inheritance.tableperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity(name = "Dolphin")
public class Dolphin extends Mammal {

    private Boolean hasSpots;

    public Boolean getHasSpots() {
        return hasSpots;
    }

    public void setHasSpots(Boolean hasSpots) {
        this.hasSpots = hasSpots;
    }
}
