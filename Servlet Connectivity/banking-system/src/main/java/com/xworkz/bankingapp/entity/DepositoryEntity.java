package com.xworkz.bankingapp.entity;

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

@Table(name = "depository")
@NamedQuery(name = "deleteById", query = "DELETE FROM DepositoryEntity r WHERE r.id = :id")
public class DepositoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Integer id;
    @Column (name = "full_name")
    private String fullName;
    @Column (name = "dob")
    private String dob;
    @Column (name = "email_id")
    private String emailId;
    @Column (name = "ac_number")
    private Long acNumber;
    @Column (name = "depository")
    private Integer depository;
}
