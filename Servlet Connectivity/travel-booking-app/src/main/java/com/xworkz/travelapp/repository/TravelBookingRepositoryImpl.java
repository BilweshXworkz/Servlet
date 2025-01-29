package com.xworkz.travelapp.repository;

import com.xworkz.travelapp.entity.TravelingBookingEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
            emf.close();
        }
    }
}
