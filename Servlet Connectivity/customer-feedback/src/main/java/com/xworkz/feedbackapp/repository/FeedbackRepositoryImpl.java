package com.xworkz.feedbackapp.repository;


import com.xworkz.feedbackapp.entity.FeedbackEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FeedbackRepositoryImpl implements FeedbackRepository {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("feedback-app");

    @Override
    public Boolean save(FeedbackEntity feedbackEntity) {
        EntityManager entityManager = emf.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(feedbackEntity);
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
