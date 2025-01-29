package com.xworkz.collegapp.repository;



import com.xworkz.collegapp.entity.CollegeApplicationEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
            emf.close();
        }
    }
}
