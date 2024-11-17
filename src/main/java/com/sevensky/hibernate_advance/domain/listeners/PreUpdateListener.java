package com.sevensky.hibernate_advance.domain.listeners;

import com.sevensky.hibernate_advance.domain.services.EncryptionService;
import org.hibernate.event.spi.PreUpdateEvent;
import org.hibernate.event.spi.PreUpdateEventListener;
import org.springframework.stereotype.Component;

@Component
public class PreUpdateListener extends AbstractEncryptionListener implements PreUpdateEventListener {

    protected PreUpdateListener(EncryptionService encryptionService) {
        super(encryptionService);
    }

    @Override
    public boolean onPreUpdate(PreUpdateEvent event) {
        this.encrypt(event.getState(),event.getPersister().getPropertyNames(), event.getEntity());
        return false;
    }
}
