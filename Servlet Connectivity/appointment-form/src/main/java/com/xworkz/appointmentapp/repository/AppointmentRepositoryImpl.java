package com.xworkz.appointmentapp.repository;

import com.xworkz.appointmentapp.entity.AppointmentEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppointmentRepositoryImpl implements AppointmentRepository {
     EntityManagerFactory emf = Persistence.createEntityManagerFactory("appointment_app");
    @Override
    public Boolean save(AppointmentEntity appointmentEntity) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(appointmentEntity);
            entityManager.getTransaction().commit();
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }finally {
            entityManager.close();
            emf.close();
        }
    }
}
