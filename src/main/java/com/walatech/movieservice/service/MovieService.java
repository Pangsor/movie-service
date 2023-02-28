package com.walatech.movieservice.service;

import com.walatech.movieservice.entity.Movie;

public interface MovieService {
    Movie createMovie(Movie movie);
    Movie getMovieById(int movieId);
}
