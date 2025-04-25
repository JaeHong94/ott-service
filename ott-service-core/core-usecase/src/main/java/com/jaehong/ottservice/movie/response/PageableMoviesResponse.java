package com.jaehong.ottservice.movie.response;

import lombok.Getter;

import java.util.List;

@Getter
public class PageableMoviesResponse {
    private final List<MovieResponse> movieResponses;
    private final int page;
    private final boolean hasNext; // 다음 페이지 존재여부

    public PageableMoviesResponse(List<MovieResponse> movieResponses, int page, boolean hasNext) {
        this.movieResponses = movieResponses;
        this.page = page;
        this.hasNext = hasNext;
    }
}
