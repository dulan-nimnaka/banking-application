package model;

import java.io.Serializable;
import java.time.LocalDateTime; // Assuming Transaction is serializable
import java.time.format.DateTimeFormatter; // For transaction timestamps


// Simple serializable Transaction record used by accounts.
public class Transaction implements Serializable {
    private static final long serialVersionUID = 1L; // For serialization compatibility (prevents InvalidClassException if the class changes)

    private final String type; // Transaction type (e.g., "deposit", "withdrawal, "transfer")
    private final double amount; // Transaction amount
    private final String description; // Description of the transaction
    private final LocalDateTime timestamp; // Timestamp of the transaction

    // Constructor to initialize the transaction
    public Transaction(String type, double amount, String description ) {
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.timestamp = LocalDateTime.now(); // Set the current time as the transaction timestamp

    }

    // Getters for the transaction fields
    public String getType() {
        return type;
    }
    public double getAmount() {
        return amount;
    }
    public String getDescription() {
        return description;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    // Override toString() to provide a formatted string representation of the transaction
    @Override
    public String toString() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return String.format("[%s] %-10s: %10.2f - %s",
                timestamp.format(f), type, amount, description == null ? "" : description);
                // %s -> the formatted timestamp
                // %-10s -> the transaction type, left-aligned in a 10-character field
                // %10.2f -> the amount, right-aligned in a 10-character field with 2 decimal places
                // %s -> the description, if present, otherwise an empty string
    }
    
}
