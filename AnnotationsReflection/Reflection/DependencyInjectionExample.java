import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {}

class DIContainer {
    private final Map<Class<?>, Object> instances = new HashMap<>();

    public void register(Class<?> clazz) {
        try {
            Object instance = clazz.getDeclaredConstructor().newInstance();
            instances.put(clazz, instance);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create instance for: " + clazz, e);
        }
    }

    public void injectDependencies(Object object) {
        try {
            for (Field field : object.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(Inject.class)) {
                    Object dependency = instances.get(field.getType());
                    if (dependency == null) {
                        throw new RuntimeException("No registered instance for: " + field.getType());
                    }
                    field.setAccessible(true);
                    field.set(object, dependency);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Dependency injection failed", e);
        }
    }
}

class Service {
    public void execute() {
        System.out.println("Service executed.");
    }
}

class Client {
    @Inject
    private Service service;

    public void run() {
        service.execute();
    }
}

public class DependencyInjectionExample {
    public static void main(String[] args) {
        DIContainer container = new DIContainer();
        container.register(Service.class);

        Client client = new Client();
        container.injectDependencies(client);
        client.run();
    }
}

