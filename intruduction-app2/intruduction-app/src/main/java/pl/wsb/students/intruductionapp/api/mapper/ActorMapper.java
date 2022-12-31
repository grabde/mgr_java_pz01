package pl.wsb.students.intruductionapp.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import pl.wsb.students.intruductionapp.api.model.ActorDTO;
import pl.wsb.students.intruductionapp.model.Actor;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ActorMapper {
    @Mappings({
            @Mapping(target="id", source="id"),
            @Mapping(target="zadanie", source="zadanie"),
            @Mapping(target="termin", source="termin", dateFormat = "dd.MM.yyyy")
    })
    ActorDTO actorToActorDTO(Actor entity);
    @Mappings({
            @Mapping(target="id", source="id"),
            @Mapping(target="zadanie", source="zadanie"),
            @Mapping(target="termin", source="termin", dateFormat = "dd.MM.yyyy")
    })
    Actor actorDTOToActor(ActorDTO dto);
    List<ActorDTO> map(Iterable<Actor> actors);
}
