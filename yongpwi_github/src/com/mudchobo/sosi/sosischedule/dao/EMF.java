package com.mudchobo.sosi.sosischedule.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

@Component
public final class EMF {
     private static final EntityManagerFactory emfInstance =
        Persistence.createEntityManagerFactory("transactions-optional");

    private EMF() {}

    public EntityManager get() {
        return emfInstance.createEntityManager();
    }
}