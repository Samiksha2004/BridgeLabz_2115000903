import java.util.*;

public class DataStructureSearchComparison {
    public static void main(String[] args) {
        int n = 1000000;
        int target = n / 2;

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }

        long startArray = System.nanoTime();
        boolean arrayResult = linearSearch(array, target);
        long endArray = System.nanoTime();
        System.out.println("Array Search: " + arrayResult + " | Time: " + (endArray - startArray) / 1e6 + " ms");

        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hashSet.add(i);
        }

        long startHashSet = System.nanoTime();
        boolean hashSetResult = hashSet.contains(target);
        long endHashSet = System.nanoTime();
        System.out.println("HashSet Search: " + hashSetResult + " | Time: " + (endHashSet - startHashSet) / 1e6 + " ms");

        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            treeSet.add(i);
        }

        long startTreeSet = System.nanoTime();
        boolean treeSetResult = treeSet.contains(target);
        long endTreeSet = System.nanoTime();
        System.out.println("TreeSet Search: " + treeSetResult + " | Time: " + (endTreeSet - startTreeSet) / 1e6 + " ms");
    }

    public static boolean linearSearch(int[] arr, int target) {
        for (int value : arr) {
            if (value == target) {
                return true;
            }
        }
        return false;
    }
}
