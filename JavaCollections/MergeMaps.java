import java.util.HashMap;
import java.util.Map;

public class MergeMaps {
    public static Map<String, Integer> mergeTwoMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> mergedMap = new HashMap<>(map1);
        map2.forEach((key, value) -> mergedMap.merge(key, value, Integer::sum));
        return mergedMap;
    }

    public static void main(String[] args) {
        Map<String, Integer> map1 = Map.of("A", 1, "B", 2);
        Map<String, Integer> map2 = Map.of("B", 3, "C", 4);

        System.out.println(mergeTwoMaps(map1, map2)); // Output: {A=1, B=5, C=4}
    }
}

