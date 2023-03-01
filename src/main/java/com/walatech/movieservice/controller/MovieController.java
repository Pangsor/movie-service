package com.walatech.movieservice.controller;

import com.walatech.movieservice.dto.MovieDto;
import com.walatech.movieservice.entity.Movie;
import com.walatech.movieservice.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/movies")
public class MovieController {

    private MovieService movieService;

    @PostMapping
    public ResponseEntity<MovieDto> createMovie(@RequestBody MovieDto movie){
        MovieDto savedMovie = movieService.createMovie(movie);
        return new ResponseEntity<>(savedMovie, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<MovieDto> getMovieById(@PathVariable("id") int movieId){
        MovieDto movie = movieService.getMovieById(movieId);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<MovieDto>> getAllMovies(){
        List<MovieDto> movieList = movieService.getAllMovies();
        return new ResponseEntity<>(movieList, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<MovieDto> updateMovie(@PathVariable("id") int movieId,
                                             @RequestBody MovieDto movie){
        movie.setId(movieId);
        MovieDto updatedMovie = movieService.updateMovie(movie);
        return new ResponseEntity<>(updatedMovie, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable("id") int movieId){
        movieService.deleteMovie(movieId);
        return new ResponseEntity<>("Movie successfully deleted",HttpStatus.OK);
    }
}
