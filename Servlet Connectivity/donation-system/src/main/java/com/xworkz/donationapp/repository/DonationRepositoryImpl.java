package com.xworkz.donationapp.repository;


import com.xworkz.donationapp.entity.DonationEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DonationRepositoryImpl implements DonationRepository {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("donation-app");

    @Override
    public Boolean save(DonationEntity donationEntity) {
        EntityManager entityManager = emf.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(donationEntity);
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
