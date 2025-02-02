package com.xworkz.appointmentapp.repository;

import com.xworkz.appointmentapp.entity.AppointmentEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collections;
import java.util.List;

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
        }
    }

    @Override
    public List<AppointmentEntity> getAppointmentDetails() {
        EntityManager entityManager = emf.createEntityManager();
        List<AppointmentEntity> appointmentEntities = null;
        try {
            appointmentEntities = entityManager.createQuery("SELECT a FROM AppointmentEntity a", AppointmentEntity.class)
                    .getResultList();
        } catch (Exception e) {
            System.out.println("Error fetching appointments: " + e.getMessage());
        } finally {
            entityManager.close();
        }
        return appointmentEntities;
    }

    public void deleteById(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createNamedQuery("deleteById").setParameter("id",id).executeUpdate();
        em.getTransaction().commit();
    }
}
