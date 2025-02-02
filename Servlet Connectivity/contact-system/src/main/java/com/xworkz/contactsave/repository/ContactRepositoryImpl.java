package com.xworkz.contactsave.repository;

import com.xworkz.contactsave.entity.ContactEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

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
        }
    }
    @Override
    public List<ContactEntity> getContactDetails() {
        EntityManager entityManager = emf.createEntityManager();
        List<ContactEntity> contactEntities = null;
        try {
            contactEntities = entityManager.createQuery("SELECT a FROM ContactEntity a", ContactEntity.class)
                    .getResultList();
        } catch (Exception e) {
            System.out.println("Error fetching appointments: " + e.getMessage());
        } finally {
            entityManager.close();
        }
        return contactEntities;
    }

    public void deleteById(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createNamedQuery("deleteById").setParameter("id",id).executeUpdate();
        em.getTransaction().commit();
    }
}
