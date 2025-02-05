package com.xworkz.donationapp.entity;

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

@Table(name = "donation_table")
@NamedQuery(name = "deleteById", query = "DELETE FROM DonationEntity r WHERE r.id = :id")
@NamedQuery(name="getProfileById", query = "SELECT r FROM DonationEntity r WHERE r.id = :id")
public class DonationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String  name;
    private Long phoneNumber;
    private Integer dAmount;
    private Integer payment;
}
