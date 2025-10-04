package stepik.eskova.stream.section_2.part_3;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputValue;
        List<String> list = new ArrayList<>();
        while (!(inputValue = scanner.nextLine()).equals("end")) {
            list.add(inputValue);
        }
        String result = list.stream().collect(Collectors.joining(" "));
        Optional<String> shortString = list.stream().min(Comparator.comparing(String::length));
        System.out.println(!result.isEmpty() ? result : "Empty data");
        System.out.println(shortString.orElse("?"));
    }
}
