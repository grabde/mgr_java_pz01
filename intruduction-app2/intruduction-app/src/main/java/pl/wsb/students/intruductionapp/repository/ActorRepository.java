package pl.wsb.students.intruductionapp.repository;

import org.springframework.data.repository.CrudRepository;
import pl.wsb.students.intruductionapp.model.Actor;

public interface ActorRepository extends CrudRepository<Actor, Integer> {
}
