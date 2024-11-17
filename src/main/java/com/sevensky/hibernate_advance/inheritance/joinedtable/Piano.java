package com.sevensky.hibernate_advance.inheritance.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
public class Piano extends Instrument{
    private Integer numberKey;

    public Integer getNumberKey() {
        return numberKey;
    }

    public void setNumberKey(Integer numberKey) {
        this.numberKey = numberKey;
    }
}
