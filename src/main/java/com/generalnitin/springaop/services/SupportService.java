package com.generalnitin.springaop.services;

import com.generalnitin.springaop.models.Home;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SupportService {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional(propagation = Propagation.MANDATORY)
    public void testSupportTransaction() {
        Home home = new Home();
        home.setName("Test Data");
        entityManager.persist(home); // it fails here why??
        entityManager.flush();
        entityManager.refresh(home);
    }
}
