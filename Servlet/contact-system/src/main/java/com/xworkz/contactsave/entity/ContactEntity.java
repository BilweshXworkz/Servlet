package com.xworkz.contactsave.entity;

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

@Table(name = "contact_table")
@NamedQuery(name = "deleteById", query = "DELETE FROM ContactEntity r WHERE r.id = :id")
@NamedQuery(name = "getContactById", query = "SELECT contact FROM ContactEntity contact WHERE contact.id = :id")
public class ContactEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private Long phoneNumber;
    private String emailId;
    private String description;
}
