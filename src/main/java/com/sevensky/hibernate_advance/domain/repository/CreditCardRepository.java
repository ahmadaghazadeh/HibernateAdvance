package com.sevensky.hibernate_advance.domain.repository;

import com.sevensky.hibernate_advance.domain.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
}
