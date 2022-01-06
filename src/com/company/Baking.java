/*
    Name:           Vinh Duong
    Assignment:     Project5
    Class:          CS202
    Date:           3/17/2021

    This file contains the Baking object that is derived from its direct base class "Cooking".
    The only difference between this class and its parent is that it has a "style" member
    that describes what type of baking the user might be doing.

 */
package com.company;

import java.util.Scanner;

public class Baking extends Cooking {
    protected String style;



    //Constructor
    public Baking() {
        super();
        this.style = null;
    }


    //Copy constructor
    public Baking(final Baking obj) {
        super(obj);
        this.style = obj.style;
    }



    //Reads in data from the user
    //First reads in its own data then calls the parent to read in more info
    public void read() {
        boolean success = true;
        do {
            try {
                input = new Scanner(System.in);
                System.out.print("Type of baking: ");
                this.style = input.nextLine();
            }
            catch(Exception x){
                System.out.println("Input error!");
                success = false;
            }
        }while(!success);
        super.read();       //Jump start parents read function
    }


    //Displays the data of this object
    //Then calls the parents display to display the rest of the data
    public void display() {
        System.out.println("Type of baking: " + style);
        super.display();
    }


    //These might not have been necessary to implement since they inherit its parents methods
    // They are just calling the parents methods that performs the task


    //Creates a array of categories
    public void createList() {
        super.createList();
    }



    //Adds in ingredients to a array of food categories and inserts into ingredient linked list
    //This method only works if there is an initialized array of size user chooses
    public int addIngredients() {
        return super.addIngredients();
    }



    //Traverses through the array of categories and if there are ingredients then displays
    public void displayIngredients() {
        super.displayIngredients();
    }



    //Inserts the name of the categories into the array
    //takes in an integer to increment through the array and prompts user to add categories
    public int insertCategories(int num) {
        return super.insertCategories(num);
    }



    //Method to allow user to change the name of the recipe
    public boolean change_name(String a_name) {
        return super.change_name(a_name);
    }


    //compares the current baking object to a string passed in
    public boolean compare(String a_name) {
        return super.compare(a_name);
    }


    //Compares the current baking object ot another baking object and compares the names
    public boolean compare(Cooking obj) {
        return super.compare(obj);
    }
}
