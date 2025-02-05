package com.xworkz.vehicleregistration.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "vehicle")
@NamedQuery(name = "deleteById", query = "DELETE FROM RegistrationEntity r WHERE r.id = :id")
@NamedQuery(name = "getRegisterById", query = "SELECT register FROM RegistrationEntity register WHERE register.id = :id")
public class RegistrationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private Long phoneNumber;
    private String emailId;
    private String  vehicleName;
    private String vehicleType;
    private Integer code;
}
