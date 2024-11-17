package com.sevensky.hibernate_advance.domain.interceptors;

public class ObjectEncrypt {
    private Object[] objects;

    private boolean isEncrypted;

    public ObjectEncrypt(Object[] objects, boolean isEncrypted) {
        this.objects = objects;
        this.isEncrypted = isEncrypted;
    }

    public Object[] getObjects() {
        return objects;
    }

    public void setObjects(Object[] objects) {
        this.objects = objects;
    }

    public boolean isEncrypted() {
        return isEncrypted;
    }

    public void setEncrypted(boolean encrypted) {
        isEncrypted = encrypted;
    }
}
