package com.xworkz.courseenrollment.repository;


import com.xworkz.courseenrollment.entity.CourseApplicationEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CourseApplicationRepositoryImpl implements CourseApplicationRepository {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("course-app");

    @Override
    public Boolean save(CourseApplicationEntity courseApplicationEntity) {
        EntityManager entityManager = emf.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(courseApplicationEntity);
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

    @Override
    public List<CourseApplicationEntity> getApplicationDetails() {
        EntityManager entityManager = emf.createEntityManager();
        List<CourseApplicationEntity> courseApplicationEntities = null;
        try {
            courseApplicationEntities = entityManager.createQuery("SELECT a FROM CourseApplicationEntity a", CourseApplicationEntity.class)
                    .getResultList();
        } catch (Exception e) {
            System.out.println("Error fetching appointments: " + e.getMessage());
        } finally {
            entityManager .close();
        }
        return courseApplicationEntities;
    }

    public void deleteById(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createNamedQuery("deleteById").setParameter("id",id).executeUpdate();
        em.getTransaction().commit();
    }

    @Override
    public CourseApplicationEntity getCourseById(int id) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            return (CourseApplicationEntity) entityManager.createNamedQuery("getCourseById").setParameter("id", id).getSingleResult();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public void updateCourse(CourseApplicationEntity entity) {
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
