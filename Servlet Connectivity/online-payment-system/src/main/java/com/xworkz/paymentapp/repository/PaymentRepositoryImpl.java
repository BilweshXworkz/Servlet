package com.xworkz.paymentapp.repository;

import com.xworkz.paymentapp.dto.PaymentDto;
import com.xworkz.paymentapp.entity.PaymetEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class PaymentRepositoryImpl implements PaymentRepository{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("onpay");
    @Override
    public Boolean save(PaymetEntity paymetEntity) {
        EntityManager entityManager = emf.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(paymetEntity);
            entityManager.getTransaction().commit();
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        finally {
            entityManager.close();
            emf.close();
        }
    }
    @Override
    public List<PaymetEntity> getPaymentDetails() {
        EntityManager entityManager = emf.createEntityManager();
        List<PaymetEntity> paymetEntities = null;
        try {
            paymetEntities = entityManager.createQuery("SELECT a FROM PaymetEntity a", PaymetEntity.class)
                    .getResultList();
        } catch (Exception e) {
            System.out.println("Error fetching appointments: " + e.getMessage());
        } finally {
            entityManager.close();
        }
        return paymetEntities;
    }

    public void deleteById(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createNamedQuery("deleteById").setParameter("id",id).executeUpdate();
        em.getTransaction().commit();
    }
}
