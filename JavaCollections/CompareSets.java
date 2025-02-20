import java.util.Set;
import java.util.HashSet;

public class CompareSets {
    public static <T> boolean areSetsEqual(Set<T> set1, Set<T> set2) {
        return set1.equals(set2);
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Set.of(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Set.of(3, 2, 1));
        
        System.out.println(areSetsEqual(set1, set2));
    }
}

