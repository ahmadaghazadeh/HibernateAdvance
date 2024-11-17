package com.sevensky.hibernate_advance.inheritance.matersuper;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
public class OrderHeader extends BaseEntity{

    private String customerName;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
