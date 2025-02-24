import java.lang.reflect.Constructor;

class Student {
    private String name;
    private int age;

    public Student() {
        this.name = "Default";
        this.age = 18;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println("Student Name: " + name + ", Age: " + age);
    }
}

public class DynamicObjectCreation {
    public static void main(String[] args) {
        try {
            Class<?> studentClass = Class.forName("Student");

            Constructor<?> defaultConstructor = studentClass.getDeclaredConstructor();
            Object student1 = defaultConstructor.newInstance();
            ((Student) student1).display();

            Constructor<?> paramConstructor = studentClass.getDeclaredConstructor(String.class, int.class);
            Object student2 = paramConstructor.newInstance("Alice", 22);
            ((Student) student2).display();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

