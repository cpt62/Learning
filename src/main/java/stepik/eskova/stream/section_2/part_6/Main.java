package stepik.eskova.stream.section_2.part_6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Reader> readers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String inputAuthorValue;
        while (!(inputAuthorValue = scanner.nextLine()).equals("end")) {
            String[] array = inputAuthorValue.split(" +");
            try {
                if (array.length == 2) {
                    readers.add(new Reader(array[0], Integer.parseInt(array[1])));
                    for (int i = 0; i < Integer.parseInt(array[1]); i++) {
                        String[] arrayBook = scanner.nextLine().split(";");
                        readers.get(readers.size() - 1).addBook(new Book(Integer.parseInt(arrayBook[0]), arrayBook[1], arrayBook[2]));
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Не могу преобразовать String в int!");
            }
        }
        List<Book> books = readers.stream()
                .flatMap(r -> r.getBooks()
                        .stream())
                        .sorted((b1, b2) -> b1.getNumber() - b2.getNumber())
                        .toList();
        for (Book b : books) {
            System.out.println(b);
        }
    }
}

class Book {
    private int number;
    private String Author;
    private String Title;

    public Book(int number, String author, String title) {
        this.number = number;
        Author = author;
        Title = title;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return number + "#" + Author + "#" + Title;
    }
}

class Reader {
    private String LastName;
    ArrayList<Book> books;

    public Reader(String lastName, int sizeArray) {
        LastName = lastName;
        this.books = new ArrayList<>(sizeArray);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    void addBook(Book book) {
        books.add(book);
    }
}
