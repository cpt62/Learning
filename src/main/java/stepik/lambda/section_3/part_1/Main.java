package stepik.lambda.section_3.part_1;

import java.util.function.Supplier;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringSupplier ss = new StringSupplier(input);
        for (int i = 0; i < 5; i++) {
            System.out.println(ss.get());
        }
    }
}

class StringSupplier implements Supplier<String> {
    private String[] array;
    private static int currentIndex;

    public StringSupplier(String input) {
        array = input.split(" +");
        currentIndex = 0;
    }

    @Override
    public String get() {
        if (currentIndex < array.length) {
            return array[currentIndex++];
        } else {
            return null;
        }
    }
}