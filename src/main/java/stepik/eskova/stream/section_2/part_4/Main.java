package stepik.eskova.stream.section_2.part_4;


//import java.util.IntSummaryStatistics;
//import java.util.Locale;
//import java.util.Random;
//import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        Random random = new Random(scanner.nextLong());
        IntSummaryStatistics intSummaryStatistics = random.ints(10000, 0, 1001).summaryStatistics();
        System.out.println(intSummaryStatistics);
    }
}
