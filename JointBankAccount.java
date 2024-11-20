package task2;

class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    // Method to withdraw money with synchronization
    public synchronized void withdraw(String user, int amount) {
        if (amount > balance) {
            System.out.println(user + " tried to withdraw " + amount + ", but insufficient funds.");
        } else {
            System.out.println(user + " is withdrawing " + amount);
            balance -= amount;
            System.out.println(user + " completed withdrawal. Remaining balance: " + balance);
        }
    }

    public int getBalance() {
        return balance;
    }
}

class User extends Thread {
    private BankAccount account;
    private String userName;
    private int amount;

    public User(BankAccount account, String userName, int amount) {
        this.account = account;
        this.userName = userName;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.withdraw(userName, amount);
    }
}

public class JointBankAccount {
    public static void main(String[] args) {
        // Initial balance of 50,000
        BankAccount account = new BankAccount(50000);

        // Create two users
        User userA = new User(account, "User A", 45000);  // User A wants to withdraw 45,000
        User userB = new User(account, "User B", 20000);  // User B wants to withdraw 20,000

        // Start threads
        userA.start();
        userB.start();
    }
}

