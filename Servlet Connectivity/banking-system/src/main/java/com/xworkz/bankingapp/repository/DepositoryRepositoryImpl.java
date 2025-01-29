package com.xworkz.bankingapp.repository;

import com.xworkz.bankingapp.entity.DepositoryEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DepositoryRepositoryImpl implements DepositoryRepository{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("depository");
    @Override
    public Boolean save(DepositoryEntity depositoryEntity) {
        EntityManager entityManager = emf.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(depositoryEntity);
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
