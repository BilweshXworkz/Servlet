package com.xworkz.eventapp.entity;

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

@Table(name = "event")
@NamedQuery(name = "deleteById", query = "DELETE FROM EventEntity r WHERE r.id = :id")
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String uName;
    private String dob;
    private String email;
    private String address;
    private String eventType;
}
