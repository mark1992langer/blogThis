package com.simpleTestThis.blogThis.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Отвечает за хранение всех статей в базе данных. База данных названа: spring_web_blog

@Entity //Аннотация для модели
public class Post {

    //переменные отвечают за поля в таблице базы данных post

    @Id // для уникального идентификатора нужна аннотация из пакета javax.persistence
    @GeneratedValue(strategy = GenerationType.AUTO) // Генерирует новый id автоматически
    private Long id; // это уникальный идентификатор
    private String title, anons, full_text; // название, анонс, полный текст статьи
    private int views; //количество просмотров

    //далее идут методы получения данных из полей и назначение данных в соответствующее поле

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnons() {
        return anons;
    }

    public void setAnons(String anons) {
        this.anons = anons;
    }

    public String getFull_text() {
        return full_text;
    }

    public void setFull_text(String full_text) {
        this.full_text = full_text;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    //далее идут два конструктора класса Post

    public Post() {
    }

    public Post(String title, String anons, String full_text) {
        this.title = title;
        this.anons = anons;
        this.full_text = full_text;
    }
}
