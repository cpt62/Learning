package stepik.eskova.multithread.task3;

import java.io.*;
import java.util.ArrayList;

/**
 * Для задачи чтения слов из файла устройте так, чтобы два потока читали из файла по-очереди. Считать нужно весь файл. Пример результата:
 * <p>
 * Первый поток считал: [mama, ramy, debug, korpus, krug, lola, mix, pupa, port]
 * Второй поток считал: [myla, poisk, myxa, proga, babay, kluch, mumu, lux]
 * <p>
 * Подсказка: для синхронизации создайте отдельный класс, который будет синхронизировать доступ к файлу.
 * Два потока (каждый со своим списком слов) обращаются к синхронизированному методу этого класса для чтения из файла.
 **/

public class Main {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("./src/main/java/stepik/eskova/multithread/task3/test100.txt"))) {
            Controller controller = new Controller(bufferedReader);
            Job one = new Job(controller);
            Job two = new Job(controller);
            Thread first = new Thread(one, "first");
            Thread second = new Thread(two, "second");
            first.start();
            second.start();
            first.join();
            second.join();
            System.out.println("Первый поток считал: " + one.getList());
            System.out.println("Второй поток считал: " + two.getList());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Controller {
    private BufferedReader br;
    private volatile String status = "first";

    public Controller(BufferedReader br) {
        this.br = br;
    }

    public synchronized String readWord(String name) {
        String result = null;
        while (!name.equals(status)) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        try {
            result = br.readLine();
            status = status.equals("first") ? "second" : "first";
        } catch (IOException e) {
            e.printStackTrace();
        }
        notify();
        return result;
    }

}

class Job implements Runnable {
    private ArrayList<String> list = new ArrayList<>();
    private Controller controller;

    public Job(Controller controller) {
        this.controller = controller;
    }

    public ArrayList<String> getList() {
        return list;
    }

    @Override
    public void run() {
        String str = controller.readWord(Thread.currentThread().getName());
        while (str != null) {
            list.add(str);
            str = controller.readWord(Thread.currentThread().getName());
        }
    }
}
