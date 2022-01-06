/*
    Name:           Vinh Duong
    Assignment:     Project5
    Class:          CS202
    Date:           3/17/2021

    This file contains a Person object. In each person object it contains a activity manager to manage a linear linked
    list of activities that they may have. I is based on a menu system once we are in the scope of this class, you
    are able to do execute more commands from the main menu.
    supports:   (1): Add an activity to the list.
                (2): Display all activities.
                (3): Search activity.
                (4): Remove an activity.
                (5): Clear activity list.
 */

package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Person {
    //Data members
    protected Scanner input = null;
    protected String name;
    protected ActivityManager list;


    //Constructor
    public Person(){
        input = new Scanner(System.in);
        this.name = null;
        this.list = null;
    }


    //Reads in the data for the person
    public void read(){
       // input = new Scanner(System.in);
        System.out.print("Input name: ");
        this.name = input.nextLine();

        list = new ActivityManager();
        int cmd= 0;
        do {
            cmd = 0;
            menu();
            cmd = readCmd();
            processCMD(list, cmd);
        } while (cmd != 6);

    }



    //Displays the person's name
    public void display(){
        System.out.print("Name: " + name);
        list.display();
    }



    //Compares the current object to the passed in object
    public int compare(final Person toCompare){

        return name.compareTo(toCompare.name);
    }





    //Print the menu for user interaction
    public static void menu() {
        System.out.println("\n\n");
        System.out.println("""
                ::: Activity Menu :::
                (1): Add an activity to the list.
                (2): Display all activities.
                (3): Search activity.
                (4): Remove an activity.
                (5): Clear activity list.
                (6): Exit.
                 """);
    }




    //This processes the user's command
    //Takes in a list and a integer command
    public static void processCMD(ActivityManager list, int cmd) {
        int count = 0;
        switch (cmd) {

            case 1: list.addActivity();
                break;

            case 2: count = list.display();
                System.out.println("\nNumber of activities: " + count);
                break;

            case 3: list.searchDisplay();
                break;

            case 4: list.removeActivity();
                break;

            case 5: list.removeAll();
                break;

            case 6:
                System.out.println("\n\nExiting activity manager....\n\n");break;

            default:
                break;
        }
    }



    //Reads in the user's command and returns the integer chosen
    public static int readCmd() {
        int cmd = 0;
        boolean success = true;
        do {
            try {
                Scanner input = new Scanner(System.in);
                System.out.print("Selection: ");
                cmd = input.nextInt();
                success = true;
            }
            catch (InputMismatchException x) {
                System.out.println("Invalid Input! Enter a number.");
                success = false;
            }
        }while (!success);
        return cmd;
    }




}
