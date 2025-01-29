package com.xworkz.paymentapp.repository;

import com.xworkz.paymentapp.dto.PaymentDto;
import com.xworkz.paymentapp.entity.PaymetEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
}
