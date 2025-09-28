package stepik.eskova.lambda.section_1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Задача: "Фильтруем список покупок"
 * Платформа: Stepik — Java. Прокачай Java, задача 6.1
 * Описание: см. README.md
 * Автор: Алексей Обмачевский
 * Дата: 2025-09-21
 */


@FunctionalInterface
interface TestPurchases {
    boolean test(Purchase p);
}

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

    public static void purchaseFilter(ArrayList<Purchase> list, TestPurchases t) {
        boolean check = false;
        for (Purchase p : list) {
            if (t.test(p)) {
                if (!check) check = true;
                System.out.println(p);
            }
        } if (!check) System.out.println("Error");
    }

    @Override
    public String toString() {
        return name + ";" + price + ";" + count + ";" + getCost();
    }
}


class Main {
    public static void main(String[] args) {
        ArrayList<Purchase> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        /* Данные поступают на вход в виде строки в формате *.csv до тех пор, пока не будет введен "end"
        Условием задачи гарантировано, что данные поступают в корректном виде */
        String inputStr, lastNamed;
        while (!(inputStr = scanner.nextLine()).equals("end")) {
            String[] array;
            if (!inputStr.isEmpty()) {
                array = inputStr.split(";");
            } else continue;
            list.add(new Purchase(array[0], Integer.parseInt(array[1]), Integer.parseInt(array[2])));
        }
        lastNamed = scanner.nextLine();
        scanner.close();
        Purchase.purchaseFilter(list, p -> p.getName().equals(lastNamed));
        System.out.println();
        Purchase.purchaseFilter(list, p -> p.getCost() >= 2000);
    }

}

