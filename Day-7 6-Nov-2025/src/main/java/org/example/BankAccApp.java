package org.example;

class BankAccountApp {
    static int totalAccounts = 0;
    private double balance;

    BankAccountApp(double balance) {
        this.balance = balance;
        totalAccounts++;
    }

    void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount!");
        } else {
            balance += amount;
            System.out.println("Deposited: " + amount);
        }
    }

    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdraw amount!");
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        }
    }

    double getBalance() {
        return balance;
    }
}

public class BankAccApp {
    public static void main(String[] args) {
        BankAccountApp acc1 = new BankAccountApp(1000);
        acc1.deposit(500);
        acc1.withdraw(200);
        System.out.println("Balance: " + acc1.getBalance());
        System.out.println("Total Accounts: " + BankAccountApp.totalAccounts);
    }
}

