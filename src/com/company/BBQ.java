/*
    Name:           Vinh Duong
    Assignment:     Project5
    Class:          CS202
    Date:           3/17/2021

    This file contains the BBQ object that is derived from "Cooking".
    It has similar interface to its base class to support dynamic binding.
    It also calls methods from its parents to finish certain task.
 */
package com.company;
import java.util.Scanner;


//Derived from Cooking base class
public class BBQ extends Cooking{
    protected String grill_type;


    //Constructor
    public BBQ(){
        super();
        grill_type = null;
    }



    //Copy constructor
    public BBQ(final BBQ obj){
        super(obj);
        this.grill_type = obj.grill_type;
    }



    //Reads in data from the user and handles exceptions
    //Calls the parents read after it is done filling its own data
    public void read() {
        boolean success = true;
        do {
            try {
                input = new Scanner(System.in);
                System.out.print("Type of grill: ");
                grill_type= input.nextLine();
                success = true;
            }
            catch (Exception x) {
                System.out.println("Invalid Input!");
                success = false;
            }
        }while(!success);
        super.read();
    }



    //Displays the data of the current object
    //Then calls its direct base class to display the rest of the data
    public void display() {
        System.out.println("<<< BBQ >>>");
        System.out.println("Grill type: " + grill_type);
        super.display();
    }


    //These might not have been necessary to implement since they inherit its parents methods
    // They are just calling the parents methods that performs the task


    //Initializes an array of linked list
    public void createList() {
        super.createList();
    }



    //Adds in ingredients the array of linked list
    //This method only works if the array is already initialized
    public int addIngredients() {
        return super.addIngredients();
    }


    //Displays the ingredients in the list
    //Only displays the indices that contain a ingredient
    public void displayIngredients() {
        super.displayIngredients();
    }



    //Inserts a category into the array
    //Traverses through to the number passed in as an argument
    //Prompts the user at each index to insert category
    public int insertCategories(int num) {
        return super.insertCategories(num);
    }



    //Changes the name of a recipe to the passed in string
    public boolean change_name(String a_name) {
        return super.change_name(a_name);
    }



    //Compares the current object with to the passed in string
    public boolean compare(String a_name) {
        return super.compare(a_name);
    }



    //compares the current object to the passes in object and compares the names
    public boolean compare(Cooking obj) {
        return super.compare(obj);
    }
}
