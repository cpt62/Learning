package stepik.eskova.lambda.section_2.part1;

import java.util.ArrayList;
import java.util.Scanner;
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

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public int getCost() {
        return price * count;
    }

    @Override
    public String toString() {
        return name + ";" + price + ";" + count + ";" + getCost();
    }

    public static void printFilter(ArrayList<Purchase> list, Predicate<Purchase> p) {
        for (Purchase purchase : list) {
            if (p.test(purchase)) System.out.println(purchase);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Purchase> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        /* Данные поступают на вход в виде строки в формате *.csv до тех пор, пока не будет введен "end".
        Список не предполагается пустым. */
        String inputStr;
        while (!(inputStr = scanner.nextLine()).equals("end")) {
            String[] array;
            if (!inputStr.isEmpty()) {
                array = inputStr.split(";");
            } else continue;
            list.add(new Purchase(array[0], Integer.parseInt(array[1]), Integer.parseInt(array[2])));
        }
        Purchase.printFilter(list, p -> p.getCost() < 200);
        System.out.println();
        Purchase.printFilter(list, p -> p.getName().startsWith("А"));
    }
}
