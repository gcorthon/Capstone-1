package org.example.views;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class HomeView {
    Scanner homeScanner = new Scanner(System.in);



    public HomeView() {
    }

    //methods
    //add deposit method
    public void addDeposit(){
        //All Transactions have the same set up
        //date|time|description|vendor|amount
        //The best way to go about formatting this "transaction"
        //is using a Stringbuilder class

        StringBuilder receiptGenerator = new StringBuilder();
        //get today's date
        LocalDate date = LocalDate.now();
        //System.out.println(date);
        //the user view
        System.out.println("Today's Date: "  + date.getMonth() + " " + date.getDayOfMonth() + ", " + date.getYear());

        //current time
        LocalTime time = LocalTime.now();
        time = time.truncatedTo(ChronoUnit.SECONDS);
        System.out.println("Current time: " + time);

        System.out.println("Transaction description: ");
        String description = homeScanner.nextLine();

        System.out.println("Vendor Name: ");
        String vendor = homeScanner.nextLine();

        System.out.println("Deposit Amount: ");
        String amount = homeScanner.nextLine();

        receiptGenerator.append(date);
        receiptGenerator.append("|");
        receiptGenerator.append(time);
        receiptGenerator.append("|");
        receiptGenerator.append(description);
        receiptGenerator.append("|");
        receiptGenerator.append(vendor);
        receiptGenerator.append("|");
        receiptGenerator.append(amount);

        //get the string we've built out of the String builder
        String receipt = receiptGenerator.toString();

        if(saveTransaction(receipt)) {

            System.out.println("Excellent!! Below you'll find your transaction details");
            System.out.println(".");
            System.out.println(".");
            System.out.println(receipt);
        } else {
            System.out.println("unable to complete transaction");
            System.out.println("Please try again later");
            System.out.println("Returning to Home Screen");
        }

        //right now we're printing out the receipt but what we need to do is
        //persist the information - aka save it to a file called transactions.csv

    } // end of deposit method

    public void makePayment(){
        LocalDate date = LocalDate.now();
        //System.out.println(date);
        //the user view
        System.out.println("Today's Date: "  + date.getMonth() + " " + date.getDayOfMonth() + ", " + date.getYear());

        //current time
        LocalTime time = LocalTime.now();
        time = time.truncatedTo(ChronoUnit.SECONDS);
        System.out.println("Current time: " + time);

        System.out.println("Transaction description: ");
        String description = homeScanner.nextLine();

        System.out.println("Vendor Name: ");
        String vendor = homeScanner.nextLine();

        System.out.println("Payment Amount: ");
        String amount = "-" + homeScanner.nextLine();

        String receipt = String.format("%s|%s|%s|%s|%s", date, time, description, vendor, amount);
        System.out.println(receipt);

        if(saveTransaction(receipt)) {

            System.out.println("Excellent!! Below you'll find your transaction details");
            System.out.println(".");
            System.out.println(".");
            System.out.println(receipt);
        } else {
            System.out.println("unable to complete transaction");
            System.out.println("Please try again later");
            System.out.println("Returning to Home Screen");
        }
    }

    //create a 'save transaction' method
    public boolean  saveTransaction(String transaction){
        String fileName = "transactions.csv";
        //try{//some logic we want to try and execute} catch {exception that can be thrown}

        try(FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter bw = new BufferedWriter(fileWriter)){
            //here we are adding the logic that we actually want to try
            //we want to 'write' to the transactions.csv file
            bw.write(transaction);
            bw.newLine();
            return true;
        }catch (IOException ioException){
            System.out.println(ioException.getLocalizedMessage());
            return false;
        }
    }

}
