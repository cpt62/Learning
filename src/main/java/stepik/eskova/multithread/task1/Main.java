package stepik.eskova.multithread.task1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("./src/main/java/stepik/eskova/multithread/task1/test100.txt"));
            Job one = new Job(br);
            Job two = new Job(br);
            Job three = new Job(br);
            Thread thread1 = new Thread(one, "first");
            Thread thread2 = new Thread(two, "second");
            Thread thread3 = new Thread(three, "third");
            thread1.start();
            thread2.start();
            thread3.start();

            try {
                thread1.join();
                thread2.join();
                thread3.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(thread1.getName() + " считал : " + one.getList());
            System.out.println(thread2.getName() + " считал : " + two.getList());
            System.out.println(thread3.getName() + " считал : " + three.getList());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
                    e.printStackTrace();
                }
                str = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}