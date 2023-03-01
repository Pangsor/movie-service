package com.walatech.movieservice.service;

import com.walatech.movieservice.dto.MovieDto;
import com.walatech.movieservice.entity.Movie;

import java.util.List;

public interface MovieService {
    MovieDto createMovie(MovieDto movie);
    MovieDto getMovieById(int movieId);
    List<MovieDto> getAllMovies();
    MovieDto updateMovie(MovieDto movie);
    void deleteMovie(int movieId);
}
