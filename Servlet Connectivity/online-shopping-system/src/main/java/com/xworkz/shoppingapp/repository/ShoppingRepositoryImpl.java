package com.xworkz.shoppingapp.repository;

import com.xworkz.shoppingapp.dto.ShoppingDto;
import com.xworkz.shoppingapp.entity.ShoppingEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
            emf.close();
        }
    }
}
