package pl.wsb.students.intruductionapp.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import pl.wsb.students.intruductionapp.api.model.MovieDTO;
import pl.wsb.students.intruductionapp.model.Movie;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    @Mappings(
            {
                    @Mapping(target = "directorFirstName", source = "director.firstName"),
                    @Mapping(target = "directorLastName", source = "director.lastName"),
                    @Mapping(target = "directorId", source = "director.id")
            }
    )
    MovieDTO movieToMovieDTO(Movie entity);
    @Mappings(
            {
                    @Mapping(target = "director.id", source = "directorId")
            }
    )
    Movie movieDTOToMovie(MovieDTO dto);
    List<MovieDTO> map(Iterable<Movie> movies);
}
