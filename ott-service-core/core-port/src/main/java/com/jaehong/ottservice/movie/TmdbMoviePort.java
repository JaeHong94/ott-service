package com.jaehong.ottservice.movie;

public interface TmdbMoviePort {
    TmdbPageableMovies fetchPageable(int page);
}
