package com.luanrocha.testeWithJava.services;

import com.luanrocha.testeWithJava.domain.Movie;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    public Movie findMoviesByCode(Long cod) {
        if (cod > 100) {
            return null;
        }

        return new Movie(
                cod,
                "A volta dos que não foram",
                "é um otimo filme",
                "comedia");
    }
}
