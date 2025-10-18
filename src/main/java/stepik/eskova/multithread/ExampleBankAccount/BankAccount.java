package stepik.eskova.multithread.ExampleBankAccount;

public class BankAccount {
    private int balance = 100;

    public int getBalance() {
        return balance;
    }

    public void withdraw(int amount) {
        balance = balance - amount;
    }
}

class BalanceJob implements Runnable {
    private BankAccount account = new BankAccount();

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (this) {
                makeWithdrawal(10);
            }
            if (account.getBalance() < 0) {
                System.out.println("Превышение лимита!");
            }
        }
    }

    private void makeWithdrawal(int amount) {
        if (account.getBalance() >= amount) {
            System.out.println(Thread.currentThread().getName() + " собирается снять деньги");
            System.out.println(Thread.currentThread().getName() + " идет подремать");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " просыпается");
            account.withdraw(amount);
            System.out.println(Thread.currentThread().getName() + " заканчивает транзакцию");
        } else {
            System.out.println("Для клиента " + Thread.currentThread().getName() + " заканчивает транзакцию");
        }
    }
}
