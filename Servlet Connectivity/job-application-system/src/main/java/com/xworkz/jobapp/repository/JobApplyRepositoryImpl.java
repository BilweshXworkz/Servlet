package com.xworkz.jobapp.repository;

import com.xworkz.jobapp.dto.JobApplydto;
import com.xworkz.jobapp.entity.JobApplyEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

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
        }
    }

    @Override
    public List<JobApplyEntity> getApplyDetails() {
        EntityManager entityManager = emf.createEntityManager();
        List<JobApplyEntity> jobApplyEntities = null;
        try {
            jobApplyEntities = entityManager.createQuery("SELECT a FROM JobApplyEntity a", JobApplyEntity.class)
                    .getResultList();
        } catch (Exception e) {
            System.out.println("Error fetching appointments: " + e.getMessage());
        } finally {
            entityManager.close();
        }
        return jobApplyEntities;
    }

    public void deleteById(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createNamedQuery("deleteById").setParameter("id",id).executeUpdate();
        em.getTransaction().commit();
    }

    @Override
    public JobApplyEntity getApplyById(int id) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            return (JobApplyEntity) entityManager.createNamedQuery("getApplyById").setParameter("id", id).getSingleResult();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public void updateApplication(JobApplyEntity entity) {
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
