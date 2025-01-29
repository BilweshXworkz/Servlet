package com.xworkz.trainapp.repository;

import com.xworkz.trainapp.entity.TrainBookingEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TrainBookingRepositoryImpl implements TrainBookingRepository{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("train");
    @Override
    public Boolean save(TrainBookingEntity trainBookingEntity) {
        EntityManager entityManager = emf.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(trainBookingEntity);
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
