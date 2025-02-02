package com.xworkz.travelapp.entity;

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

@Table(name = "travel_booking")
@NamedQuery(name = "deleteById", query = "DELETE FROM TravelingBookingEntity r WHERE r.id = :id")
public class TravelingBookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;;
    private String firstName;
    private Long phoneNumber;
    private String start;
    private String traveling;
    private String vehicle;
}
