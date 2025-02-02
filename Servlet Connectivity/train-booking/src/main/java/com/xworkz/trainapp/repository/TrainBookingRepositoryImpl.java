package com.xworkz.trainapp.repository;

import com.xworkz.trainapp.entity.TrainBookingEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

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

    @Override
    public List<TrainBookingEntity> getTrainDetails() {
        EntityManager entityManager = emf.createEntityManager();
        List<TrainBookingEntity> trainBookingEntities = null;
        try {
            trainBookingEntities = entityManager.createQuery("SELECT a FROM TrainBookingEntity a", TrainBookingEntity.class)
                    .getResultList();
        } catch (Exception e) {
            System.out.println("Error fetching appointments: " + e.getMessage());
        } finally {
            entityManager .close();
        }
        return trainBookingEntities;
    }

    public void deleteById(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createNamedQuery("deleteById").setParameter("id",id).executeUpdate();
        em.getTransaction().commit();
    }
}
