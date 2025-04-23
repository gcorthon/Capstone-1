package org.example;

import java.util.Scanner;

//class syntax: access modifier/non-access modifier, type, Class name
public class Main {

    //we are about to create global variable
    //scanner is used to get input from the 'user' through console
    public static Scanner myScanner;

    //access mod: public
    //non access: static
    public static void main(String[] args) {

        //Datatypes

        //variable syntax: access modifier/ non-access modifier , reference type, variable name
        // = means something is being assigned
        String text  = "I am probably the most used datatype"; //String is a special datatype / It's
        //not a primitive dt  b/c it's a class but, it's also not a wrapper class because
        //it's not wrapping anything
        //String literal ("") is read as a String Object
        //Note: an object is an instance of a class.
        //And the class is the blueprint for an object

        //primitive dt: they are predefined by the language
        //and they store simple values directly in memory

        int num = 1234567890; // a number without a decimal
        float floaty = 1234567890.12345F; //a float is a floating point #; you must add 'F' at
        //the end of the number or the compiler with think it's a double.
        double dub = 123456789.123456789; //also used for decimals and is the most popular
        //dt for using decimals
        short shortNum = 12345;
        long longNum = 1231234567123456L;
        byte byteNum = 127;

        char charVar = 'c'; //a char must be written between single quotes and it can
        //only hold one char at a time
        boolean youLyingOrNah = false; // only holds true or false

        //Wrapper Classes: All primitive dt have Wrapper classes
        //Wrapper classes add functionality to our primitive dt

        Integer intWrapper = 12345678;
        //System.out.println(intWrapper.compareTo(num));

        Double doubleWrapper = 1234.5678;
        //System.out.println(doubleWrapper.compareTo(dub));

        Character charWrapper = 'A';
        //System.out.println(charWrapper.compareTo(charVar));

        Boolean booleanWrapper = true;
        //System.out.println(booleanWrapper.compareTo(youLyingOrNah));

        //Scanner Class - used to get info from or through the console
        myScanner = new Scanner(System.in);

        //When using scanner to get user input
        //we have to prompt the user
        System.out.println("Welcome to our Java Boot camp");
        System.out.println("What's your name??");

        String userName = myScanner.nextLine();
        //ifConditional(userName);
        //forLoopConditional();

        System.out.println("Hey " + userName + "!");
        System.out.println("What's your favorite color?");

        String color = myScanner.nextLine();
        System.out.println(switchConditional(color) + "looks nice on you!");

        System.out.println("End of main method");
    }

    //method syntax: access/nonaccess mod, returnType, methodName(params){//implementation logic
    //public static void ifConditional(String userName){

        //if/ if-else statement is probably the most popular logic statement
        //if  ( conditional statement is true) {
        //      logic to be executed if the condtion is true
        //      } else {
        //      logic to be executed if it's false
        //if(userName.length() > 6){
            //note that .length is a method; we know this
            //because of the () that hold params
            //it returns an int
        //    System.out.println("That's a pretty long name");
        //}else {
        //    System.out.println("Short and sweet!");
        //}
    //}

    static void forLoopConditional() {
        //we are creating a local variables
        //in java local variables exist within a method

        int counter = 5;
        //syntax of a for loop
        //for ( 'declare a pointer; set the condition; increment or decrement the pointer)
        // implementation logic

        for (int index = 0; index < 10; index++){
            System.out.println("Count down 'index': " + index);
            //System.out.println("Counter value: " + counter);
        }
    }

    static String switchConditional(String favColor){

        //We use switch statements if we have 3 or more cases
        switch(favColor.toLowerCase()){
            case "red":
                System.out.println("Ruby Red");
                return "Ruby Red";

            case "blue":
                System.out.println("Baby Blue");
                return "Baby Blue";

            case "green":
                System.out.println("Money Green");
                return "Money Green";

            default:
                //the default case is run if the input given does not match any of the case
                System.out.println("Ooo...that's a nice color");
                return favColor;

        }
        //return "";
    }
}