package com.example.springboot.controller;

import com.example.springboot.entity.Movie;
import com.example.springboot.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    //Create Movie
    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.addMovie(movie));
    }
    //Get All Movies
    @GetMapping
    public ResponseEntity <List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    //Get Movie By ID
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long Id) {
        return movieService.getMovieById(Id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //Update Movie
    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long Id, @RequestBody Movie updatedMovie) {
        return ResponseEntity.ok(movieService.updateMovie(Id, updatedMovie));
    }

    //Delete Movie
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long Id) {
       movieService.deleteMovie(Id);
       return ResponseEntity.noContent().build();
    }
}
