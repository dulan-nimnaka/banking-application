package model;

import java.io.Serializable;    // For object serialization capability
import java.util.ArrayList;
import java.util.List;


import exceptions.InsufficientFundsException; // Custom exception for insufficient funds


public class BankAccount {
    private int accountNumber;
    private String accountHolderName;
    private double balance;
    private List<Transaction> transactions;


    // Constructor
    public BankAccount(int accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance; // When the bank opens a new account, they initialize the vault with some money
        this.transactions = new ArrayList<>();  // Initialize empty transaction list
    }

    // ENCAPSULATION: GETTERS AND SETTERS

    // Returns account number (read-only, no setter for security)
    public int getAccountNumber() {
        return accountNumber;
    }

    // Returns account holder's name
    public String getAccountHolderName() {
        return accountHolderName;
    }

    // Returns current balance
    public double getBalance() {
        return balance;
    }

    // Protected setter for balance (only subclasses can modify balance directly)
    protected void setBalance(double balance) {
        this.balance = balance;
    }

    // Returns list of transactions (returns reference to actual list)
    List<Transaction> geTransactions() {
        return transactions;
    }

    // Abstract method - must be implemented by concrete subclasses
    // Throws custom exception for insufficient funds
    public abstract void deposit(double amount) throws InsufficientFundsException;

    // Abstract method - must be implemented by concrete subclasses
    // concrete method for the deposit
    public void deposit(double amount) {
        //  Validate deposit amount
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;

        }

        // Update balance
        balance += amount;

        // Record transaction
        // will be implemented 



        
    }










}
