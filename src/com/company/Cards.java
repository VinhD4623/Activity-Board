/*
    Name:           Vinh Duong
    Assignment:     Project5
    Class:          CS202
    Date:           3/17/2021

    This file contains one of the variation of a "Game".
    Card games are supported in this files the difference in this is that
    it keeps track of how many cards are needed for a specific game to be played.
 */
package com.company;
import java.util.InputMismatchException;
import java.util.Scanner;


//Derived from "Games"
public class Cards extends Games {
    protected int num_cards;
    protected Scanner input = null;


    //Constructor
    public Cards(){
        super();
        this.num_cards = 0;
    }



    //Copy constructor
    public Cards(final Cards obj){
        super(obj);
        this.num_cards = obj.num_cards;
    }


    //Reads in the data from the user
    public void read() {
        input = new Scanner(System.in);
        boolean success = true;

        super.read();               //Call parents read function
        do {
            try {
                System.out.print("Number of cards for this game: ");
                num_cards = input.nextInt();
            }
            catch (InputMismatchException x){
                System.out.println("Invalid input! Need to enter a number.");
                success = false;
            }
            catch (Exception y) {
                System.out.println("Invalid input!");
                success = false;
            }
        }while(!success);
    }


    //Displays the data
    public void display(){
        System.out.println("<<< Cards >>>");
        super.display();
        System.out.println("Number of cards for the game: " + num_cards);
    }


    //Compares the name of the game with the passed in String
    public boolean compare(final String toCompare){
        return super.compare(toCompare);
    }

    //Compares the name of the current Game object with the passed in object
    public boolean compare(Games obj) {
        return super.compare(obj);
    }
}
