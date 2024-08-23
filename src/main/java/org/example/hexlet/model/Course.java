package org.example.hexlet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Course {
    private Long id; // Добавьте id для идентификации курса
    private String name;
    private String description;

    // Конструктор без id для создания нового курса
    public Course(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
