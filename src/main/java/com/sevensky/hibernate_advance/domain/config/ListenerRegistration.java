package com.sevensky.hibernate_advance.domain.config;


import com.sevensky.hibernate_advance.domain.listeners.PostLoadListener;
import com.sevensky.hibernate_advance.domain.listeners.PreInsertListener;
import com.sevensky.hibernate_advance.domain.listeners.PreUpdateListener;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Component;

//@Component
public class ListenerRegistration implements BeanPostProcessor {


    private final PostLoadListener postLoadListener;
    private final PreInsertListener preInsertListener;
    private final PreUpdateListener preUpdateListener;

    public ListenerRegistration(PostLoadListener postLoadListener, PreInsertListener preInsertListener, PreUpdateListener preUpdateListener) {
        this.postLoadListener = postLoadListener;
        this.preInsertListener = preInsertListener;
        this.preUpdateListener = preUpdateListener;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof LocalContainerEntityManagerFactoryBean) {
            LocalContainerEntityManagerFactoryBean factoryBean = (LocalContainerEntityManagerFactoryBean) bean;
            SessionFactoryImpl sessionFactory = (SessionFactoryImpl) factoryBean.getNativeEntityManagerFactory();
            EventListenerRegistry registry = sessionFactory.getServiceRegistry().getService(EventListenerRegistry.class);

            registry.appendListeners(EventType.POST_LOAD,postLoadListener);
            registry.appendListeners(EventType.PRE_INSERT,preInsertListener);
            registry.appendListeners(EventType.PRE_UPDATE,preUpdateListener);
        }

        return bean;
    }


}
