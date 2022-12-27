package pl.wsb.students.intruductionapp.controller;

import org.assertj.core.util.Lists;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import pl.wsb.students.intruductionapp.model.Movie;
import pl.wsb.students.intruductionapp.service.MovieService;

import java.util.Date;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class MovieControllerTest {
    @MockBean
    private MovieService service;
    @Autowired
    private MockMvc mockMvc;@Test
    void index() throws Exception {
// Setup our mocked service
        Movie movie = new Movie(
                1,
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
        doReturn(Lists.newArrayList(movie, movie2)).when(service).listAll();
// Execute the GET request
        mockMvc.perform(get("/movie/"))
// Validate the response code and content type
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
// Validate view
                .andExpect(view().name("movie/index"))
// Validate content
                .andExpect(content().string(Matchers.containsString("Tytuł filmu"))).andExpect(content().string(Matchers.containsString("2020")))
//Print
                .andDo(MockMvcResultHandlers.print());
    }
}