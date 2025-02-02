package com.xworkz.hotelapp.repository;

import com.xworkz.hotelapp.entity.RoomOrderEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

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
        }
    }
    @Override
    public List<RoomOrderEntity> getOrderDetails() {
        EntityManager entityManager = emf.createEntityManager();
        List<RoomOrderEntity> roomOrderEntities = null;
        try {
            roomOrderEntities = entityManager.createQuery("SELECT a FROM RoomOrderEntity a", RoomOrderEntity.class)
                    .getResultList();
        } catch (Exception e) {
            System.out.println("Error fetching appointments: " + e.getMessage());
        } finally {
            entityManager.close();
        }
        return roomOrderEntities;
    }

    public void deleteById(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createNamedQuery("deleteById").setParameter("id",id).executeUpdate();
        em.getTransaction().commit();
    }
}
