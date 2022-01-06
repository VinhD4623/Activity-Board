/*
    Name:           Vinh Duong
    Assignment:     Project5
    Class:          CS202
    Date:           3/17/2021

    This file contains the class Board_game that is derived from its direct base class "Games"
    The Board_game object has a similar interface of its parent.
 */
package com.company;



/*  Derived variation of Cooking
    This object calls the Base class methods
    Since the base class contains everything it needs
 */
public class Board_game extends Games {


    //Constructor
    public Board_game() {
        super();
    }



    //Copy constructor
    public Board_game(Board_game obj) {
        super(obj);
    }



    //Reads in data from the user
    public void read() {
        super.read();
    }



    //Displays the data
    public void display(){
        System.out.println("<<< Board Game >>>");
        super.display();
    }



    //Compares the current board game object name to a String
    public boolean compare(final String toCompare){
        return super.compare(toCompare);
    }



    //Compares the current board game object to a passed in object
    public boolean compare(final Games obj){
        return super.compare(obj);
    }

}
