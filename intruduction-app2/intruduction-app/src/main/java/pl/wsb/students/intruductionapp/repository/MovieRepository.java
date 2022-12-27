package pl.wsb.students.intruductionapp.repository;

import org.springframework.data.repository.CrudRepository;
import pl.wsb.students.intruductionapp.model.Movie;

public interface MovieRepository extends CrudRepository<Movie, Integer> {
}
