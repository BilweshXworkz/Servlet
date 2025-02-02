package com.xworkz.eventapp.repository;

import com.xworkz.eventapp.dto.EventDto;
import com.xworkz.eventapp.entity.EventEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collections;
import java.util.List;

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
        }
    }

    @Override
    public List<EventEntity> getEventDetails() {
        EntityManager entityManager = emf.createEntityManager();
        List<EventEntity> eventEntities = null;
        try {
            eventEntities = entityManager.createQuery("SELECT a FROM EventEntity a", EventEntity.class)
                    .getResultList();
        } catch (Exception e) {
            System.out.println("Error fetching appointments: " + e.getMessage());
        } finally {
            entityManager.close();
        }
        return eventEntities;
    }

    public void deleteById(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createNamedQuery("deleteById").setParameter("id",id).executeUpdate();
        em.getTransaction().commit();
    }
}
