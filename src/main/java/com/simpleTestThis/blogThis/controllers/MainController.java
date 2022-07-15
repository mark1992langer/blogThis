package com.simpleTestThis.blogThis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MainController {

    @GetMapping("/") // Какую страницу мы обрабатываем
    public String home( Model model) {
        model.addAttribute("title", "thisIs"); // параметр передающийся в шаблон, название страницы
        return "this"; // В нашем случае это html страница this из папки templates
    }

    @GetMapping("/Nadik")
    public String Nadik(Model model){
        model.addAttribute("title", "Инфо");
        return "nadik";
    }

    @GetMapping("/login")
    public String Login(Model model){
        model.addAttribute("title", "регистрация");
        return "login";
    }
}
