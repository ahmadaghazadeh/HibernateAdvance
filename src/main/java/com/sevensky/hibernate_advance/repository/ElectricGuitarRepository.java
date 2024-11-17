package com.sevensky.hibernate_advance.repository;

import com.sevensky.hibernate_advance.joinedtable.ElectricGuitar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectricGuitarRepository extends JpaRepository<ElectricGuitar,Long> {
}
