package com.xworkz.movies.entity;


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
@NamedQuery(name = "deleteById", query = "DELETE FROM MoviesEntity r WHERE r.id = :id")
@NamedQuery(name = "getProfileById", query = "SELECT movie From MoviesEntity movie WHERE movie.id = :id")
@Table(name = "movie")
public class MoviesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String mName;
    private String hero;
    private String heroin;
}
