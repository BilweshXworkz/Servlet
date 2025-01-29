package com.xworkz.passport.repository;

import com.xworkz.passport.entity.RegisterEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RegisterRepositoryImpl implements RegisterRepository{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("register");
    @Override
    public Boolean save(RegisterEntity registerEntity) {
        EntityManager entityManager = emf.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(registerEntity);
            entityManager.getTransaction().commit();
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        finally {
            entityManager.close();
            emf.close();
        }
    }
}
