package org.example.hexlet.repository;

import org.example.hexlet.Course;
import java.util.ArrayList;
import java.util.List;

public class CourseRepository {
    private static final List<Course> COURSES = new ArrayList<>();

    public static void save(Course course) {
        COURSES.add(course);
    }

    public static List<Course> getEntities() {
        return new ArrayList<>(COURSES);
    }
}
