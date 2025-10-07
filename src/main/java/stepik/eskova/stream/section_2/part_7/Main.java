package stepik.eskova.stream.section_2.part_7;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Purchase> purchaseList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String inputString;
        while (!(inputString = scanner.nextLine()).equals("end")) {
            String[] arrayPurchase = inputString.split(" +");
            Purchase purchase;
            if (arrayPurchase.length == 2) {
                purchase = new Purchase(arrayPurchase[0]);
                for (int i = 0; i < Integer.parseInt(arrayPurchase[1]); i++) {
                    String[] arrayCommodity = scanner.nextLine().split(" +");
                    if (arrayCommodity.length == 3) {
                        purchase.addItem(new Commodity(arrayCommodity[0], Integer.parseInt(arrayCommodity[1]))
                                , Double.parseDouble(arrayCommodity[2]));
                    } else throw new IllegalArgumentException("Неверное количество данных о товаре. " +
                            "Необходимо: Название товара, цена, количество");
                }
            } else
                throw new IllegalArgumentException("Неверное количество входных данных. " +
                        "Необходимо: Карта + количество товара, через пробел");
            purchaseList.add(purchase);
        }
        Set <Commodity> set = purchaseList.stream().flatMap(p -> p.getCart().keySet().stream()).collect(Collectors.toSet());
        set.stream().sorted(Comparator.comparing(Commodity::getName)).forEach(System.out::println);
    }
}

class Commodity {
    private String name;
    private int unitPrice;

    public Commodity(String name, int price) {
        this.name = name;
        this.unitPrice = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commodity commodity = (Commodity) o;
        return unitPrice == commodity.unitPrice && Objects.equals(name, commodity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, unitPrice);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + ";" + unitPrice;
    }
}

class Purchase {
    private String cardNumber;
    private HashMap<Commodity, Double> cart;

    public Purchase(String cardNumber) {
        this.cardNumber = cardNumber;
        cart = new HashMap<>();
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public HashMap<Commodity, Double> getCart() {
        return cart;
    }

    void addItem(Commodity item, Double number) {
        cart.put(item, number);
    }
}