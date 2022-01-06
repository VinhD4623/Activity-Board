/*
    Name:           Vinh Duong
    Assignment:     Project5
    Class:          CS202
    Date:           3/17/2021


    This file contains the Games object derived object form the super base class "Activity"
    The game object is also the base class to three variations of games.
 */

package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

//import java.util.Locale;


//Derived from the super base class "Activity"
public class Games extends Activity{

    //Data members
    protected String [] rules;
    protected int players;
    protected float cost;
    protected static Scanner input = null;



    //Constructor
    public Games(){
        super();     //Jump starts the parents constructor
        name = null;
        rules = null;
        players = 0;
        cost = 0;
    }



    //Copy constructor
    public Games(final Games obj){
        super.name = obj.name;
        this.rules = obj.rules;
        this.players = obj.players;
        this.cost = obj.cost;
    }




    //Reads in the data from the user
    public void read(){
       boolean success = true;  //validate user input
        do {
           try {
               input = new Scanner(System.in);
               System.out.print("Name of game: ");
               name = input.nextLine();

               System.out.print("Number of players that can play: ");
               players = input.nextInt();

               System.out.print("Cost of the game: $");
               cost = input.nextFloat();
               success = true;
           }
           catch (InputMismatchException x){
               System.out.println("Invalid input! Need to enter a number.");
               success = false;
           }
           catch (Exception y) {        //Catch any types of errors
               System.out.println("Invalid input");
               success = false;
           }
       }while(!success);        //Loop if invalid input
    }




    //Displays the contents obj
    public void display() {
        System.out.println(":::Game:::");
        System.out.println("Name of game: " + name);
        System.out.println("Number of players: " + players);
        System.out.println("Cost: " + cost);
    }




    //Changes the name of the activity
    public boolean change_name(final String a_name) {
        if(super.name.equals(a_name))
            return false;
        super.name = a_name;
        return true;
    }




    //Compares a activity with by the names
    public boolean compare(final String a_name) {
        return (super.name.equals(a_name));
    }



    //Compares a game object with the current object
    public boolean compare(final Games obj) {
        return (super.name.equals(obj.name));
    }



}
