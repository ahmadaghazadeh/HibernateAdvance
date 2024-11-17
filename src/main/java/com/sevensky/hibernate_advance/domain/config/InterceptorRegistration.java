package com.sevensky.hibernate_advance.domain.config;

import com.sevensky.hibernate_advance.domain.interceptors.EncryptionInterceptor;
import com.sevensky.hibernate_advance.domain.services.EncryptionService;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class InterceptorRegistration implements HibernatePropertiesCustomizer {

    private final EncryptionInterceptor encryptionInterceptor;

    public InterceptorRegistration(EncryptionInterceptor encryptionInterceptor) {
        this.encryptionInterceptor = encryptionInterceptor;
    }


    @Override
    public void customize(Map<String, Object> hibernateProperties) {
        hibernateProperties.put("hibernate.session_factory.interceptor",encryptionInterceptor);

    }
}
