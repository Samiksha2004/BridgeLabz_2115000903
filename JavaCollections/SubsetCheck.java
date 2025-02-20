import java.util.Set;
import java.util.HashSet;

public class SubsetCheck {
    public static <T> boolean isSubset(Set<T> subset, Set<T> superset) {
        return superset.containsAll(subset);
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Set.of(2, 3));
        Set<Integer> set2 = new HashSet<>(Set.of(1, 2, 3, 4));

        System.out.println(isSubset(set1, set2));
    }
}

