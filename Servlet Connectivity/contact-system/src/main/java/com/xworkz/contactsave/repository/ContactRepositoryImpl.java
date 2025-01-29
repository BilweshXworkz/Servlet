package com.xworkz.contactsave.repository;

import com.xworkz.contactsave.entity.ContactEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ContactRepositoryImpl implements ContactRepository{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("contactus");
    @Override
    public Boolean save(ContactEntity contactEntity) {
        EntityManager entityManager = emf.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(contactEntity);
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
