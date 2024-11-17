package com.sevensky.hibernate_advance.domain.listeners;

import com.sevensky.hibernate_advance.domain.interceptors.EncryptedString;
import com.sevensky.hibernate_advance.domain.services.EncryptionService;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class AbstractEncryptionListener {

    private final EncryptionService encryptionService;

    protected AbstractEncryptionListener(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }

    public void encrypt(Object[] state, String[] propertyNames, Object entity) {
        ReflectionUtils.doWithFields(entity.getClass(), field -> encryptField(field,state,propertyNames),this::isFieldEncrypted);
    }

    public void decrypt( Object entity) {
        ReflectionUtils.doWithFields(entity.getClass(), field -> decryptField(field,entity),this::isFieldEncrypted);
    }

    private void decryptField(Field field, Object entity) {
        field.setAccessible(true);
        Object value=ReflectionUtils.getField(field, entity);
        ReflectionUtils.setField(field,entity,encryptionService.decrypt(value.toString()));
    }


    private void encryptField(Field field, Object[] state, String[] propertyNames) {
        int idx=getPropertyIndex(field.getName(),propertyNames);
        Object value=state[idx];
        state[idx]=encryptionService.encrypt(value.toString());
    }


    private boolean isFieldEncrypted(Field field) {
        return AnnotationUtils.findAnnotation(field, EncryptedString.class)!=null;
    }


    private int getPropertyIndex(String name, String[] propertyNames) {
        for (int i = 0; i < propertyNames.length; i++) {
            if (name.equals(propertyNames[i])) {
                return i;
            }
        }
        throw new RuntimeException("No property named " + name + " found in class " + this.getClass().getName());
    }

}
