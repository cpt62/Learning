package ai.examples.example_3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {2,3,4};
        int sizeNeeded = array.length+1;
        System.out.println((sizeNeeded * (sizeNeeded + 1) / 2) - Arrays.stream(array).boxed().reduce(0, Integer::sum));
    }
}
