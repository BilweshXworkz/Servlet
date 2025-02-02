package com.xworkz.movies.repository;

import com.xworkz.movies.entity.MoviesEntity;

import java.util.List;

public interface MoviesRepository {
    Boolean save (MoviesEntity moviesEntity);
    List<MoviesEntity> getMoviesDetails();
    void deleteById(int id);
}
