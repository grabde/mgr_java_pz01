package pl.wsb.students.intruductionapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.wsb.students.intruductionapp.api.mapper.MovieMapper;
import pl.wsb.students.intruductionapp.api.model.MovieDTO;
import pl.wsb.students.intruductionapp.exceptions.NotFoundException;
import pl.wsb.students.intruductionapp.model.Movie;
import pl.wsb.students.intruductionapp.service.MovieService;

import javax.validation.Valid;


@Controller
@RequestMapping("/movie")
public class MovieController {
    private final Logger logger = LoggerFactory.getLogger(MovieController.class);
    @Autowired
    private MovieService movieService;
    @Autowired
    private MovieMapper movieMapper;
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute(
                "listMovies",
                movieMapper.map(
                        movieService.listAll()
                )
        );
        return "movie/index";
    }
    @RequestMapping("/new")
    public String create(Model model) {
        MovieDTO movieDTO = movieMapper.movieToMovieDTO(
                new Movie()
        );
        model.addAttribute("movie", movieDTO);
        return "movie/new";
    }
    @PostMapping("/save")
    public String saveMovie(@Valid @ModelAttribute("movie") MovieDTO movieDTO, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
        {
            if(movieDTO.getId() == null) return "movie/new";
            return "movie/edit";
        }
        movieService.save(
                movieMapper.movieDTOToMovie(
                        movieDTO
                )
        );
        return "redirect:/movie/";
    }
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") int id, Model model) {
        try
        {
            MovieDTO movieDTO = movieMapper.movieToMovieDTO(movieService.find(id));
            if(movieDTO == null)
            {
                throw new NotFoundException("Movie not found");
            }
            model.addAttribute("movie", movieDTO);

        return "movie/edit";
        }
        catch (NotFoundException ex)
        {
            logger.warn(ex.getMessage());
            return "error/not_found";
        }
        catch (Throwable ex)
        {
            logger.warn(ex.getMessage());
            return "error/error";
        }
    }
    @RequestMapping("/delete/{id}")
    public String deleteMovie(@PathVariable(name = "id") int id) {
        movieService.delete(id);
        return "redirect:/movie/";
    }
}