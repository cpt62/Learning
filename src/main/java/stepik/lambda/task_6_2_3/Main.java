package stepik.lambda.task_6_2_3;

import java.util.ArrayList;
import java.util.Scanner;

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

    /*Добавим только нужный сеттер*/

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + ";" + price + ";" + count + ";" + getCost();
    }

    public static void raisePrice(ArrayList<Purchase> list) {
        list.forEach(p -> {
            p.setPrice((int) (p.price + (p.getPrice() * 0.05)));
        });
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
        Purchase.raisePrice(list);
        list.forEach(System.out::println);
    }
}
