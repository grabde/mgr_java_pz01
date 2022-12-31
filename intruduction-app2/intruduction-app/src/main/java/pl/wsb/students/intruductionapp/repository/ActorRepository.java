package pl.wsb.students.intruductionapp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.wsb.students.intruductionapp.model.Actor;

import java.util.Collection;
import java.util.List;

public interface ActorRepository extends CrudRepository<Actor, Integer> {
    @Query("select a from Actor a where a.termin like concat(?1, '%') and a.termin like concat('%', ?2)")
    List<Actor> findAfter(String termin, String termin1);
    @Query("select a from Actor a where a.termin like ?1")
    Iterable<Actor> find_today(String termin);
}
