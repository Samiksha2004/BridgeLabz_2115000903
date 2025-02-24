import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

class Application {
    @ImportantMethod
    public void criticalOperation() {
        System.out.println("Executing critical operation...");
    }

    @ImportantMethod(level = "MEDIUM")
    public void secondaryOperation() {
        System.out.println("Executing secondary operation...");
    }

    public void normalOperation() {
        System.out.println("Executing normal operation...");
    }
}

public class BeginnerLevel1 {
    public static void main(String[] args) throws Exception {
        Method[] methods = Application.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Important Method: " + method.getName() + " (Level: " + annotation.level() + ")");
            }
        }

        new Application().criticalOperation();
        new Application().secondaryOperation();
        new Application().normalOperation();
    }
}

