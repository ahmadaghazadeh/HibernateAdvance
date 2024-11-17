package com.sevensky.hibernate_advance.domain.interceptors;

import com.sevensky.hibernate_advance.domain.services.EncryptionService;
import org.hibernate.CallbackException;
import org.hibernate.Interceptor;
import org.hibernate.type.Type;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//@Component
public class EncryptionInterceptor implements Interceptor {

    private final EncryptionService encryptionService;

    public EncryptionInterceptor(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }

    @Override
    public boolean onLoad(Object entity, Object id, Object[] state, String[] propertyNames, Type[] types)
            throws CallbackException {
        System.out.println("onLoad");
        ObjectEncrypt objectEncrypt=processFields(entity,state,propertyNames,"onLoad");
        Interceptor.super.onLoad(entity, id, objectEncrypt.getObjects(), propertyNames, types);
        return false;
    }

    @Override
    public boolean onSave(Object entity, Object id, Object[] state, String[] propertyNames, Type[] types)
            throws CallbackException {
        System.out.println("onSave");
        ObjectEncrypt objectEncrypt=processFields(entity,state,propertyNames,"onSave");
        Interceptor.super.onSave(entity, id, objectEncrypt.getObjects(), propertyNames, types);
        return objectEncrypt.isEncrypted();
    }

    @Override
    public boolean onFlushDirty(Object entity, Object id, Object[] currentState, Object[] previousState,
                                String[] propertyNames, Type[] types) throws CallbackException {
        System.out.println("onFlushDirty");
        ObjectEncrypt objectEncrypt=processFields(entity,currentState,propertyNames,"onFlushDirty");
        Interceptor.super.onFlushDirty(entity, id, objectEncrypt.getObjects(), previousState, propertyNames, types);
        return objectEncrypt.isEncrypted();
    }

    private ObjectEncrypt processFields(Object entity, Object[] currentState, String[] propertyNames,
                                        String type) {
        List<String> annotationFields = getAnnotationFields(entity);

        for (String annotationField : annotationFields) {
            for (int i = 0; i < propertyNames.length; i++) {
                if (propertyNames[i].equals(annotationField)) {
                    if(StringUtils.hasText(currentState[i].toString())) {
                        if("onSave".equals(type) || "OnFlushDirty".equals(type)) {
                            currentState[i] = encryptionService.encrypt(currentState[i].toString());
                            System.out.println("Type " +type + " "
                                    +encryptionService.encrypt(currentState[i].toString()));
                        }
                        else if("onLoad".equals(type)) {
                            currentState[i] = encryptionService.decrypt(currentState[i].toString());
                            System.out.println("Type " +type + " "
                                    +encryptionService.decrypt(currentState[i].toString()));
                        }
                    }
                }

            }
        }
        return new ObjectEncrypt(currentState, !annotationFields.isEmpty());
    }

    private List<String> getAnnotationFields(Object entity) {

        List<String> annotationFields = new ArrayList<>();

        for (Field field : entity.getClass().getDeclaredFields()) {
            if(!Objects.isNull(field.getAnnotation(EncryptedString.class))) {
                annotationFields.add(field.getName());
            }
        }

        return annotationFields;
    }
}
