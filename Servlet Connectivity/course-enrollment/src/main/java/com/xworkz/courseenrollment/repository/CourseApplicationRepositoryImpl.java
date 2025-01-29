package com.xworkz.courseenrollment.repository;


import com.xworkz.courseenrollment.entity.CourseApplicationEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
}
