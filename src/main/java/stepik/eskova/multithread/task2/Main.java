package stepik.eskova.multithread.task2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("./src/main/java/stepik/eskova/multithread/task1/test100.txt"))) {
            Job one = new Job(br);
            Job two = new Job(br);
            Job three = new Job(br);
            Thread first = new Thread(one, "first");
            Thread second = new Thread(two, "second");
            Thread third = new Thread(three, "third");
            first.start();
            second.start();
            third.start();
            try {
                Thread.sleep(30);
                first.interrupt();
                second.interrupt();
                third.interrupt();
                first.join();
                second.join();
                third.join();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
            System.out.println("Поток " + first.getName() + " считал: " + one.getList());
            System.out.println("Поток " + second.getName() + " считал: " + two.getList());
            System.out.println("Поток " + third.getName() + " считал: " + three.getList());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Job implements Runnable {

    private BufferedReader br;
    private ArrayList<String> list = new ArrayList<>();

    public Job(BufferedReader br) {
        this.br = br;
    }

    public ArrayList<String> getList() {
        return list;
    }

    @Override
    public void run() {
        try {
            String str = br.readLine();
            while (str != null) {
                list.add(str);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    return;
                }
                str = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}