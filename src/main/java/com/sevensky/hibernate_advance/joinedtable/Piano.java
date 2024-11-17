package com.sevensky.hibernate_advance.joinedtable;

import jakarta.persistence.Entity;

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
