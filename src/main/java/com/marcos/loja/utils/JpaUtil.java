package com.marcos.loja.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("jpa");

    public EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }

}
