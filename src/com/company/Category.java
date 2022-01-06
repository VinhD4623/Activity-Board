/*
        Name:           Vinh Duong
        Assignment:     Project5
        Class:          CS202
        Date:           3/17/2021

       This file contains a category object. Its job is to handle the linear linked list
       of ingredients. It contains a the head of the class Node which is derived from ingredient.
       This file supports:  1.) Insert ingredient
                            2.) Remove ingredient
                            3.) Display
                            4.) clear ingredient list
                            5.) copy list
*/
package com.company;

public class Category {

    protected String category;
    protected Node head;


    //Constructor
    public Category() {
        head = null;
        category = null;
    }


    //Wrapper inserts in new ingredient
    public int insertIngredient(){
        this.head = insertIngredient(this.head);
        return 1;
    }


    //Takes in a Node to add an ingredient item to a LLL
    protected Node insertIngredient(Node head) {

        //If we reach the end of list add
        if (head == null) {
            head = new Node();
            head.read();
            head.setNext(null);
            // return head;
        }
        //If the first node already exist from initializing the array but has no data
        else if(head.name == null){
            head.read();
        }
        else
            head.next = insertIngredient(head.getNext());
        return head;
    }


    //Wrapper function to copy a LLL of ingredients
    public int copyLLL(final Category obj){
        return copyLLL(this.head, obj.head);
    }



    //Recursively traverse and copy over the LLL of ingredients for specific index
    protected int copyLLL(Node head, Node dest){
        if(head == null)
            return 0;
        dest = head;
        return 1 + copyLLL(head.getNext(), dest.getNext());

    }



    //Wrapper function to display the list of ingredients
    public int displayIngredient(){
        if(head == null) return 0;
        return displayIngredient(head);
    }




    //Displays the ingredients recursively
    protected int displayIngredient(Node head){
        if(head == null)
            return 0;
        head.display();
        return 1 + displayIngredient(head.getNext());
    }



    //Wrapper function to remove a ingredient in the lll
    public int removeIngredient(final String toRemove){
        if(this.head == null) return 0;
        this.head = removeIngredient(this.head, toRemove);
        return 1;
    }



    //Recursively removes an ingredient from the list
    protected Node removeIngredient(Node head, final String toRemove){
        if(head == null){
            return null;
        }
        if(head.compare(toRemove)){
            System.out.println("FOund!!!!!!!");
            head = head.next;
            if(head == null)
                return null;
            else
                return head;
        }
        if(head.next != null){
            head.next = removeIngredient(head.getNext(), toRemove);
        }
        return head;
    }


    //Wrapper to clear a linear linked list
    public int clear(){
        if(this.head == null)
            return 0;
        this.head = clear(this.head);
        return 1;
    }



    //Recursive clear list method
    protected Node clear(Node head){
        if(head == null)
            return null;
        clear(head.getNext());
        head = null;
        return head;
    }
}
