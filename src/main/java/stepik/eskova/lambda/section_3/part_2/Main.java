package stepik.eskova.lambda.section_3.part_2;

import java.util.Optional;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class Purchase {
    private String name;
    private int price;
    private int count;

    public Purchase(String name, int price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    //Сеттеры не задавал, так как в данной задаче в них нет необходимости

    public String getName() {
        return name;
    }

    public int getCost() {
        return price * count;
    }

    @Override
    public String toString() {
        return name + ";" + price + ";" + count + ";" + getCost();
    }

    static Optional<Purchase> findFirst(List<Purchase> list, Predicate<Purchase> predicate) {
        for (Purchase p : list) {
            if (predicate.test(p)) return Optional.ofNullable(p);
        }
        return Optional.empty();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Purchase> list = new ArrayList<>();
        String inputStr, lastNamed;
        while (!(inputStr = scanner.nextLine()).equals("end")) {
            String[] array;
            if (!inputStr.isEmpty()) {
                array = inputStr.split(";");
            } else continue;
            list.add(new Purchase(array[0], Integer.parseInt(array[1]), Integer.parseInt(array[2])));
        }
        System.out.println("Первая покупка на букву М: "
                + Purchase.findFirst(list, p ->
                p.getName().startsWith("М")).orElse(new Purchase("Покупка не найдена", 0, 0)));

        System.out.println("Первая покупка со стоимостью больше 1000: " +
                Purchase.findFirst(list, p ->
                        p.getCost() > 1000).orElse(new Purchase("Покупка не найдена", 0, 0)));
    }
}

