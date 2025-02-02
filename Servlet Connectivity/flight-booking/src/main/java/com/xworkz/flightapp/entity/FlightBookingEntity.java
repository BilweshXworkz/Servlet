package com.xworkz.flightapp.entity;

import lombok.*;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "flight_booking")
@NamedQuery(name = "deleteById", query = "DELETE FROM FlightBookingEntity r WHERE r.id = :id")
public class FlightBookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "from_where")
    private String from;

    @Column(name = "departure")
    private String departure;

    @Column(name = "returns")
    private String returns;

    @Column(name = "number")
    private Integer number;
}
