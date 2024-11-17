package com.sevensky.hibernate_advance.matersuper;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
