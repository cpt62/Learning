package stepik.eskova.stream.section_1;

import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random(scanner.nextLong());
        Stream.generate(() -> rand.nextInt(10, 21)).limit(6).forEach(x -> System.out.println(x + " "));
    }
}
