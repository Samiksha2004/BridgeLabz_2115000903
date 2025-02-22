import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;

class TaskUtils {
    public static String longRunningTask() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Task Finished";
    }
}

public class LongRunningTaskTest {
    @Test
    @Timeout(2)
    void testLongRunningTask() {
        String result = TaskUtils.longRunningTask();
        assertEquals("Task Finished", result);
    }
}
