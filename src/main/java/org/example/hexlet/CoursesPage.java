package org.example.hexlet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.hexlet.Course;

import java.util.List;

@AllArgsConstructor
@Getter
public class CoursesPage {
    private List<Course> courses;
    private String header;
}
