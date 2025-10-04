package stepik.eskova.stream.section_2.part_2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer inputValue = scanner.nextInt();
        long resultValue = Arrays
                .stream(IntStream.range(1, ++inputValue).toArray()).boxed()
                .reduce(1, (acc, x) -> acc * x);
        System.out.println(resultValue);
    }
}
