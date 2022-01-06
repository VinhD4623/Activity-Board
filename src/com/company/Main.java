/*
    Name:           Vinh Duong
    Assignment:     Project5
    Class:          CS202
    Date:           3/17/2021


    This program so far handles the ability to create postings of activities that someone might do during quarantine.
    The program supports two general types of activities Cooking and Gaming. There are three variations that
    of each general activities. The AVL tree handles the individual people or users and within there is a linear link
    list of activities for a person.

    Types of Activities:
    Cooking:    Baking, BBQ, Steam(Dumplings)
    Games:      Board games, Video games, Cards

    There are two data structures in this program:

    * Linear linked list of Activities
        Supports:   1.) Insert activity
                    2.) Removal of an activity
                    3.) Retrieve and display activity
                    4.) Display all activities
                    5.) Clear the activity list

    * Array of Linked list of Ingredients by food category
        Supports:   1.) Insert category into index
                    2.) Insert ingredients
                    3.) Display all categories
                    4.) Display all ingredients
                    5.) Remove ingredient
                    6.) Clear the list of ingredients
                    7.) Use prebuilt category array
                    8.) Build category array
                    9.) Copy (Not implemented for user but client can implement if they wish)

    * AVL Tree of Person type
                    1.) Insertion of a person and activities
                    2.) Insertion of new activities for a existing person
                    3.) Search and display a person and their postings
                    4.) Display all users and postings
                    5.) clear the posting board


    This is the main file of the program that interacts with the user and process the commands.
 */


package com.company;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Object Activity;
    public Scanner input;

    public static void main(String[] args) {
        int cmd = 0;
        TreeManager list;
        list = new TreeManager();

        do {
            cmd = 0;
            menu();
            cmd = readCmd();
            processCMD(list, cmd);
        } while(cmd != 6);


    }




    //Print the menu for user interaction
    public static void menu() {
        System.out.println("\n\n");
        System.out.println("""
                ::: Menu :::
                (1): Add new user and post activity.
                (2): Add new activity post to existing person.
                (3): Search user and display their post.
                (4): Display all post.
                (5): Clear all posting.
                (6): Exit.
                 """);

        //add: display a persons post
        //
    }




    //This processes the user's command
    //Takes in a list and a integer command
    public static void processCMD(TreeManager list, int cmd) {
        int count = 0;
        switch (cmd) {

            case 1: list.insertPerson();
                break;

            case 2: list.insertActivity();
                break;

            case 3: count = list.searchUser();
                    if(count == -1){
                        System.out.println("\nThe posting board is empty!");
                    }
                    else if(count == 0){
                        System.out.println("\nNo matching user!");
                    }
                break;

            case 4: count = list.displayInOrder();
                if(count == 0){
                    System.out.println("\nThe posting board is empty!");
                }
            case 5: list.clearTree();
                break;

            case 6: list.clearTree();
                System.out.println("\n\tHave a nice day!\n\n");
                break;

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


