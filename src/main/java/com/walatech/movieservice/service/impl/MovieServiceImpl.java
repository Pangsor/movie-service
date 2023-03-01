package com.walatech.movieservice.service.impl;

import com.walatech.movieservice.dto.MovieDto;
import com.walatech.movieservice.entity.Movie;
import com.walatech.movieservice.exception.ResourceNotFoundException;
import com.walatech.movieservice.exception.TitleAlreadyExistsException;
import com.walatech.movieservice.repository.MovieRepository;
import com.walatech.movieservice.service.MovieService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;
    private ModelMapper modelMapper;

    @Override
    public MovieDto createMovie(MovieDto movieDto) {

        Optional<Movie> optionalMovie = movieRepository.findByTitle(movieDto.getTitle());

        if(optionalMovie.isPresent()){
            throw new TitleAlreadyExistsException("Title Already Exists for Movie");
        }
        Movie movie = modelMapper.map(movieDto,Movie.class);
        Movie savedMovie = movieRepository.save(movie);

        MovieDto savedMovieDto = modelMapper.map(savedMovie,MovieDto.class);
        return savedMovieDto;
    }

    @Override
    public MovieDto getMovieById(int movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(
                () -> new ResourceNotFoundException("Movie","id",movieId)
        );
        return modelMapper.map(movie,MovieDto.class);
    }

    @Override
    public List<MovieDto> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        return movies.stream().map((movie) -> modelMapper.map(movie,MovieDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public MovieDto updateMovie(MovieDto movie) {
        Movie existingMovie = movieRepository.findById(movie.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Movie","id",movie.getId())
        );
        existingMovie.setTitle(movie.getTitle());
        existingMovie.setDescription(movie.getDescription());
        existingMovie.setRating(movie.getRating());
        existingMovie.setImage(movie.getImage());
        Movie updatedMovie = movieRepository.save(existingMovie);
        return modelMapper.map(updatedMovie,MovieDto.class);
    }

    @Override
    public void deleteMovie(int movieId) {
        Movie existingMovie = movieRepository.findById(movieId).orElseThrow(
                () -> new ResourceNotFoundException("Movie","id",movieId)
        );
        movieRepository.deleteById(movieId);
    }
}
