package ai.examples.example_stack;

import java.util.ArrayDeque;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String test = "((())";
        System.out.println(findTruth(test));

    }

    static boolean findTruth(String str) {
        Map<Character, Character> map = Map.of(')', '(', '}', '{', ']', '[');
        ArrayDeque<Character> deque = new ArrayDeque<>();
        if (str.isEmpty()) return true;
        char[] characters = str.toCharArray();
        for (char c : characters) {
            if (map.containsValue(c)) {
                deque.push(c);
            } else if (deque.isEmpty() || deque.pop() != map.get(c)) {
                return false;
            }
        }
        return deque.isEmpty(); // Ключевой момент!
    }
}

