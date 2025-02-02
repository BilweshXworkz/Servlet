package com.xworkz.feedbackapp.entity;

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

@Table(name = "feedback_table")
@NamedQuery(name = "deleteById", query = "DELETE FROM FeedbackEntity r WHERE r.id = :id")
public class FeedbackEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String  lastName;
    private Long phoneNumber;
    private String emailId;
    private String education;
}
