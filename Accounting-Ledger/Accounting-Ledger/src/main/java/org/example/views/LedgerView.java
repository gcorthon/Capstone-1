package org.example.views;

import org.example.models.Transaction;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class LedgerView {
    Scanner ledgerScanner = new Scanner(System.in);

    ArrayList<Transaction> transactionArrayList = new ArrayList<>();

    //ledgerMenu
    public void ledgerMenu(){
        System.out.println("++++++++++++++++");
        System.out.println("Ledger Menu");
        System.out.println("++++++++++++++++");
        System.out.println(" ");

        System.out.println("Please select from the following options");
        System.out.println("A: All- Display all entries");
        System.out.println("D: Deposits - Displaying deposits");
        System.out.println("P: Payments - Display payments");
        System.out.println("R: Reports");
        System.out.println("E: Exit to Home Menu");

        String selection = ledgerScanner.nextLine();

        switch(selection.toUpperCase()){
            case "A":
                //System.out.println("All transactions");
                System.out.println("-------------------------------------");
                System.out.println(" ");
                System.out.println("View your transaction history below");
                for(Transaction transaction: getallTransactions()){
                    System.out.println(transaction);
                }
                ledgerMenu();
                break;
            case "D":
                System.out.println("All deposits");
                break;
            case "P":
                System.out.println("All payments");
                break;
            case "R":
                System.out.println("Navigate to new menu");
                break;
            case "E":
                System.out.println("Exiting back to home screen");
                break;
            default:
                System.out.println("Error: Please re-type your selection");
                break;
        }
    }

    //retrieve all transactions from the transactions.csv file
    public ArrayList<Transaction> getallTransactions(){
        ArrayList<Transaction> allTransactionsFromCSVFile = new ArrayList<>();

        String fileName = "transactions.csv";

        try(FileReader fileReader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fileReader)){
            //System.out.println("In File reader method");
            String line;
            while((line = br.readLine()) != null){
                //we're printing out each line or row from the csv file
                //System.out.println(line);
                Transaction transaction = new Transaction();

                //split this string!!!
                String[] transactionArr = line.split("\\|");

                //print out each attribute
                //enhanced for-loops
                //for(String item: transactionArr){
                //    System.out.println(item);
                //}

                //we can assign the proper item to the corresponding field
                LocalDate date = LocalDate.parse(transactionArr[0]); //date
                transaction.setDate(date);
                LocalTime time = LocalTime.parse(transactionArr[1]); //time
                transaction.setTime(time);
                String description = transactionArr[2];
                transaction.setDescription(description);
                String vendor = transactionArr[3];
                transaction.setVendor(vendor);
                double amount = Double.parseDouble(transactionArr[4]);
                transaction.setAmount(amount);

                Transaction trans2 = new Transaction(date, time, description, vendor, amount);
                allTransactionsFromCSVFile.add(transaction);

                //Create a transaction object from the line we retrieve

            }
        }catch (IOException ioException){
            ioException.getLocalizedMessage();
        }

        return allTransactionsFromCSVFile;
    }
}
