package com.sevensky.hibernate_advance;

import com.sevensky.hibernate_advance.domain.CreditCard;
import com.sevensky.hibernate_advance.domain.repository.CreditCardRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


@SpringBootTest
@ActiveProfiles("local")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class HibernateAdvanceApplicationTests {

	final String CREDIT_CARD="12345600000";

	@Autowired
	CreditCardRepository creditCardRepository;

	@Test
	@Rollback(false)
	void contextLoads() {
		CreditCard creditCard=new CreditCard();

		creditCard.setCreditCardNumber(CREDIT_CARD);
		creditCard.setCvv("123");
		creditCard.setExpirationDate("12/2028");

		CreditCard savedCreditCard=creditCardRepository.saveAndFlush(creditCard);

		CreditCard fetchCreditCard=creditCardRepository.findById(savedCreditCard.getId()).get();

		assertThat(savedCreditCard.getCreditCardNumber()).isEqualTo(fetchCreditCard.getCreditCardNumber());
	}

}
