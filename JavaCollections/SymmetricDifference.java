import java.util.Set;
import java.util.HashSet;

public class SymmetricDifference {
    public static <T> Set<T> symmetricDifference(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        Set<T> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        result.addAll(set2);
        result.removeAll(intersection);
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Set.of(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Set.of(3, 4, 5));

        System.out.println("Symmetric Difference: " + symmetricDifference(set1, set2));
    }
}

