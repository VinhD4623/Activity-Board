/*
    Name:           Vinh Duong
    Assignment:     Project5
    Class:          CS202
    Date:           3/17/2021

    This file contains a node which is derived from "Ingredient".
    The job of this class is to allow traversal and treat the whole package
    as a node to insert into a collection of ingredients.
 */
package com.company;


//Derived from ingredients
public class Node extends Ingredient{

    //Data members
    protected Node next;


    //Constructor
    public Node(){
        this.next = null;
    }


    //copy constructor
    public Node(final Node toInsert)
    {
        super(toInsert);
        this.next = null;
    }


    //Returns the next reference
    public Node getNext() {
        return this.next;
    }


    //Sets the next reference
    public void setNext(Node dest){
        this.next = dest;
    }
}
