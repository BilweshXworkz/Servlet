package com.xworkz.hotelapp.entity;

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

@Table(name = "order_room")
@NamedQuery(name = "deleteById", query = "DELETE FROM RoomOrderEntity r WHERE r.id = :id")
public class RoomOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private Long phoneNumber;
    private String hotel;
    private String stayTime;
    private String numberRoom;
}
