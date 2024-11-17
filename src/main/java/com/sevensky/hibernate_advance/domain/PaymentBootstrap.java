package com.sevensky.hibernate_advance.domain;

import com.sevensky.hibernate_advance.domain.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PaymentBootstrap implements CommandLineRunner {
    final String CREDIT_CARD="12345600000";

    private final CreditCardRepository creditCardRepository;

    public PaymentBootstrap(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        CreditCard creditCard=new CreditCard();

        creditCard.setCreditCardNumber(CREDIT_CARD);
        creditCard.setCvv("123");
        creditCard.setExpirationDate("12/2028");

        CreditCard savedCreditCard=creditCardRepository.saveAndFlush(creditCard);

        CreditCard fetchCreditCard=creditCardRepository.findById(savedCreditCard.getId()).get();


    }
}
