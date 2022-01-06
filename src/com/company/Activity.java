/*
    Name:           Vinh Duong
    Assignment:     Project5
    Class:          CS202
    Date:           3/17/2021

    This file contains a abstract base class for the activity hierarchy.
    It contains only a name that all of its children and grandchildren also contain.
    This file is what keeps everything connected.

                ::: Activity hierarchy :::
               Base class:      Activity
    Derived from Activity:      Cooking, Games
     Derived from Cooking:      Baking, BBQ, Steam(dumplings)
       Derived from Games:      Board_games, Video_games, Cards
 */
package com.company;
import java.util.Scanner;


//Base class of hierarchy
public abstract class Activity {
    protected Scanner input;
    protected String name;
    protected String note;

    //Constructor
    public Activity(){
        name = null;
    }

    //Copy constructor
    public Activity(final Activity source) {
        copy(source);
    }

    //Copy Activity object
    public void copy(final Activity obj) {
       this.name = obj.name;
    }

    //Reads in the data from user
    abstract public void read();


    //Displays the data of the object to user
    abstract public void display();


    //Compares the name of the object
    abstract public boolean compare(final String a_name);


    //Changes the name of an existing activity obj
    abstract public boolean change_name(String a_name);
}
