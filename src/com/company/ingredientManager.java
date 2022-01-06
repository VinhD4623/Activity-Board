/*
    Name:           Vinh Duong
    Assignment:     Project5
    Class:          CS202
    Date:           3/17/2021

    This file is to support an array of linked list of ingredients
    Each index contains a category of ingredient based on the type of food
    The linked list aspect is for an individual ingredient type.

    Supports:        1.) Build category list
                     2.) Prebuilt category list to insert ingredients
                     3.) Insert category
                     4.) Insert ingredient
                     5.) Display all ingredients
                     6.) Remove ingredient
                     7.) Clear ingredient list
 */
package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;


public class ingredientManager {

    //Data members
    protected Scanner input;
    protected int size;
    protected Category [] list;
  //  protected Node[] ingredient;



    //Constructor
    ingredientManager(){
        size = 0;
        list = null;
    }



    //Constructor that takes in a int for the size of array
    ingredientManager(final int num){
        buildCategoryList(num);
    }


    //Copy constructor
    ingredientManager(final ingredientManager obj){
        this.size = obj.size;
        //Copy over the array of categories first
        list = new Category[this.size];

        for(int i = 0; i < this.size; ++i){
            if(obj.list[i] != null) {

                //Copy the category names first
                this.list[i].category = obj.list[i].category;

                //Copy over the LLL of ingredients

            }
        }
    }




    //Builds/initialize a array of categories of food ingredients
    public int buildCategoryList(int num){
        this.size = num;
        list = new Category[this.size];
        for(int i = 0; i < this.size; ++i)
        {
            list[i] = new Category();
        }
        return this.size;
    }



    //Adds categories to the array
    public int addCategory(final String toAdd){
        int index = -1;
        for(int i = 0; i < size; ++i)
        {
            if(list[i].category == null){
                list[i].category = toAdd;
                index = i;
                return index;
            }
        }
        return index;
    }



    //Prints the categories in the array
    public void printCategories(){

        System.out.println("\n\n::: Ingredient category list :::");
        for(int i = 0; i < size; ++i){

            int x = 0;  //local variable to calculate proper index for display
            x = i + 1;
            System.out.println("(" + x + "):" + list[i].category);
        }
        System.out.println("List size: " + size);
    }



    //Adds ingredients to an array index
    public int addIngredients(){
        int command = 0;
        boolean success = true;

        do {
            try {

                printCategories();
                input = new Scanner(System.in);
                System.out.println("What category of food is the ingredient?");
                System.out.print("Selection: ");
                command = input.nextInt();
                success = true;
            //   System.out.println(command);
                if(command < 1 || command > 10) {
                    System.out.println("Invalid choice! \nPlease choose a number between 1-10");
                    success = false;
                }
            } catch (InputMismatchException x) {
                System.out.println("Invalid Input! Not integer input.");
                success = false;
            } catch (Exception y) {
                System.out.println("Invalid Input!");
                success = false;
            }
        }while(!success);

        list[command - 1].insertIngredient();

        return command;
    }




    //Removes an ingredient in the array of categories
    public boolean removeIngredient(){
        boolean success = true;
        int command = 0;
        String search = null;

        printCategories();

        do {
            try {
                command = 0;
                input = new Scanner(System.in);
                System.out.print("Category of ingredient to remove: ");
                command = input.nextInt();
                input.nextLine();
                System.out.print("Name of ingredient to remove: ");
                search = input.nextLine();

                success = true;

                if(command < 1 || command > 10) {
                    System.out.println("Invalid choice! \nPlease choose a number between 1-10");
                    success = false;
                }
            } catch (Exception x) {
                System.out.println("\nInvalid input!");
                success = false;
            }
        }while (!success);

        list[command - 1 ].removeIngredient(search);
        return false;
    }




    //Clears out the array of LLL
    public boolean clear(){
        if(list == null)
            return false;
        for(int i = 0; i < size; ++i){
            list[i].clear();
        }
        return true;
    }




    //Traverse through the array and LLL to print out any existing ingredients
    public int displayIngredient() {
        if (list == null)
            return 0;
        else {
            for (int i = 0; i < size; ++i) {
                if (list[i] == null)
                    continue;
                if (list[i].head == null) {
                    continue;
                }
                System.out.println("< " + list[i].category + " >");
                list[i].displayIngredient();
            }
        }
        return size;
    }




    //Pre-builds an array of categories if client chooses
    //User has an option to create their own category list
    //Or opt for a prebuilt array of food categories
    public void prebuiltCategoryList(int num){
        buildCategoryList(num);
        addCategory("Vegetable");
        addCategory("Fruit");
        addCategory("Grain");
        addCategory("Herb");
        addCategory("Starch");
        addCategory("Dairy");
        addCategory("Oils");
        addCategory("Sugars");
        addCategory("Fish");
        addCategory("Poultry");
        addCategory("Red Meat");
    }
}
