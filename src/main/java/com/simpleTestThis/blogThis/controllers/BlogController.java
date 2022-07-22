package com.simpleTestThis.blogThis.controllers;

import com.simpleTestThis.blogThis.models.Post;
import com.simpleTestThis.blogThis.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

// Данный клас отвечает только за контроллер блога и только за него

@Controller
public class BlogController {

    //переменная ссылающаяся на репозиторий

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/blog")
    public String blogMain(Model model) {
        Iterable<Post> posts = postRepository.findAll(); //здесь будут сод все значения из таблицы
        model.addAttribute("posts", posts);
        return "pages_html/blogs_html/blog-main";
    }

    @GetMapping("/blog/add")// форма добавление статьи
    public String blogAdd(Model model) {
        return "pages_html/blogs_html/blog-add";
    }

    @PostMapping("/blog/add")//получение всех данных статьи и занесение их в базу
    public String blogPostAdd(@RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model) {
        Post post = new Post(title, anons, full_text);
        postRepository.save(post);//добавление полученных данных в таблицу пост
        return "redirect:/blog";//переадресация пользователя на страницу blog
    }

    @GetMapping("/blog/{id}")//просмотр определенной статьи
    public String blogDetails(@PathVariable(value = "id") long id, Model model) {
        if (!postRepository.existsById(id)) {//проверяем существует ли такая статья
            return "redirect:/blog";
        }
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "pages_html/blogs_html/blog-details";
    }

    @GetMapping("/blog/{id}/edit")//переходим к редактированию
    public String blogEdit(@PathVariable(value = "id") long id, Model model) {
        if (!postRepository.existsById(id)) {
            return "redirect:/blog";
        }
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "pages_html/blogs_html/blog-edit";
    }

    @PostMapping("/blog/{id}/edit")//совершаем редактирование
    public String blogPostUpdate(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model) {
        Post post = postRepository.findById(id).orElseThrow();
        post.setTitle(title);
        post.setAnons(anons);
        post.setFull_text(full_text);
        postRepository.save(post);
        return "redirect:/blog";
    }

    @PostMapping("/blog/{id}/remove")//совершаем удаление
    public String blogPostDelete(@PathVariable(value = "id") long id, Model model) {
        Post post = postRepository.findById(id).orElseThrow();
        postRepository.delete(post);
        return "redirect:/blog";
    }
}
