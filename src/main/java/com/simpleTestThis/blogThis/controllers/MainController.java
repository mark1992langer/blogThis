package com.simpleTestThis.blogThis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @GetMapping("/")
    public String home( Model model) {
        model.addAttribute("title", "this");
        return "this";
    }

    @GetMapping("/Nadik")
    public String Nadik(Model model){
        model.addAttribute("title", "Надик ты чудо:)");
        return "nadik";
    }

}
