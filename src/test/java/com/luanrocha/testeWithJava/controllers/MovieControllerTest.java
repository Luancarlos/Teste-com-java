package com.luanrocha.testeWithJava.controllers;

import com.luanrocha.testeWithJava.domain.Movie;
import com.luanrocha.testeWithJava.services.MovieService;
import io.restassured.http.ContentType;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.HttpStatus;

@WebMvcTest
public class MovieControllerTest {
    @Autowired
    private MovieController movieController;

    @MockBean
    private MovieService movieService;

    @BeforeEach
    public void setup() {
        // Só injeta o contexto que for utilizar
        standaloneSetup(this.movieController);
    }

    @Test
    public void whenSeekMovieShouldReturnSuccess() {
        Long code = 100L;
        when(this.movieService.findMoviesByCode(code))
                .thenReturn(new Movie(code, "A volta dos que nao foram", "descrição teste", "comedia"));

        given()
            .accept(ContentType.JSON)
        .when()
            .get("/api/movies/{code}", code)
        .then().statusCode(HttpStatus.OK.value());
    }

    @Test
    public void whenSeekMovieShouldReturnNotFound() {
        Long code = 100L;
        when(this.movieService.findMoviesByCode(code))
                .thenReturn(null);
        given()
            .accept(ContentType.JSON)
        .when()
        .   get("/api/movies/{code}", code)
        .then().statusCode(HttpStatus.NOT_FOUND.value());

    }

    @Test
    public void whenSeekMoviehouldReturnBadRequest() {
        given()
            .accept(ContentType.JSON)
        .when()
            .get("/api/movies/{code}", -1L)
        .then().statusCode(HttpStatus.BAD_REQUEST.value());

        // garantir que o service nao será chamado
        //verify(this.movieService, times(1)).findMoviesByCode(-1L);
        verify(this.movieService, never()).findMoviesByCode(-1L);
    }
}
