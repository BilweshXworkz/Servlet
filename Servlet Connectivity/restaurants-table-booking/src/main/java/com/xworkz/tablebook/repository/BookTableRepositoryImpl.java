package com.xworkz.tablebook.repository;

import com.xworkz.tablebook.entity.BookTableEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
            emf.close();
        }
    }
}
