package com.xworkz.bankingapp.repository;

import com.xworkz.bankingapp.entity.DepositoryEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collections;
import java.util.List;

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

    @Override
    public List<DepositoryEntity> getDepositoryDetails() {
        EntityManager entityManager = emf.createEntityManager();
        List<DepositoryEntity> depositoryEntities = null;
        try{
            depositoryEntities = entityManager.createQuery("SELECT a From DepositoryEntity a", DepositoryEntity.class)
                    .getResultList();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            entityManager.close();
        }
        return  depositoryEntities;
    }

    public void deleteById(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createNamedQuery("deleteById").setParameter("id",id).executeUpdate();
        em.getTransaction().commit();
    }

    @Override
    public DepositoryEntity getDepositoryById(int id) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            return (DepositoryEntity) entityManager.createNamedQuery("getDepositoryById").setParameter("id", id).getSingleResult();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public void updateDepository(DepositoryEntity entity) {
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
