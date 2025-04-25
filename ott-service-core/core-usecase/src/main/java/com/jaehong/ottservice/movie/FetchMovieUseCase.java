package com.jaehong.ottservice.movie;

import com.jaehong.ottservice.movie.response.PageableMoviesResponse;

public interface FetchMovieUseCase {
    PageableMoviesResponse fetchFromClient(int page);
}
