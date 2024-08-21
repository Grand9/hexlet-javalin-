package exercise.dto.users;

import java.util.List;
import java.util.Map;
import io.javalin.validation.ValidationError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BuildUserPage {
    private String name;
    private String email;
    private Map<String, List<ValidationError<Object>>> errors;

    // Если нужен конструктор без ошибок
    public BuildUserPage(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
