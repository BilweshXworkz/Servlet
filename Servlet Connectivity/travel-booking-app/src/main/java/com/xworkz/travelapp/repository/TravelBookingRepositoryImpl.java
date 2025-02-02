package com.xworkz.travelapp.repository;

import com.xworkz.travelapp.entity.TravelingBookingEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TravelBookingRepositoryImpl implements TravelBookingRepository{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("travel");
    @Override
    public Boolean save(TravelingBookingEntity travelingBookingEntity) {
        EntityManager entityManager = emf.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(travelingBookingEntity);
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
    public List<TravelingBookingEntity> getBookingDetails() {
        EntityManager entityManager = emf.createEntityManager();
        List<TravelingBookingEntity> travelingBookingEntities = null;
        try {
            travelingBookingEntities = entityManager.createQuery("SELECT a FROM TravelingBookingEntity a", TravelingBookingEntity.class)
                    .getResultList();
        } catch (Exception e) {
            System.out.println("Error fetching appointments: " + e.getMessage());
        } finally {
            entityManager.close();
        }
        return travelingBookingEntities;
    }

    public void deleteById(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createNamedQuery("deleteById").setParameter("id",id).executeUpdate();
        em.getTransaction().commit();
    }
}
