package ai.examples.example_1;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<Character, Integer> characterCounter = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);
        String inputValue = scanner.nextLine();
        while (inputValue.isEmpty()) {
            System.out.println("Значение не может быть пустым");
            inputValue = scanner.nextLine();
        }
        for (Character c : inputValue.toCharArray()) {
            characterCounter.put(c, characterCounter.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : characterCounter.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println(entry.getKey());
                return;
            }
        }
        System.out.println("null");
    }
}
