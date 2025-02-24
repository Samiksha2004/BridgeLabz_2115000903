import java.lang.annotation.*;
import java.lang.reflect.Method;

@Repeatable(BugReports.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReport {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

class SoftwareModule {
    @BugReport(description = "NullPointerException occurs on null input")
    @BugReport(description = "Performance issue with large data sets")
    public void processData() {
        System.out.println("Processing data...");
    }
}

public class Exercise5 {
    public static void main(String[] args) throws Exception {
        Method method = SoftwareModule.class.getMethod("processData");

        if (method.isAnnotationPresent(BugReports.class)) {
            BugReports bugReports = method.getAnnotation(BugReports.class);
            for (BugReport bug : bugReports.value()) {
                System.out.println("Bug Report: " + bug.description());
            }
        }

        new SoftwareModule().processData();
    }
}

