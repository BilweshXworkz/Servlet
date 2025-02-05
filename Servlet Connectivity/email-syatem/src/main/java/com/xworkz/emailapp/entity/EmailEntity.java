package com.xworkz.emailapp.entity;

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
@NamedQuery(name="getEmailById", query="SELECT email FROM EmailEntity email WHERE email.id=:id")
@Table(name = "mail")
public class EmailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String toMail;
    private String subject;
    private String content;
}
