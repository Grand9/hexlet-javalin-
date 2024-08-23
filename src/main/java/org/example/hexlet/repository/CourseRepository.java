package org.example.hexlet.repository;

import org.example.hexlet.model.Course;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CourseRepository {
    private static final List<Course> COURSES = new ArrayList<>();
    private static Long nextId = 1L;

    public static void save(Course course) {
        if (course.getId() == null) {
            course.setId(nextId++);
            COURSES.add(course);
        } else {
            // Обновление существующего курса
            var index = COURSES.indexOf(course);
            if (index != -1) {
                COURSES.set(index, course);
            }
        }
    }

    public static Optional<Course> find(Long id) {
        return COURSES.stream()
                .filter(course -> id.equals(course.getId()))
                .findFirst();
    }

    public static void delete(Long id) {
        COURSES.removeIf(course -> id.equals(course.getId()));
    }

    public static List<Course> getEntities() {
        return new ArrayList<>(COURSES);
    }
}
