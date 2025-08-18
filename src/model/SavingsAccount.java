package model;

import exceptions.InsufficientFundsException;

public class SavingsAccount extends BankAccount {
    private double interestRate; // Interest rate for the savings account e.g., 0.05 = 5%

    // Constructor
    public SavingsAccount(int accountNumber, String accountHolderName, double initialBalance, double interestRate) {
        super(accountNumber, accountHolderName, initialBalance); // Call parent constructor
        this.interestRate = interestRate; // Set interest rate
 
    }

    // Getter for interest rate
    public double getInterestRate() {
        return interestRate;
    }

    // 
    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if(amount > getBalance()) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal in Savings Account.");

        }
        setBalance(getBalance() - amount); // Deduct amount from balance
        // Add transaction
        addTransaction("Withdraw", amount, "Withdrawal from savings account");


    }

    // Additional method for applying interest
    public void applyInterest() {
        double interest = getBalance() * interestRate; // Calculate interest
        deposit(interest); // Deposit interest into the account
        // Add transaction for interest application
        addTransaction("Interest", interest, "Interest appplied to savings account");
    }


}
