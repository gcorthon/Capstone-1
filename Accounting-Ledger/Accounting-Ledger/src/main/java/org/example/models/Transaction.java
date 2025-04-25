package org.example.models;

//4 pillars of OOP(Object oriented programming)
//inheritance - inherit from a parent class or another class
//Polymorphism - Many forms // method overloading or method overriding
//Encapsulation - Protecting data
//Abstraction - Hiding data

import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {
    //date|time|description|vendor|amount

    //Encapsulation
    private LocalDate date;
    private LocalTime time;
    private String description;
    private String vendor;
    private double amount;

    //constructors
    //default constructor
    public Transaction() {
    }

    public Transaction(LocalDate date, LocalTime time, String description, String vendor, double amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    //methods - getters and setters


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString(){
        StringBuilder classStringGenerator = new StringBuilder();
        classStringGenerator.append(date);
        classStringGenerator.append("|");
        classStringGenerator.append(time);
        classStringGenerator.append("|");
        classStringGenerator.append(description);
        classStringGenerator.append("|");
        classStringGenerator.append(vendor);
        classStringGenerator.append("|");
        classStringGenerator.append(amount);

        return classStringGenerator.toString();
    }
}
