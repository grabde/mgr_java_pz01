package pl.wsb.students.intruductionapp.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import pl.wsb.students.intruductionapp.model.Movie;
import pl.wsb.students.intruductionapp.repository.MovieRepository;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class MovieServiceTest {
    @Autowired
    private MovieService movieService;
    @MockBean
    private MovieRepository repository;
    @Test
    void listAll_whenFound_thenReturnResult() {
// Setup our mock repository
        Movie movie = new Movie(1,
                new Date(),
                new Date(),
                "Tytuł filmu",
                "2020",
                null
        );
        Movie movie2 = new Movie(
                2,
                new Date(),
                new Date(),
                "Tytuł drugiego filmu",
                "2020",
                null
        );
        doReturn(Arrays.asList(movie, movie2)).when(repository).findAll();
        Iterable<Movie> movies = movieService.listAll();
        Assertions.assertEquals(2, StreamSupport.stream(movies.spliterator(), false).count());
    }
    @Test
    void find_whenFound_thenReturnResult() {
// Setup our mock repository
        Movie movie = new Movie(
                1,
                new Date(),
                new Date(),
                "Tytuł filmu",
                "2020",
                null
        );
        doReturn(Optional.of(movie)).when(repository).findById(1);
// Execute the service call
        Movie result = movieService.find(1);
// Assert the response
        Assertions.assertTrue((result != null) );
        Assertions.assertSame(result, movie);
    }
    @Test
    void find_whenNotFound_thenReturnNull() {
// Setup our mock repository
        doReturn(Optional.empty()).when(repository).findById(1);
// Execute the service call
        Movie result = movieService.find(1);
// Assert the response
        Assertions.assertTrue((result == null) );
    }
}

