package movie;

public interface TmdbMoviePort {
    TmdbPageableMovies fetchPageable(int page);
}
