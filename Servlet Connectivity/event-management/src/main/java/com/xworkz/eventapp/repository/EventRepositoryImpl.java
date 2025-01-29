package com.xworkz.eventapp.repository;

import com.xworkz.eventapp.entity.EventEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EventRepositoryImpl implements EventRepository{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("event");
    @Override
    public Boolean save(EventEntity eventEntity) {
        EntityManager entityManager = emf.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(eventEntity);
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
