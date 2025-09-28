package stepik.eskova.lambda.section_3.part_3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Purchases> list = new ArrayList<>();
        String input;
        while (!(input = scanner.nextLine()).equals("end")) {
            String[] arr = input.split(";");
            list.add(new Purchases(arr[0], Integer.parseInt(arr[1]), Integer.parseInt(arr[2])));
        }
        Comparator<Purchases> comparatorByName = Comparator.comparing(
                Purchases::getName);
        Comparator<Purchases> complexComparing = comparatorByName.thenComparing(p -> -p.getCost());
        list.sort(complexComparing);
        list.forEach(System.out::println);
    }
}

class Purchases {
    private String name;
    private int price;
    private int count;

    public Purchases(String name, int price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    int getCost() {
        return price * count;
    }

    @Override
    public String toString() {
        return name + ";" + price + ";" + count + ";" + getCost();
    }
}

