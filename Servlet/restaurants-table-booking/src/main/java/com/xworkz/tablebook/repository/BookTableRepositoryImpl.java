package com.xworkz.tablebook.repository;

import com.xworkz.tablebook.entity.BookTableEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collections;
import java.util.List;

public class BookTableRepositoryImpl implements BookTableRepository{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("book");
    @Override
    public Boolean save(BookTableEntity bookTableEntity) {
        EntityManager entityManager = emf.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(bookTableEntity);
            entityManager.getTransaction().commit();
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        finally {
            entityManager.close();
//            emf.close();
        }
    }

    @Override
    public List<BookTableEntity> getBookDetails() {
        EntityManager entityManager = emf.createEntityManager();
        List<BookTableEntity> bookTableEntities = null;
        try {
            bookTableEntities = entityManager.createQuery("SELECT a FROM BookTableEntity a", BookTableEntity.class)
                    .getResultList();
        } catch (Exception e) {
            System.out.println("Error fetching appointments: " + e.getMessage());
        } finally {
            entityManager.close();
        }
        return bookTableEntities;
    }

    public void deleteById(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createNamedQuery("deleteById").setParameter("id",id).executeUpdate();
        em.getTransaction().commit();
    }

    @Override
    public BookTableEntity getTableById(int id) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            return (BookTableEntity) entityManager.createNamedQuery("getTableById").setParameter("id", id).getSingleResult();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public void updateTable(BookTableEntity entity) {
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
