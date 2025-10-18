package stepik.eskova.multithread.ExampleBankAccount;

public class Main {
    public static void main(String[] args) {
        BalanceJob balanceJob = new BalanceJob();
        Thread one = new Thread(balanceJob, "Саша");
        Thread two = new Thread(balanceJob, "Таня");
        two.start();
        one.start();

    }
}
