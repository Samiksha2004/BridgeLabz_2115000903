import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

// Define the @JsonField annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

// User class with annotated fields
class User {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_email")
    private String email;

    private int age; // Not annotated, so it won't be serialized

    public User(String username, String email, int age) {
        this.username = username;
        this.email = email;
        this.age = age;
    }

    public String toJson() {
        Map<String, String> jsonMap = new HashMap<>();
        Field[] fields = this.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);
                JsonField annotation = field.getAnnotation(JsonField.class);
                try {
                    jsonMap.put(annotation.name(), field.get(this).toString());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return jsonMap.toString().replace("=", ": "); // Convert map to JSON-like format
    }
}

// Test class
public class JsonSerializationTest {
    public static void main(String[] args) {
        User user = new User("JohnDoe", "john@example.com", 25);
        System.out.println(user.toJson());
    }
}

