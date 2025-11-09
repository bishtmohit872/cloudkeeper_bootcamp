package org.example;

public class BankAccount {
    int AccountNumber;
    float Balance;
    String HolderName;

    BankAccount(int AccountNumber,String HolderName, int Balance){
        this.AccountNumber = AccountNumber;
        this.HolderName = HolderName;
        this.Balance = Balance;
    }


    public void getdata(){
        System.out.println("Current balance is :"+this.Balance);
        System.out.println("holder name is :"+this.Balance);
        System.out.println("current balance is :"+this.Balance);
    }


}