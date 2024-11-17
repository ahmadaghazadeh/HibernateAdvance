package com.sevensky.hibernate_advance.domain.listeners;

import com.sevensky.hibernate_advance.domain.services.EncryptionService;
import org.hibernate.event.spi.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;
@Component
public class PreInsertListener extends AbstractEncryptionListener implements PreInsertEventListener {
    protected PreInsertListener(EncryptionService encryptionService) {
        super(encryptionService);
    }

    @Override
    public boolean onPreInsert(PreInsertEvent event) {
        this.encrypt(event.getState(),event.getPersister().getPropertyNames(), event.getEntity());
        return false;
    }
}

