/*
    Name:           Vinh Duong
    Assignment:     Project5
    Class:          CS202
    Date:           3/17/2021

    This file contains a variation of "Cooking". It handles the object for
    steaming dumplings.
 */

package com.company;
import java.util.Scanner;


//Derived from Cooking
public class Steam extends Cooking {
    //Data members
    protected String dumpling;



    //Constructor
    public Steam(){
        super();
        this.dumpling = null;
    }

    //Copy constructor
    public Steam(final Steam obj){
        super(obj);
        this.dumpling = obj.dumpling;
    }


    //Reads in the data from the user
    public void read() {
        boolean success = true;
        do {
            try {
                System.out.print("Type of dumpling: ");
                input = new Scanner(System.in);
                dumpling = input.nextLine();
            }
            catch (Exception x) {
                System.out.println("Invalid Input!");

                success = false;
            }
        }while(!success);
        super.read();
    }



    //Displays the data to the user
    public void display() {
        System.out.println("<<< Steam Dumplings >>>" + "\nDumpling type: " + dumpling);
        super.display();
    }



    //creates/ initializes a list of ingredients
    public void createList() {
        super.createList();
    }



    //Adds in ingredients
    public int addIngredients() {
        return super.addIngredients();
    }



    //Displays ingredients to the user
    public void displayIngredients() {
        super.displayIngredients();
    }



    //Inserts categories to the list to be initialized
    public int insertCategories(int num) {
        return super.insertCategories(num);
    }


    //Changes the name the recipe
    public boolean change_name(String a_name) {
        return super.change_name(a_name);
    }



    //compares the name of the recipe
    public boolean compare(String a_name) {
        return super.compare(a_name);
    }



    //Compares the current object with the passed in the object
    public boolean compare(Cooking obj) {
        return super.compare(obj);
    }
}
