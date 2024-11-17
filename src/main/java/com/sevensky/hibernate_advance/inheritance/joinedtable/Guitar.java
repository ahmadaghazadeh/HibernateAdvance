package com.sevensky.hibernate_advance.inheritance.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
public class Guitar extends Instrument {

    private Integer numberOfStrings;

    public Integer getNumberOfStrings() {
        return numberOfStrings;
    }

    public void setNumberOfStrings(Integer numberOfStrings) {
        this.numberOfStrings = numberOfStrings;
    }
}
