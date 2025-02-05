package com.xworkz.shoppingapp.repository;

import com.xworkz.shoppingapp.dto.ShoppingDto;
import com.xworkz.shoppingapp.entity.ShoppingEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ShoppingRepositoryImpl implements ShoppingRepository {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("shop");

    @Override
    public Boolean save(ShoppingEntity shoppingEntity) {
        EntityManager entityManager = emf.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(shoppingEntity);
            entityManager.getTransaction().commit();
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        finally {
            entityManager.close();
        }
    }

    @Override
    public List<ShoppingEntity> getShoppingDetails() {
        EntityManager entityManager = emf.createEntityManager();
        List<ShoppingEntity> shoppingEntities = null;
        try {
            shoppingEntities = entityManager.createQuery("SELECT a FROM ShoppingEntity a", ShoppingEntity.class)
                    .getResultList();
        } catch (Exception e) {
            System.out.println("Error fetching appointments: " + e.getMessage());
        } finally {
            entityManager.close();
        }
        return shoppingEntities;
    }

    public void deleteById(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createNamedQuery("deleteById").setParameter("id",id).executeUpdate();
        em.getTransaction().commit();
    }

    @Override
    public ShoppingEntity getShoppingById(int id) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            return (ShoppingEntity) entityManager.createNamedQuery("getShoppingById").setParameter("id", id).getSingleResult();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public void updateShopping(ShoppingEntity entity) {
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
