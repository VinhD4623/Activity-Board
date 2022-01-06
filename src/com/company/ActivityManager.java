/*
    Name:           Vinh Duong
    Assignment:     Project5
    Class:          CS202
    Date:           3/17/2021

    This file manages a linear linked list of activities.
    It contains a activity node that has an activity reference
    which uses dynamic casting to create the activity type the user chooses.

    Supported Functionality:
                            1.) Add/create activity to insert into a list
                            2.) Display all activities in the list
                            3.) Search and display a specific activity by name of either game or cooking recipe
                            4.) Delete a specific activity by name of either game or cooking recipe
                            5.) Clear the list of activities
 */

package com.company;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ActivityManager {
    //Data members
    protected Scanner input = null;
    protected ActivityNode head;
    int count;


    //Constructor
    public ActivityManager(){
        this.count = 0;
        this.head = null;
    }



    //Copy constructor
    public ActivityManager(final ActivityManager toCopy){
        this.count = toCopy.count;
        //Copy the LLL of activities
        this.head = new ActivityNode();

    }



    //Prompts the user to decide which type of game they would like to create and insert
    public int addActivity() {
        int choice = 0;
        ActivityNode temp = new ActivityNode();
        do {
            try {
                choice = 0;
                System.out.print("""
                        What type of activity would you like to create?
                                            
                        (1): General Cooking    
                        (2): Baking
                        (3): BBQ
                        (4): Steam dumplings
                         
                        (5): General Gaming
                        (6): Board game
                        (7): Video Game
                        (8): Cards
                         """);
                System.out.print("\nSelection: ");
                input = new Scanner(System.in);
                choice = input.nextInt();

                //Depending on the user choice create new sub-activity
                switch (choice) {
                    case 1 -> temp.object = new Cooking();      //General cooking
                    case 2 -> temp.object = new Baking();
                    case 3 -> temp.object = new BBQ();
                    case 4 -> temp.object = new Steam();
                    case 5 -> temp.object = new Games();        //General game
                    case 6 -> temp.object = new Board_game();
                    case 7 -> temp.object = new Video_game();
                    case 8 -> temp.object = new Cards();
                    default -> System.out.println("\n\nInvalid Selection! Please try again...\n\n");
                }
            }
            catch(InputMismatchException x){
                System.out.println("\n\nInput Error! Need to enter a number.\n\n");
            }
            catch (Exception y){
                System.out.println("\n\nError!");
            }
        }while(choice < 1 || choice > 8);


        //Read in the info before inserting
        temp.object.read();
        //If head is null we can just insert at the head
        if(this.head == null)
        {
           this.head = new ActivityNode(temp);
            this.head.setNext(null);
        }
        else    //Or we can traverse to the end of the list
            insert(this.head, temp);

        return choice;
    }


    //Inserts a node at the end of the list
    protected ActivityNode insert(ActivityNode head, ActivityNode obj){
        if(head == null){
            head = new ActivityNode(obj);
            head.setNext(null);
            return head;
        }

        head.next = insert(head.getNext(), obj);
        return head;
    }


    //Wrapper to displays all the activities
    public int display(){
        return display(this.head);
    }


    //Recursively traverse to display all activities
    protected int display(ActivityNode head){
        if(head == null)
            return 0;
        System.out.println();
        head.display();

        return 1 + display(head.getNext());
    }



    //Wrapper to search the LLL for a matching activity by name of either recipe or game
    public int searchDisplay(){
        String toFind = null;
        System.out.println("\nEnter either the name of the recipe or game.");
        System.out.print("\nSearch: ");
        input = new Scanner(System.in);
        toFind = input.nextLine();

        return searchDisplay(this.head, toFind);
    }



    //Recursively traverse to find the matching activity to display
    protected int searchDisplay(ActivityNode head, final String toFind) {
        if (head == null)
            return 0;
        if (head.object.compare(toFind)){
            head.object.display();
            return 1;
        }
        else
            return searchDisplay(head.getNext(), toFind);
    }




    //Wrapper to remove a single activity node from the list
    //Prompts the user for a name of recipe or name of game to find and remove
    public int removeActivity(){
        String toFind = null;
        System.out.print("Enter either the name of the recipe or game to remove.");
        System.out.print("\nSearch: ");
        input = new Scanner(System.in);
        toFind = input.nextLine();

        this.head = removeActivity(this.head, toFind);
        return 0;
    }



    //Recursively removes a single activity node from the list
    protected ActivityNode removeActivity(ActivityNode head, final String toFind){
        if(head == null) return null;
        if(head.object.compare(toFind)) {
            head = head.next;
            if(head == null)
                return null;
        }
        if(head.next != null)
            head.next = removeActivity(head.getNext(), toFind);

        return head;
    }




    //Wrapper function to remove all of the activities
    public int removeAll()
    {
        if (head == null) return 0;
        head = removeAll(head);
        return 1;
    }



    //Recursive function to remove all of the activities
    private ActivityNode removeAll(ActivityNode head)
    {
        if (head == null) return null;
        //Clear all of the data by going to the end and recursing back.
        removeAll(head.getNext());
        head = null;

        return head;
    }
}
