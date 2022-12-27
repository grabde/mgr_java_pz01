package pl.wsb.students.intruductionapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.wsb.students.intruductionapp.model.Actor;
import pl.wsb.students.intruductionapp.service.ActorService;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

@Controller
@RequestMapping("/actor")
public class ActorController {
    @Autowired
    private ActorService actorService;
    @GetMapping("/")
    public String index(Model model)
    {
        model.addAttribute("listActors", actorService.listAll());
        return "actor/index";
    }
    @GetMapping("/new")
    public String create(Model model)
    {
        Actor actor = new Actor();
        model.addAttribute("actor", actor);
        return "actor/new";
    }
    @PostMapping("/save")
    public String saveActor(@ModelAttribute("actor") Actor actor)
    {
        String sdate = String.valueOf(actor.getTermin());
        String stermin = sdate.substring(0, 8);
        stermin = stermin + " 00:00:00";
        DateFormat formatter = DateFormat.getDateInstance();
        try {
            Date termin = formatter.parse(stermin);
            actor.setTermin(termin);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        actorService.save(actor);
        return "redirect:/actor/";
    }
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable(name = "id") int id)
    {
        ModelAndView modelAndView = new ModelAndView("actor/edit");
        modelAndView.addObject("actor", actorService.find(id));
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public String deleteActor(@PathVariable(name = "id") int id)
    {
        actorService.delete(id);
        return "redirect:/actor/";
    }
}
