/*
    Name:           Vinh Duong
    Assignment:     Project5
    Class:          CS202
    Date:           3/17/2021

    This file contains a activity node with the main purpose is to allow traversal through a linear linked list.
    Supports traversal to the next activity node.

 */

package com.company;

import java.util.Scanner;

public class ActivityNode {
    protected Scanner input = null;
    protected Activity object;
    protected ActivityNode next;

    public ActivityNode(){
        this.object = null;
        this.next = null;
    }

    public ActivityNode(final ActivityNode toCopy){
        this.object = toCopy.object;
        this.next = null;
    }

    public ActivityNode(final Activity obj){
        this.object = obj;
        this.next = null;
    }

    public ActivityNode getNext(){
        return this.next;
    }

    public void setNext(ActivityNode toConnect){
        this.next = toConnect;
    }

    public void display(){
        object.display();
    }
}
