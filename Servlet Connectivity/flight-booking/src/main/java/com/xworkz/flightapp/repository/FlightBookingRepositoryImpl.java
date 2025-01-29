package com.xworkz.flightapp.repository;

import com.xworkz.flightapp.entity.FlightBookingEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
}
