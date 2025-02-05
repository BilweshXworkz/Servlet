package com.xworkz.tablebook.entity;

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

@Table(name = "table_book")
@NamedQuery(name = "deleteById", query = "DELETE FROM BookTableEntity r WHERE r.id = :id")
@NamedQuery(name = "getTableById", query = "SELECT book FROM BookTableEntity book WHERE book.id = :id")
public class BookTableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private Long phoneNumber;
    private String person;
    private String time;
}
