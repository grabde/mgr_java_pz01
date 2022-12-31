package pl.wsb.students.intruductionapp.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import pl.wsb.students.intruductionapp.model.Task;
import pl.wsb.students.intruductionapp.repository.TaskRepository;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class TaskServiceTest {
    @Autowired
    private TaskService taskService;
    @MockBean
    private TaskRepository repository;
    @Test
    void listAll_whenFound_thenReturnResult() {
// Setup our mock repository
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
        doReturn(Arrays.asList(task1, task2)).when(repository).findAll();
        Iterable<Task> movies = taskService.listAll();
        Assertions.assertEquals(2, StreamSupport.stream(movies.spliterator(), false).count());
    }
    @Test
    void find_whenFound_thenReturnResult() {
// Setup our mock repository
        Task task2 = new Task(
                1,
                new Date(),
                new Date(),
                "Zadanie 2",
                "2023-01-01"
        );
        doReturn(Optional.of(task2)).when(repository).findById(1);
// Execute the service call
        Task result = taskService.find(1);
// Assert the response
        Assertions.assertTrue((result != null) );
        Assertions.assertSame(result, task2);
    }
    @Test
    void find_whenNotFound_thenReturnNull() {
// Setup our mock repository
        doReturn(Optional.empty()).when(repository).findById(1);
// Execute the service call
        Task result = taskService.find(1);
// Assert the response
        Assertions.assertTrue((result == null) );
    }
}

