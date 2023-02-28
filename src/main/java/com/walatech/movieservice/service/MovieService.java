package com.walatech.movieservice.service;

import com.walatech.movieservice.entity.Movie;

import java.util.List;

public interface MovieService {
    Movie createMovie(Movie movie);
    Movie getMovieById(int movieId);
    List<Movie> getAllMovies();
    Movie updateMovie(Movie movie);
}
