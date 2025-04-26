package com.jaehong.ottservice.movie;

import lombok.Getter;

import java.util.List;

@Getter
public class TmdbMovie {
    private final String movieName;
    private final Boolean isAdult; // 성인영화 여부
    private final List<String> genre; // 장르
    private final String overview; // 설명
    private final String releaseAt; // 개봉 일자

    public TmdbMovie(String movieName, Boolean isAdult, List<String> genre, String overview, String releaseAt) {
        this.movieName = movieName;
        this.isAdult = isAdult;
        this.genre = genre;
        this.overview = overview;
        this.releaseAt = releaseAt;
    }
}
