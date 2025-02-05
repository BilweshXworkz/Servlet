package com.xworkz.feedbackapp.repository;


import com.xworkz.feedbackapp.entity.FeedbackEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collections;
import java.util.List;

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
        }
    }

    @Override
    public List<FeedbackEntity> getFeedbackDetails() {
        EntityManager entityManager = emf.createEntityManager();
        List<FeedbackEntity> feedbackEntities = null;
        try {
            feedbackEntities = entityManager.createQuery("SELECT a FROM FeedbackEntity a", FeedbackEntity.class)
                    .getResultList();
        } catch (Exception e) {
            System.out.println("Error fetching appointments: " + e.getMessage());
        } finally {
            entityManager .close();
        }
        return feedbackEntities;
    }

    public void deleteById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("deleteById").setParameter("id", id).executeUpdate();
            em.getTransaction().commit();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            em.close();
        }
    }

    @Override
    public FeedbackEntity getProfileById(Integer id) {
        EntityManager entity = emf.createEntityManager();
        try{
            return (FeedbackEntity) entity.createNamedQuery("getProfileById").setParameter("id",id).getSingleResult();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            entity.close();
        }
        return null;
    }

    @Override
    public void updateProfile(FeedbackEntity entity) {
        EntityManager entityManager = emf.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            entityManager.close();
        }
    }
}
