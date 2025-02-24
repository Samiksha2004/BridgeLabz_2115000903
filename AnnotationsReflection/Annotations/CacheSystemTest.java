import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {
}

class ExpensiveOperations {
    private static final Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    public int computeSquare(int number) {
        if (cache.containsKey(number)) {
            System.out.println("Returning cached result for: " + number);
            return cache.get(number);
        }
        System.out.println("Computing result for: " + number);
        int result = number * number;
        cache.put(number, result);
        return result;
    }
}

public class CacheSystemTest {
    public static void main(String[] args) throws Exception {
        ExpensiveOperations operations = new ExpensiveOperations();
        Method method = ExpensiveOperations.class.getMethod("computeSquare", int.class);

        if (method.isAnnotationPresent(CacheResult.class)) {
            System.out.println(operations.computeSquare(5));
            System.out.println(operations.computeSquare(5));
            System.out.println(operations.computeSquare(7));
            System.out.println(operations.computeSquare(7));
        }
    }
}

