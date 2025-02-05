package com.xworkz.movies.services;

import com.xworkz.movies.dto.MoviesDto;

import java.util.List;

public interface MoviesServices {
    Boolean validAndSave(MoviesDto dto);
    List<MoviesDto> getMovies();
    public void deleteById(int id);
    MoviesDto getProfileById(int id);
    void updateProfile(MoviesDto dto);
}
