import java.lang.reflect.Method;

class ExecutionTimer {
    public static void measureExecutionTime(Object obj, String methodName, Object... args) {
        try {
            Class<?> clazz = obj.getClass();
            Method method = clazz.getMethod(methodName);
            
            long startTime = System.nanoTime();
            method.invoke(obj, args);
            long endTime = System.nanoTime();
            
            System.out.println("Execution time of " + methodName + ": " + (endTime - startTime) + " ns");
        } catch (Exception e) {
            throw new RuntimeException("Failed to execute method: " + methodName, e);
        }
    }
}

class SampleClass {
    public void fastMethod() {
        for (int i = 0; i < 1000; i++);
    }

    public void slowMethod() {
        for (int i = 0; i < 1000000; i++);
    }
}

public class ExecutionTimingTest {
    public static void main(String[] args) {
        SampleClass obj = new SampleClass();

        ExecutionTimer.measureExecutionTime(obj, "fastMethod");
        ExecutionTimer.measureExecutionTime(obj, "slowMethod");
    }
}

