package com.xworkz.movies.repository;

import com.xworkz.movies.entity.MoviesEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MoviesRepositoryImpl implements MoviesRepository{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("movie");

    @Override
    public Boolean save(MoviesEntity moviesEntity) {
        EntityManager entityManager = emf.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(moviesEntity);
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
