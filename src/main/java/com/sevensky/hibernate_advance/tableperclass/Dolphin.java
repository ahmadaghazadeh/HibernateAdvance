package com.sevensky.hibernate_advance.tableperclass;

import jakarta.persistence.Entity;

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
