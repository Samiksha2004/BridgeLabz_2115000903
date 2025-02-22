
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

class ListManager {
    public static void addElement(List<Integer> list, int element) {
        list.add(element);
    }

    public static void removeElement(List<Integer> list, int element) {
        list.remove(Integer.valueOf(element));
    }

    public static int getSize(List<Integer> list) {
        return list.size();
    }
}

public class ListManagerTest {
    @Test
    void testAddElement() {
        List<Integer> list = new ArrayList<>();
        ListManager.addElement(list, 10);
        assertEquals(1, list.size());
        assertTrue(list.contains(10));
    }

    @Test
    void testRemoveElement() {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        ListManager.removeElement(list, 10);
        assertEquals(1, list.size());
        assertFalse(list.contains(10));
    }

    @Test
    void testGetSize() {
        List<Integer> list = new ArrayList<>();
        assertEquals(0, ListManager.getSize(list));
        list.add(10);
        list.add(20);
        assertEquals(2, ListManager.getSize(list));
    }
}
