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

    @Override
    public TravelingBookingEntity getBookingById(int id) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            return (TravelingBookingEntity) entityManager.createNamedQuery("getBookingById").setParameter("id", id).getSingleResult();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public void updateBooking(TravelingBookingEntity entity) {
        EntityManager entityManager = emf.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
        }
        catch (Exception e){
            entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
        }
        finally {
            entityManager.close();
        }
    }
}
