import java.util.LinkedList;
import java.util.ListIterator;

public class NthFromEnd {
    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        ListIterator<T> first = list.listIterator();
        ListIterator<T> second = list.listIterator();

        for (int i = 0; i < n; i++) {
            if (!first.hasNext()) return null;
            first.next();
        }

        while (first.hasNext()) {
            first.next();
            second.next();
        }

        return second.next();
    }

    public static void main(String[] args) {
        LinkedList<String> inputList = new LinkedList<>(List.of("A", "B", "C", "D", "E"));
        int n = 2;
        System.out.println(findNthFromEnd(inputList, n));
    }
}

