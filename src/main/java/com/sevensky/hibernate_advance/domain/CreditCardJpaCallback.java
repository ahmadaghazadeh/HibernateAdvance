package com.sevensky.hibernate_advance.domain;

import com.sevensky.hibernate_advance.domain.services.EncryptionService;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.*;

public class CreditCardJpaCallback {

    @PrePersist
    @PreUpdate
    public void beforeInsertOrUpdate(CreditCard creditCard) {
        System.out.println("beforeInsertOrUpdate");
        creditCard.setCreditCardNumber(getEncryptionService().encrypt(creditCard.getCreditCardNumber()));
    }

    @PostLoad
    @PostUpdate
    @PostPersist
    public void postLoad(CreditCard creditCard) {
        System.out.println("postLoad");
        creditCard.setCreditCardNumber(getEncryptionService().decrypt(creditCard.getCreditCardNumber()));
    }

    private EncryptionService getEncryptionService() {
        return SpringContextHelper.getApplicationContext().getBean(EncryptionService.class);
    }
}
