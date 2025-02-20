import java.util.*;

public class RotateList {
    public static <T> void rotateList(List<T> list, int positions) {
        int size = list.size();
        positions = positions % size;
        if (positions < 0) positions += size;
        
        List<T> temp = new ArrayList<>(list.subList(0, positions));
        list.subList(0, size - positions).clear();
        list.addAll(temp);
    }

    public static void main(String[] args) {
        List<Integer> inputList = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        int rotateBy = 2;
        rotateList(inputList, rotateBy);
        System.out.println(inputList);
    }
}

