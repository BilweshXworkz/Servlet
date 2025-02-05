package com.xworkz.passport.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.naming.Name;
import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "register")
@NamedQuery(name = "deleteById", query = "DELETE FROM RegisterEntity r WHERE r.id = :id")
@NamedQuery(name = "updateById", query = "SELECT register FROM RegisterEntity register WHERE register.id = :id ")
public class RegisterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fName;
    private String lName;
    private String dob;
    private String email;
    private String address;
}
