package pl.wsb.students.intruductionapp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.wsb.students.intruductionapp.model.Movie;
import pl.wsb.students.intruductionapp.repository.MovieRepository;

import java.util.Date;

@Service
@Transactional
public class MovieService {
    private final MovieRepository movieRepository;
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    public Iterable<Movie> listAll() {
        return movieRepository.findAll();
    }
    public void save(Movie movie) {
        if (movie.getModified() == null) {
            movie.setModified(new Date());
        } //if
        movieRepository.save(movie);
    }
    public Movie find(Integer id) {
        return movieRepository.findById(id).orElse(null);
    }
    public void delete(Integer id) {
        movieRepository.deleteById(id);
    }
}