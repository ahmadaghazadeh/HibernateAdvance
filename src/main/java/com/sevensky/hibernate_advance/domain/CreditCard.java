package com.sevensky.hibernate_advance.domain;

import com.sevensky.hibernate_advance.domain.interceptors.EncryptedString;
import jakarta.persistence.*;

@Entity
//@EntityListeners(CreditCardJpaCallback.class)
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    //@EncryptedString
    @Convert(converter = CreditCardConverter.class)
    private String creditCardNumber;
    @Convert(converter = CreditCardConverter.class)
    private String cvv;

    private String expirationDate;

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
