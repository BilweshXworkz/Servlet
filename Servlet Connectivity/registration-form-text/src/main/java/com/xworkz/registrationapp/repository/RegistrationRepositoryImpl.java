package com.xworkz.registrationapp.repository;

import com.xworkz.registrationapp.entity.RegistrationEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RegistrationRepositoryImpl implements RegistrationRepository {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("registration");
    @Override
    public Boolean Save(RegistrationEntity registrationEntity) {
        EntityManager entityManager = emf.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(registrationEntity);
            entityManager.getTransaction().commit();
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
