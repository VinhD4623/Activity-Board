/*
    Name:           Vinh Duong
    Assignment:     Project5
    Class:          CS202
    Date:           3/17/2021

    This file contains the video game object that a user can create as a activity they do.
    It is one of three variation of "Games" object.

 */

package com.company;


import java.util.Scanner;

//Derived class from direct base class "Games"
public class Video_game extends Games {
    protected String device;
    protected String server;


    //Constructor
    public Video_game(){
        super();
        this.device = null;
        this.server = null;
    }


    //Copy constructor
    public Video_game(final Video_game obj) {
        super(obj);
        this.device = obj.device;
        this.server = obj.server;
    }


    //Reads in the data from the user
    public void read(){
        //input = new Scanner(System.in);
        boolean success = true;

        super.read();
        do{
            try {
                input = new Scanner(System.in);
                System.out.print("Type of gaming console: ");
                device = input.nextLine();
                System.out.print("Name of the server:");
                server = input.nextLine();
            }
            catch(Exception x){
                System.out.println("Invalid input!");
                success = false;
            }

        }while(!success);
    }


    //Displays the data
    public void display(){
        System.out.println("<<< Video Game >>>");
        super.display();        //Call parents display
        System.out.println("Gaming Console: " + device);
        System.out.println("Server: " + server);
    }



    //Changes the name of the game
    public boolean change_name(final String a_name){
        return super.change_name(a_name);       //calls the parents function
    }



    //Compares current video game name with passed in String
    public boolean compare(final String toCompare){
        return super.compare(toCompare);    //Call parents compare function
    }


    //Compares current video game name with passed in video game name
    public boolean compare(final Games obj){
        return super.compare(obj);      //Call parents compare function
    }


}
