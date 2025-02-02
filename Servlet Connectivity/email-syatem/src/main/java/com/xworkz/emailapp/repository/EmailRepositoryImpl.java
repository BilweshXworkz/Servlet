package com.xworkz.emailapp.repository;

import com.xworkz.emailapp.entity.EmailEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

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
        }
    }
    @Override
    public List<EmailEntity> getEmailDetails() {
        EntityManager entityManager = emf.createEntityManager();
        List<EmailEntity> emailEntities = null;
        try {
            emailEntities = entityManager.createQuery("SELECT e FROM EmailEntity e", EmailEntity.class)
                    .getResultList();
        } catch (Exception e) {
            System.out.println("Error fetching emails: " + e.getMessage());
        } finally {
            entityManager.close();
        }
        return emailEntities;
    }

    @Override
    public void deleteByToEmail(String toEmail) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.createQuery("DELETE FROM EmailEntity e WHERE e.toMail = :toEmail")
                    .setParameter("toEmail", toEmail)
                    .executeUpdate();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error deleting email: " + e.getMessage());
        } finally {
            entityManager.close();
        }
    }

}
