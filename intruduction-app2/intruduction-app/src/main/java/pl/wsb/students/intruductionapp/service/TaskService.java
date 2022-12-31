package pl.wsb.students.intruductionapp.service;

import org.springframework.stereotype.Service;
import pl.wsb.students.intruductionapp.model.Task;
import pl.wsb.students.intruductionapp.repository.TaskRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Date;

@Service
@Transactional
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Iterable<Task> listAll()
    {
        return taskRepository.findAll();
    }

    public void save (Task task)
    {
        if(task.getModified()==null)
        {
            task.setModified(new Date());
        }

        taskRepository.save(task);
    }
    public Task find(Integer id)
    {
        return taskRepository.findById(id).orElse(null);
    }
    public void delete(Integer id)
    {
        taskRepository.deleteById(id);
    }
    public Iterable<Task> listToday()
    {
        LocalDate v_ldate = java.time.LocalDate.now();
        String v_sldate = v_ldate.toString();
        Iterable<Task> tasks = taskRepository.find_today(v_sldate);
        return tasks;
    }
}
