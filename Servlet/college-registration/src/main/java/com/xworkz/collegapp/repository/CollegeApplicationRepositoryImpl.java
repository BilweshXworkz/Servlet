package com.xworkz.collegapp.repository;



import com.xworkz.collegapp.entity.CollegeApplicationEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collections;
import java.util.List;

public class CollegeApplicationRepositoryImpl implements CollegeApplicationRepository {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("college-app");

    @Override
    public Boolean save(CollegeApplicationEntity collegeApplicationEntity) {
        EntityManager entityManager = emf.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(collegeApplicationEntity);
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
    public List<CollegeApplicationEntity> getCollegeApplicationDetails() {
        EntityManager entityManager = emf.createEntityManager();
        List <CollegeApplicationEntity>  collegeApplicationEntities = null;
        try{
            collegeApplicationEntities = entityManager.createQuery("SELECT a FROM CollegeApplicationEntity a", CollegeApplicationEntity.class)
                    .getResultList();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            entityManager.close();
        }
        return collegeApplicationEntities;

    }

    public void deleteById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("deleteById").setParameter("id", id).executeUpdate();
            em.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            em.close();
        }
    }

    @Override
    public CollegeApplicationEntity getById(Integer id) {
        EntityManager entityManager = emf.createEntityManager();
        try{
            return(CollegeApplicationEntity)entityManager.createNamedQuery("updateProfile").setParameter("id",id).getSingleResult();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public void updateProfile(CollegeApplicationEntity entity) {
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
