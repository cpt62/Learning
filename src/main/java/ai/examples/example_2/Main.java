package ai.examples.example_2;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println(findAnnagram("hello", "elloh"));
    }

    static boolean findAnnagram(String val1, String val2) throws IllegalArgumentException {
        if ((val1.isEmpty()) || val2.isEmpty())
            return false;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        val1.toLowerCase().replaceAll("[^a-zA-Z]", "").chars().mapToObj(c -> (char) c).forEach(c ->
                map1.put(c, map1.getOrDefault(c, 0) + 1));
        val2.toLowerCase().replaceAll("[^a-zA-Z]", "").chars().mapToObj(c -> (char) c).forEach(c ->
                map2.put(c, map2.getOrDefault(c, 0) + 1));
        return map1.equals(map2);
    }
}



