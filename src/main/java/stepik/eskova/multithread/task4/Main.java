package stepik.eskova.multithread.task4;

/**
 * Работают два потока. Первый (производитель) каждую секунду создает сообщение, которое содержит текущее время.
 * Второй (потребитель) более ленивый: он читает эти сообщения каждые две секунды и выводит их на консоль.
 * Максимальная длина очереди  - 5 сообщений. Если очередь заполнена, то производитель ожидает освобождения места.
 * Если в очереди пусто, то потребитель ожидает появления сообщения.
 * После запуска потоков в методе main() нужно выждать 30 секунд и вывести сообщение об окончании работы,
 * а также распечатать оставшиеся в очереди сообщения.
 **/


import java.time.LocalTime;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        TimeDealer timeDealer = new TimeDealer();

        InTime it = new InTime(timeDealer);
        OutTime ot = new OutTime(timeDealer);

        Thread first = new Thread(it);
        Thread second = new Thread(ot);

        first.start();
        second.start();

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        first.interrupt();
        second.interrupt();
        try {
            first.join();
            second.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("The work is finished");
        System.out.println("The queue:");
        System.out.println(timeDealer.getTimeQueue());
    }


}

class TimeDealer {
    private Queue<LocalTime> timeQueue = new ArrayDeque<>();

    public Queue<LocalTime> getTimeQueue() {
        return timeQueue;
    }

    public synchronized void putTimeNow() {
        while (timeQueue.size() == 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        timeQueue.add(LocalTime.now());
        notify();
    }

    public synchronized void pollTime() {
        while (timeQueue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        System.out.println(timeQueue.poll());
        notify();


    }
}

class InTime implements Runnable {
    TimeDealer timeDealer;
    private volatile boolean running = true;

    public InTime(TimeDealer timeDealer) {
        this.timeDealer = timeDealer;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            timeDealer.putTimeNow();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}

class OutTime implements Runnable {
    TimeDealer timeDealer;
    private volatile boolean running = true;

    public OutTime(TimeDealer timeDealer) {
        this.timeDealer = timeDealer;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            timeDealer.pollTime();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}