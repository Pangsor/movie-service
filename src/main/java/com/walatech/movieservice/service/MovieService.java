package com.walatech.movieservice.service;

import com.walatech.movieservice.dto.MovieDto;
import com.walatech.movieservice.entity.Movie;

import java.util.List;

public interface MovieService {
    MovieDto createMovie(MovieDto movie);
    Movie getMovieById(int movieId);
    List<Movie> getAllMovies();
    Movie updateMovie(Movie movie);
    void deleteMovie(int movieId);
}
