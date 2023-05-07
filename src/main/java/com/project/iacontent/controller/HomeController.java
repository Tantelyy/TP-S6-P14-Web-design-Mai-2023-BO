package com.project.iacontent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    /*
    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("Home");
    }
     */
/*
    @PostMapping("/addContents")
    public ModelAndView addContents(@RequestParam(name = "contents") String contents) {
        System.out.println(contents);
        return null;
    }

 */

    /*
    @GetMapping("/list")
    public ModelAndView list() {
        Produit produit = new Produit();
        produit.setName("Tennis blanc de Tana");
        produit.setPrice(500.75);

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("product", produit);

        modelAndView.setViewName("List");

        return modelAndView;
    }
     */

    @GetMapping("/product-details/{id}")
    public ModelAndView details(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("id", id);

        modelAndView.setViewName("Details");

        return modelAndView;
    }

    @GetMapping("/person-details")
    public ModelAndView person(@RequestParam(name = "name") String name, @RequestParam(name = "id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("id", id);
        modelAndView.addObject("name", name);

        modelAndView.setViewName("Person");

        return modelAndView;
    }

}
