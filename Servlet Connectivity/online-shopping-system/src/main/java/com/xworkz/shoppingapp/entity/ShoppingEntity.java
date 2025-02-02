package com.xworkz.shoppingapp.entity;

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
@NamedQuery(name = "deleteById", query = "DELETE FROM ShoppingEntity r WHERE r.id = :id")
@Table(name = "shop_table")

public class ShoppingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private Long phoneNumber;
    private String pName;
    private String quantity;
    private String address;
}
