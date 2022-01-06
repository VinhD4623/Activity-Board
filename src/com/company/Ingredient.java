/*
    Name:           Vinh Duong
    Assignment:     Project5
    Class:          CS202
    Date:           3/17/2021

    This file contains the object of ingredient type
    It holds information for a specific ingredient that user will add into
    the array of linear linked list.

 */
package com.company;
import java.util.InputMismatchException;
import java.util.Scanner;


//Class for single ingredient
public class Ingredient {
    protected String name;
    protected float amount;
    protected String measurement;
    Scanner input;



    //constructor
    public Ingredient(){
        this.name = null;
        this.amount = 0;
        this.measurement = null;
    }



    //Copy constructor
    public Ingredient(final Ingredient obj){
        this.name = obj.name;
        this.amount = obj.amount;
        this.measurement = obj.measurement;
    }



    //Read in data from the user
    //Asks the user for the name the measurement type and how much in that measurement
    public void read(){
        boolean success = true;
        do {
            try {
                input = new Scanner(System.in);
                System.out.print("\n\nName of Ingredient: ");
                name = input.nextLine();

                System.out.println("Enter a measurement for amount (whole, lbs, grams, cups, oz, etc..)");
                System.out.print("Type of measurement: ");
                measurement = input.nextLine();

                System.out.print("\nAmount of ingredient: ");
                amount = input.nextFloat();
            }
            catch(InputMismatchException x){
                System.out.println("\n\nInvalid Input! Enter a number for amount please.");
                success = false;
            }
            catch(Exception y){
                System.out.println("\n\nInvalid Input!");
                success = false;
            }
        }while(!success);
    }




    //Displays the contents of the ingredient to use
    public void display(){
        System.out.println("<<< Baking >>>");
        System.out.println("Ingredient: " + name);
        System.out.println("Amount: " + amount + "\t" + measurement);
    }



    //compares the ingredient name to the passes in string
    public boolean compare(final String toCompare){
        return (this.name.equals(toCompare));
    }



    //Changes the amount the of the ingredient
    public boolean changeAmount(){
        float temp = 0;
        System.out.println("Change amount to: ");
        temp = input.nextFloat();

        if(this.amount == temp)
            return false;
        else
            this.amount = temp;
        return true;
    }


    //Changes the name of the ingredient
    public boolean changeName(){
        String temp;
        System.out.println("Change name of ingredient to: ");
        temp = input.nextLine();

        if(this.name == temp)
            return false;
        else
            this.name = temp;
        return true;
    }

}
