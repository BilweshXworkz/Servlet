package com.xworkz.emailapp.repository;

import com.xworkz.emailapp.entity.EmailEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmailRepositoryImpl implements EmailRepository{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("mail");
    @Override
    public Boolean save(EmailEntity emailEntity) {
        EntityManager entityManager = emf.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(emailEntity);
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
