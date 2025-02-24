import java.lang.annotation.*;
import java.lang.reflect.Method;

// Define the @RoleAllowed annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class AccessControl {
    private String userRole;

    public AccessControl(String userRole) {
        this.userRole = userRole;
    }

    @RoleAllowed("ADMIN")
    public void adminTask() {
        System.out.println("Admin task executed successfully.");
    }

    public void executeMethod(String methodName) {
        try {
            Method method = AccessControl.class.getMethod(methodName);

            if (method.isAnnotationPresent(RoleAllowed.class)) {
                String requiredRole = method.getAnnotation(RoleAllowed.class).value();

                if (!userRole.equals(requiredRole)) {
                    System.out.println("Access Denied!");
                    return;
                }
            }

            method.invoke(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class RoleBasedAccessTest {
    public static void main(String[] args) {
        AccessControl adminUser = new AccessControl("ADMIN");
        AccessControl normalUser = new AccessControl("USER");

        System.out.println("Admin trying to access:");
        adminUser.executeMethod("adminTask");

        System.out.println("\nUser trying to access:");
        normalUser.executeMethod("adminTask");
    }
}

