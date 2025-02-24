import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ClassInfoRetriever {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter full class name: ");
        String className = scanner.nextLine();

        try {
            Class<?> cls = Class.forName(className);

            System.out.println("\nClass Name: " + cls.getName());

            System.out.println("\nFields:");
            for (Field field : cls.getDeclaredFields()) {
                System.out.println(field);
            }

            System.out.println("\nConstructors:");
            for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
                System.out.println(constructor);
            }

            System.out.println("\nMethods:");
            for (Method method : cls.getDeclaredMethods()) {
                System.out.println(method);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found!");
        }
    }
}

