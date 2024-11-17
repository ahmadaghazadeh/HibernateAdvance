package com.sevensky.hibernate_advance.domain.listeners;

import com.sevensky.hibernate_advance.domain.services.EncryptionService;
import org.hibernate.event.spi.PostLoadEvent;
import org.hibernate.event.spi.PostLoadEventListener;
import org.springframework.stereotype.Component;

@Component
public class PostLoadListener extends AbstractEncryptionListener  implements PostLoadEventListener {


    protected PostLoadListener(EncryptionService encryptionService) {
        super(encryptionService);
    }

    @Override
    public void onPostLoad(PostLoadEvent postLoadEvent) {
        this.decrypt(postLoadEvent.getEntity());
    }
}
