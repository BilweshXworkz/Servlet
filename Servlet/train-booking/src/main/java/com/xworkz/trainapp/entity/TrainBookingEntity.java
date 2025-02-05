package com.xworkz.trainapp.entity;

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

@Table(name = "train_booking")
@NamedQuery(name = "deleteById", query = "DELETE FROM TrainBookingEntity r WHERE r.id = :id")
@NamedQuery(name = "getProfileById", query = "SELECT train From TrainBookingEntity train WHERE train.id = :id")
public class TrainBookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fName;
    private String lName;
    private String dob;
    private String email;
    private Integer num;
}
