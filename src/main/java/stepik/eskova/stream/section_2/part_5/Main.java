package stepik.eskova.stream.section_2.part_5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String inputString;
        while (!(inputString = scanner.nextLine()).equals("end")) {
            if ((inputString.isEmpty())) continue;
            String[] array = inputString.split(" +");
            if (array.length == 2) {
                dogs.add(new Dog(array[0], array[1]));
            } else {
                try {
                    dogs.add(new Dog(array[0], array[1], new Collar(array[2], Integer.parseInt(array[3]))));
                } catch (NumberFormatException numberFormatException) {
                    System.out.println(numberFormatException.getMessage());
                }
            }
        }
        List<Collar> collars = dogs.stream()
                .filter(dog -> dog.getCollar() != null)
                .sorted(Comparator.comparingInt(d -> d.getCollar().getSize()))
                .map(Dog::getCollar).toList();
        System.out.println(collars);
    }

}

class Collar {
    private String color;
    private int size;

    public Collar(String color, int size) {
        this.color = color;
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return color + ";" + size;
    }

}

class Dog {
    private String nickName;
    private String breed;
    private Collar collar;

    public Dog(String nickName, String breed) {
        this.nickName = nickName;
        this.breed = breed;
    }

    public Dog(String nickName, String breed, Collar collar) {
        this.nickName = nickName;
        this.breed = breed;
        this.collar = collar;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Collar getCollar() {
        return collar;
    }

    public void setCollar(Collar collar) {
        this.collar = collar;
    }

    @Override
    public String toString() {
        return nickName + ";" + breed + ";" + collar;
    }
}
