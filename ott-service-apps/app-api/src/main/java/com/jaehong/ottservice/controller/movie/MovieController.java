package com.jaehong.ottservice.controller.movie;

import com.jaehong.ottservice.movie.FetchMovieUseCase;
import com.jaehong.ottservice.movie.response.PageableMoviesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MovieController {
    private final FetchMovieUseCase fetchMovieUseCase;

    @GetMapping("/api/v1/movie/client/{page}")
    public String fetchMoviePageables(@PathVariable int page) {
        PageableMoviesResponse pageableMoviesResponse = fetchMovieUseCase.fetchFromClient(page);
        return "";
    }
}
