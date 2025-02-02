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
            emf.close();
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
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createNamedQuery("deleteById").setParameter("id",id).executeUpdate();
        em.getTransaction().commit();
    }
}
