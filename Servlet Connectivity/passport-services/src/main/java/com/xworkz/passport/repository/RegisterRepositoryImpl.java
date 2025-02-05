package com.xworkz.passport.repository;

import com.xworkz.passport.entity.RegisterEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class RegisterRepositoryImpl implements RegisterRepository{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("register");
    @Override
    public Boolean save(RegisterEntity registerEntity) {
        EntityManager entityManager = emf.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(registerEntity);
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
    public List<RegisterEntity> getRegisterDetails() {
        EntityManager entityManager = emf.createEntityManager();
        List<RegisterEntity> registerEntities = null;
        try {
            registerEntities = entityManager.createQuery("SELECT a FROM RegisterEntity a", RegisterEntity.class)
                    .getResultList();
        } catch (Exception e) {
            System.out.println("Error fetching appointments: " + e.getMessage());
        } finally {
            entityManager.close();
        }
        return registerEntities;
    }

    public void deleteById(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createNamedQuery("deleteById").setParameter("id",id).executeUpdate();
        em.getTransaction().commit();
    }

    @Override
    public RegisterEntity getProfileById(Integer id) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            return (RegisterEntity) entityManager.createNamedQuery("updateById").setParameter("id", id).getSingleResult();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public void updateProfile(RegisterEntity entity) {
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
