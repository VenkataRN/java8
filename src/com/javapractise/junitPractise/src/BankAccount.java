package com.javapractise.junitPractise.src;

public class BankAccount {

    private String firstName;
    private String lastName;
    private double balance;
    private int typeOfAccount;

    public BankAccount(String firstName, String lastName, double balance, int typeofaccount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.typeOfAccount = typeofaccount;
    }

    //Branch-True means person depositing in Bank,
    //False means Person is depositing in ATM
    public double deposit(double amount, boolean branch){
        balance += amount;
        return balance;
    }

    //Branch-True means person wihtdraw in Bank,
    //False means Person wihtdraw depositing in ATM
    public double withdraw(double amount, boolean branch){
        //Dont allow more than 500 if it is ATM
        if (amount > 500  && !branch) throw new IllegalArgumentException("Max allowed amount in ATM is 500");

        if (amount > balance ) throw new IllegalArgumentException("Balance is less than the requested amount");

        balance -= amount;
        return balance;
    }

    public double getBalance(){
        return balance;
    }
    public static final int CHECKING = 1;
    public static final int SAVINGS = 2;

    public boolean isChecking(){
        return typeOfAccount == CHECKING;
    }
}
