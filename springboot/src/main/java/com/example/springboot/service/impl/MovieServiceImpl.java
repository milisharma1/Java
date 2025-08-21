package com.example.springboot.service.impl;

import com.example.springboot.entity.Movie;
import com.example.springboot.repository.MovieRepository;
import com.example.springboot.service.MovieService;

import java.util.List;
import java.util.Optional;

public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie addMovie(Movie movie){
        return movieRepository.save(movie);
    }

    @Override
    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> getMovieByTitle(String title){
        return movieRepository.findByTitle(title);
    }

    @Override
    public Optional<Movie> getMovieById(Long Id) {
        return movieRepository.findById(Id);
    }

    @Override
    public void deleteMovie(Long Id){
        if(movieRepository.existsById(Id)){
            movieRepository.deleteById(Id);
        }
        else {
            System.out.println("Movie with Id " + Id+ " does not exist");
        }
    }

    @Override
    public Movie updateMovie(Long Id, Movie updateMovie){
        return movieRepository.findById(Id).map(existingMovie -> {
            existingMovie.setTitle(updateMovie.getTitle());
            existingMovie.setDirector(updateMovie.getDirector());
            existingMovie.setGenre(updateMovie.getGenre());
            existingMovie.setReleaseYear(updateMovie.getReleaseYear());
            return movieRepository.save(existingMovie);
        })
                .orElseThrow(() -> new RuntimeException("Movie not found with Id "+ Id));
    }
}
