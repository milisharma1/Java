package com.example.springboot.service;

import com.example.springboot.entity.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    Movie addMovie(Movie movie);
    List<Movie> getAllMovies();

    Optional<Movie> getMovieByTitle(String title);

    Optional<Movie> getMovieById(Long Id);

    void deleteMovie(Long Id);

    Movie updateMovie(Long Id, Movie updateMovie);
}
