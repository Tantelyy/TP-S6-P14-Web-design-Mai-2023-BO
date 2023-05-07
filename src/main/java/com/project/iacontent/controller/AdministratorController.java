package com.project.iacontent.controller;

import com.project.iacontent.model.Administrator;
import com.project.iacontent.service.AdministratorService;
import com.project.iacontent.service.ContentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class AdministratorController {
    @Autowired
    private AdministratorService administratorService;

    @Autowired
    private ContentsService contentsService;

    @GetMapping("/")
    public ModelAndView login() {
        return new ModelAndView("Login");
    }

    @PostMapping("/login")
    public ModelAndView toConnect(@ModelAttribute Administrator administrator, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        if (administratorService.isAdmin(administrator.getMail(), administrator.getPwd()) != null) {
            modelAndView.setViewName("List");

            modelAndView.addObject("contents", contentsService.findAll());

            session.setAttribute("administrator", administratorService.isAdmin(administrator.getMail(), administrator.getPwd()));

            // modelAndView.addObject("admin", administratorService.isAdmin(administrator.getMail(), administrator.getPwd()));

            return modelAndView;
        }
        modelAndView.setViewName("Login");

        modelAndView.addObject("error", "Informations incorrectes");

        return modelAndView;
    }

    @GetMapping("/signUp")
    public ModelAndView signUp(HttpSession session) {
        session.removeAttribute("administrator");

        return login();
    }
}
