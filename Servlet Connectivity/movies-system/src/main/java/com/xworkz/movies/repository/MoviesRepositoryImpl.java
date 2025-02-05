package com.xworkz.movies.repository;

import com.xworkz.movies.entity.MoviesEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

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
    @Override
    public List<MoviesEntity> getMoviesDetails() {
        EntityManager entityManager = emf.createEntityManager();
        List<MoviesEntity> moviesEntities = null;
        try {
            moviesEntities = entityManager.createQuery("SELECT a FROM MoviesEntity a", MoviesEntity.class)
                    .getResultList();
        } catch (Exception e) {
            System.out.println("Error fetching appointments: " + e.getMessage());
        } finally {
            entityManager.close();
        }
        return moviesEntities;
    }

    public void deleteById(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createNamedQuery("deleteById").setParameter("id",id).executeUpdate();
        em.getTransaction().commit();
    }

    @Override
    public MoviesEntity getProfileById(int id) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            return (MoviesEntity) entityManager.createNamedQuery("getProfileById").setParameter("id", id).getSingleResult();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public void updateDonation(MoviesEntity entity) {
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
