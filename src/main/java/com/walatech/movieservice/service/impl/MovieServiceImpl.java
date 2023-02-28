package com.walatech.movieservice.service.impl;

import com.walatech.movieservice.dto.MovieDto;
import com.walatech.movieservice.entity.Movie;
import com.walatech.movieservice.repository.MovieRepository;
import com.walatech.movieservice.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    @Override
    public MovieDto createMovie(MovieDto movieDto) {
        Movie movie = new Movie(
                movieDto.getId(),
                movieDto.getTitle(),
                movieDto.getDescription(),
                movieDto.getRating(),
                movieDto.getImage(),
                movieDto.getCreatedAt(),
                movieDto.getUpdatedAt()
        );
        Movie savedMovie = movieRepository.save(movie);

        MovieDto savedMovieDto = new MovieDto(
                savedMovie.getId(),
                savedMovie.getTitle(),
                savedMovie.getDescription(),
                savedMovie.getRating(),
                savedMovie.getImage(),
                savedMovie.getCreatedAt(),
                savedMovie.getUpdatedAt()
        );
        return savedMovieDto;
    }

    @Override
    public Movie getMovieById(int movieId) {
        Optional<Movie> optionalMovie = movieRepository.findById(movieId);
        return optionalMovie.get();
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie updateMovie(Movie movie) {
        Movie existingMovie = movieRepository.findById(movie.getId()).get();
        existingMovie.setTitle(movie.getTitle());
        existingMovie.setDescription(movie.getDescription());
        existingMovie.setRating(movie.getRating());
        existingMovie.setImage(movie.getImage());
        Movie updatedMovie = movieRepository.save(existingMovie);
        return updatedMovie;
    }

    @Override
    public void deleteMovie(int movieId) {
        movieRepository.deleteById(movieId);
    }
}
