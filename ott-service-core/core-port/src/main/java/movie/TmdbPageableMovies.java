package movie;

import lombok.Getter;

import java.util.List;

@Getter
public class TmdbPageableMovies {
    private final List<TmdbMovie> tmdbMovies;
    private final int page;
    private final boolean hasNext; // 다음 페이지 존재여부

    public TmdbPageableMovies(List<TmdbMovie> tmdbMovies, int page, boolean hasNext) {
        this.tmdbMovies = tmdbMovies;
        this.page = page;
        this.hasNext = hasNext;
    }
}
