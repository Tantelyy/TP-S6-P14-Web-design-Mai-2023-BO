package com.project.iacontent.controller;

import com.project.iacontent.model.Administrator;
import com.project.iacontent.model.Contents;
import com.project.iacontent.service.AdministratorService;
import com.project.iacontent.service.ContentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.time.LocalDateTime;


@Controller
public class ContentsController {
    @Autowired
    private ContentsService contentsService;

    @Autowired
    private AdministratorService administratorService;

    @GetMapping("/contents")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("contents", contentsService.findAll());

        modelAndView.setViewName("List");

        return modelAndView;
    }

    @PostMapping("/addContents")
    public ModelAndView addContent(@ModelAttribute Contents contents) {
        Administrator administrator = administratorService.findById(contents.getIdAdmin());
        contents.setAdmin(administrator);

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("Home");
        modelAndView.addObject("admin", administrator);

        if (!contents.getContent().equals("") && !contents.getTitle().equals("")) {
            contentsService.save(contents);
        } else {
            modelAndView.addObject("error", "Informations incorrectes");
        }

        return modelAndView;

    }

    @GetMapping("/deleteContent/{id}")
    public ModelAndView deleteContent(@PathVariable Integer id) {
        contentsService.delete(id);

        return findAll();
    }

    @GetMapping("/modifyContent/{id}")
    public ModelAndView modifyContent(@PathVariable Integer id) {
        Contents contents = contentsService.findById(id);

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("Modify");

        modelAndView.addObject("contents", contents);

        return modelAndView;
    }

    @PostMapping("/confirmModify")
    public ModelAndView confirmModify(@ModelAttribute Contents contents) {
        Administrator administrator = administratorService.findById(contents.getIdAdmin());
        contents.setAdmin(administrator);
        contents.setDateHour(Timestamp.valueOf(LocalDateTime.now()));

        if (!contents.getContent().equals("") && !contents.getTitle().equals("")) {
            contentsService.save(contents);

            return findAll();
        }

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("error", "Informations invalides");

        modelAndView.setViewName("Modify");

        modelAndView.addObject("contents", contents);

        return modelAndView;
    }

    @GetMapping("/newContents")
    public ModelAndView newContents() {
        return new ModelAndView("Home");
    }
}
