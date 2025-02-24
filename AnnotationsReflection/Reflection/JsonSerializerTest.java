import java.lang.reflect.Field;

class JsonSerializer {
    public static String toJson(Object obj) {
        StringBuilder json = new StringBuilder("{");
        try {
            Class<?> clazz = obj.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                String name = fields[i].getName();
                Object value = fields[i].get(obj);
                json.append("\"").append(name).append("\": ");
                json.append(value instanceof String ? "\"" + value + "\"" : value);
                if (i < fields.length - 1) {
                    json.append(", ");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to serialize object", e);
        }
        json.append("}");
        return json.toString();
    }
}

class Person {
    private String name;
    private int age;
    private boolean isStudent;

    public Person(String name, int age, boolean isStudent) {
        this.name = name;
        this.age = age;
        this.isStudent = isStudent;
    }
}

public class JsonSerializerTest {
    public static void main(String[] args) {
        Person person = new Person("Alice", 25, true);
        String json = JsonSerializer.toJson(person);
        System.out.println(json);
    }
}

