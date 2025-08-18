package model;

import exceptions.InsufficientFundsException; // Custom exception for insufficient funds

// Subclass demonstrating inheritance and method overriding
public class CheckingAccount  extends BankAccount{
    private double overdraftLimit; // ovardraft limit for the checking account

    // Constructor
    // Initializes the checking account with an account number, holder name, initial balance, and overddraft limit
    public CheckingAccount(int accountNumber, String accountHolderName, double initialBalance, double overdraftLimit) {
        super(accountNumber, accountHolderName, initialBalance); // Call parent constructor
        this.overdraftLimit = overdraftLimit; // Set overdraft limit
    }

    // Getter for overdraft limit
    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > getBalance() + overdraftLimit) {
            throw new InsufficientFundsException("Withdrawal exceeds checking account balance + overdraft limit.");

        }

        setBalance(getBalance() - amount); // Deduct amount from balance
        // Add transaction
        addTransaction("Withdraw", amount, "Withdrawal from checking account");
    }
    
}
