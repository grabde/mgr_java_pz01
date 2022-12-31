package pl.wsb.students.intruductionapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.wsb.students.intruductionapp.model.Task;
import pl.wsb.students.intruductionapp.service.TaskService;

@Controller
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @GetMapping("/")
    public String index(Model model)
    {
        model.addAttribute("listTasks", taskService.listAll());
        return "task/index";
    }
    @GetMapping("/new")
    public String create(Model model)
    {
        Task task = new Task();
        model.addAttribute("task", task);
        return "task/new";
    }
    @PostMapping("/save")
    public String saveTask(@ModelAttribute("task") Task task)
    {
        taskService.save(task);
        return "redirect:/task/";
    }
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable(name = "id") int id)
    {
        ModelAndView modelAndView = new ModelAndView("task/edit");
        modelAndView.addObject("task", taskService.find(id));
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable(name = "id") int id)
    {
        taskService.delete(id);
        return "redirect:/task/";
    }
    @GetMapping("/today")
    public String today(Model model)
    {
        model.addAttribute("listTasks", taskService.listToday());
        return "task/index";
    }
}
