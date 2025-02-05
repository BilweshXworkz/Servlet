package com.xworkz.flightapp.repository;

import com.xworkz.flightapp.entity.FlightBookingEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class FlightBookingRepositoryImpl implements  FlightBookingRepository{
     EntityManagerFactory emf = Persistence.createEntityManagerFactory("flightbooking");
    @Override
    public Boolean save(FlightBookingEntity flightBookingEntity) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(flightBookingEntity);
            entityManager.getTransaction().commit();
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }finally {
            entityManager.close();
        }
    }

    @Override
    public List<FlightBookingEntity> getFlightDetails() {
        EntityManager entityManager = emf.createEntityManager();
        List<FlightBookingEntity> flightBookingEntities = null;
        try{
            flightBookingEntities = entityManager.createQuery("SELECT a FROM FlightBookingEntity a", FlightBookingEntity.class)
                    .getResultList();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            entityManager.close();
        }
        return flightBookingEntities;
    }

    public void deleteById(int id) {
        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.createNamedQuery("deleteById").setParameter("id", id).executeUpdate();
            em.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            emf.close();
        }
    }

    @Override
    public FlightBookingEntity getFlightById(int id) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            return (FlightBookingEntity) entityManager.createNamedQuery("getById").setParameter("id", id).getSingleResult();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public void updateFlight(FlightBookingEntity entity) {
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
