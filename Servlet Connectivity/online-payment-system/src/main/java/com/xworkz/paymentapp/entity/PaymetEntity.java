package com.xworkz.paymentapp.entity;

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

@Table(name = "payment")
@NamedQuery(name = "deleteById", query = "DELETE FROM PaymetEntity r WHERE r.id = :id")
@NamedQuery(name = "getPaymentById", query = "SELECT payment FROM PaymetEntity payment WHERE payment.id = :id")
public class PaymetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private Long phoneNumber;
    private String ifsCode;
    private Long account;
    private Integer amount;
}
