package com.sevensky.hibernate_advance.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class Truck extends Vehicle {

    public Integer getPayload() {
        return payload;
    }

    public void setPayload(Integer payload) {
        this.payload = payload;
    }

    private Integer payload;

}
