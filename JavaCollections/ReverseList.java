import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReverseList {
    public static <T> void reverseList(List<T> list) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            T temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        reverseList(arrayList);
        System.out.println("Reversed ArrayList: " + arrayList);

        List<Integer> linkedList = new LinkedList<>(List.of(1, 2, 3, 4, 5));
        reverseList(linkedList);
        System.out.println("Reversed LinkedList: " + linkedList);
    }
}

