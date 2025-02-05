package com.xworkz.jobapp.entity;

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

@Table(name = "jobapply")
@NamedQuery(name = "deleteById", query = "DELETE FROM JobApplyEntity r WHERE r.id = :id")
@NamedQuery(name = "getApplyById", query = "SELECT apply FROM JobApplyEntity apply WHERE apply.id = :id")
public class JobApplyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String  firstName;
    private String  lastName;
    private Long phoneNumber;
    private String  emailId;
    private String  jobApplying;
}
