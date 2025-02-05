package com.xworkz.collegapp.entity;

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

@Table(name = "college_table")
@NamedQuery(name = "deleteById", query = "DELETE FROM CollegeApplicationEntity r WHERE r.id = :id")
@NamedQuery(name ="updateProfile", query = "SELECT college FROM CollegeApplicationEntity college WHERE college.id=:id")
public class CollegeApplicationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String  lastName;
    private Long phoneNumber;
    private String emailId;
    private String education;
}
