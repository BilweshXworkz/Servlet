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
        em.getTransaction().begin();
        em.createNamedQuery("deleteById").setParameter("id",id).executeUpdate();
        em.getTransaction().commit();
    }
}
