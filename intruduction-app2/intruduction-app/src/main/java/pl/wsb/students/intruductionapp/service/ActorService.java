package pl.wsb.students.intruductionapp.service;

import org.springframework.stereotype.Service;
import pl.wsb.students.intruductionapp.model.Actor;
import pl.wsb.students.intruductionapp.repository.ActorRepository;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

@Service
@Transactional
public class ActorService {
    private final ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public Iterable<Actor> listAll()
    {
        return actorRepository.findAll();
    }

    public void save (Actor actor)
    {
        if(actor.getModified()==null)
        {
            actor.setModified(new Date());
        }

        actorRepository.save(actor);
    }
    public Actor find(Integer id)
    {
        return actorRepository.findById(id).orElse(null);
    }
    public void delete(Integer id)
    {
        actorRepository.deleteById(id);
    }
    public Iterable<Actor> listToday()
    {
        LocalDate v_ldate = java.time.LocalDate.now();
        String v_sldate = v_ldate.toString();
        Iterable<Actor> actors = actorRepository.find_today(v_sldate);
        return actors;
    }
}
