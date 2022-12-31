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
import pl.wsb.students.intruductionapp.model.Task;
import pl.wsb.students.intruductionapp.service.TaskService;

import java.util.Date;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class TaskControllerTest {
    @MockBean
    private TaskService service;
    @Autowired
    private MockMvc mockMvc;@Test
    void index() throws Exception {
// Setup our mocked service
        Task task1 = new Task(
                1,
                new Date(),
                new Date(),
                "Zadanie 1",
                "2023-01-01"
        );
        Task task2 = new Task(
                1,
                new Date(),
                new Date(),
                "Zadanie 2",
                "2023-01-01"
        );
        doReturn(Lists.newArrayList(task1, task2)).when(service).listAll();
// Execute the GET request
        mockMvc.perform(get("/task/"))
// Validate the response code and content type
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
// Validate view
                .andExpect(view().name("task/index"))
// Validate content
                .andExpect(content().string(Matchers.containsString("Zadanie 2"))).andExpect(content().string(Matchers.containsString("2023-01-01")))
//Print
                .andDo(MockMvcResultHandlers.print());
    }
}