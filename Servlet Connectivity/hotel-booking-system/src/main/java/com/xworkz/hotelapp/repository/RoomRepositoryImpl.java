package com.xworkz.hotelapp.repository;

import com.xworkz.hotelapp.entity.RoomOrderEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RoomRepositoryImpl implements RoomOrderRepository {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("order");
    @Override
    public Boolean save(RoomOrderEntity roomOrderEntity) {
        EntityManager entityManager = emf.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(roomOrderEntity);
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
