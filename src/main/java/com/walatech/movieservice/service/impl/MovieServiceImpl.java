package com.walatech.movieservice.service.impl;

import com.walatech.movieservice.entity.Movie;
import com.walatech.movieservice.repository.MovieRepository;
import com.walatech.movieservice.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    @Override
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }
}
