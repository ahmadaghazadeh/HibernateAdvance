package com.sevensky.hibernate_advance.inheritance.repository;

import com.sevensky.hibernate_advance.inheritance.joinedtable.ElectricGuitar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectricGuitarRepository extends JpaRepository<ElectricGuitar,Long> {
}
