package com.xworkz.appointmentapp.entity;

import lombok.*;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "appointment_app")
@NamedQuery(name = "deleteById", query = "DELETE FROM AppointmentEntity r WHERE r.id = :id")
@NamedQuery(name = "updateProfile", query ="SELECT appointment FROM AppointmentEntity appointment WHERE appointment.id =:id")
public class AppointmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Long phoneNumber;
    private String emailid;
    private String adate;
}
