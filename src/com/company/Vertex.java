/*
    Name:           Vinh Duong
    Assignment:     Project5
    Class:          CS202
    Date:           3/17/2021


    This file contains a Vertex object that is essentially a node that contains a person object.
    the purpose of this class is to hold a person. I should have made this class derived from person
    but I ran out of time. That would have been a better implementation.
    THe only purpose of this class is to allow traversal in the tree.
 */

package com.company;

public class Vertex{

    //Data members
    protected Person object;
    protected int height;

    protected Vertex left;
    protected Vertex right;




    //Constructor
    public Vertex() {
        this.object = null;
        this.height = 0;
        this.left = null;
        this.right = null;
    }


    //Constructor
    public Vertex(final Person obj) {
        this.object = obj;
        this.height = 0;
        this.left = null;
        this.right = null;
    }


    //Copy Constructor
    public Vertex(final Vertex toCopy){
        this.left = null;
        this.right = null;
        this.object = toCopy.object;
    }



    //Returns the left reference
    public Vertex getLeft(){
        return left;
    }




    //Returns the right reference
    public Vertex getRight(){
        return right;
    }



    //Compares the current object with the passed in object
    public int compare(final Person obj){
        return object.compare(obj);
    }



}
