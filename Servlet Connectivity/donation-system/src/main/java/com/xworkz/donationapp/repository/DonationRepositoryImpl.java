package com.xworkz.donationapp.repository;


import com.xworkz.donationapp.entity.DonationEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

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
        }
    }

    @Override
    public List<DonationEntity> getDonationDetails() {
        EntityManager entityManager = emf.createEntityManager();
        List<DonationEntity> donationEntities = null;
        try {
            donationEntities = entityManager.createQuery("SELECT a FROM DonationEntity a", DonationEntity.class)
                    .getResultList();
        } catch (Exception e) {
            System.out.println("Error fetching appointments: " + e.getMessage());
        } finally {
            entityManager.close();
        }
        return donationEntities;
    }

    public void deleteById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("deleteById").setParameter("id", id).executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            em.close();
        }
    }

    @Override
    public DonationEntity getDonationById(int id) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            return (DonationEntity) entityManager.createNamedQuery("getProfileById").setParameter("id", id).getSingleResult();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public void updateDonation(DonationEntity entity) {
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
