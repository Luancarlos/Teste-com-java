package com.luanrocha.testeWithJava.controllers;

import com.luanrocha.testeWithJava.domain.Movie;
import com.luanrocha.testeWithJava.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/movies/{code}")
    public ResponseEntity<Movie> getByCode(@PathVariable Long code) {
        if (code < 0) {
            return ResponseEntity.badRequest().build();
        }

        Movie movie = this.movieService.findMoviesByCode(code);

        if (movie == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(movie);
    }
}
