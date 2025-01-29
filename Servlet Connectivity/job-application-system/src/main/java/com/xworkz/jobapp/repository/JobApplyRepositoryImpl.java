package com.xworkz.jobapp.repository;

import com.xworkz.jobapp.dto.JobApplydto;
import com.xworkz.jobapp.entity.JobApplyEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JobApplyRepositoryImpl implements JobApplyRepository{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("job-app");

    @Override
    public Boolean save(JobApplyEntity jobApplyEntity) {
        EntityManager entityManager = emf.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(jobApplyEntity);
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
