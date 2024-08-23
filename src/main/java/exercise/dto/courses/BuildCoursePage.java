package exercise.dto.courses;

import io.javalin.validation.ValidationError;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class BuildCoursePage {
    private String name;
    private String description;
    private Map<String, List<ValidationError<Object>>> errors;

    public BuildCoursePage(String name, String description, Map<String, List<ValidationError<Object>>> errors) {
        this.name = name;
        this.description = description;
        this.errors = errors;
    }

    public BuildCoursePage() {
    }
}
