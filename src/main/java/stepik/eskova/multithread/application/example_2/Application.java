package stepik.eskova.multithread.application.example_2;

public class Application implements Runnable {
    private class Resourse{}
    private Resourse scissors = new Resourse();
    private Resourse paper = new Resourse();

    @Override
    public void run() {
        doSun();
        doCloud();
    }

    public void doSun() {
        synchronized (scissors) {
            System.out.println(Thread.currentThread().getName() + " взяла ножницы");
            synchronized (paper) {
                System.out.println(Thread.currentThread().getName() + " взяла бумагу");
                System.out.println(Thread.currentThread().getName() + " вырезает солнышко");
            }
        }
    }

    public void doCloud() {
        synchronized (paper) {
            System.out.println(Thread.currentThread().getName() + " взяла бумагу");
            synchronized (scissors) {
                System.out.println(Thread.currentThread().getName() + " взяла ножницы");
                System.out.println(Thread.currentThread().getName() + " вырезает облако");
            }
        }
    }

    public static void main(String[] args) {
        Application app = new Application();
        Thread one = new Thread(app, "Маша");
        Thread two = new Thread(app, "Даша");
        one.start();
        try {
            one.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        two.start();
        try {
            two.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
