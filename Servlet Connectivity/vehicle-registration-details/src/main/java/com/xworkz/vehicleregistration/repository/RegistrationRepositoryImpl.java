package com.xworkz.vehicleregistration.repository;

import com.xworkz.vehicleregistration.dto.RegistrationDto;
import com.xworkz.vehicleregistration.entity.RegistrationEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class RegistrationRepositoryImpl implements RegistrationRepository{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("vehicle");

    @Override
    public Boolean save(RegistrationEntity registrationEntity) {
        EntityManager entityManager = emf.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(registrationEntity);
            entityManager.getTransaction().commit();
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        finally {
            entityManager.close();
        }
    }
    @Override
    public List<RegistrationEntity> getRegistrationDetails() {
        EntityManager entityManager = emf.createEntityManager();
        List<RegistrationEntity> registrationEntities = null;
        try {
            registrationEntities = entityManager.createQuery("SELECT a FROM RegistrationEntity a", RegistrationEntity.class)
                    .getResultList();
        } catch (Exception e) {
            System.out.println("Error fetching appointments: " + e.getMessage());
        } finally {
            entityManager.close();
        }
        return registrationEntities;
    }

    @Override
    public void deleteById(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createNamedQuery("deleteById").setParameter("id",id).executeUpdate();
        em.getTransaction().commit();
    }
}
