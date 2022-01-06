/*
    Name:           Vinh Duong
    Assignment:     Project5
    Class:          CS202
    Date:           3/17/2021

    This file is the derived from the super base class "Activity"
    It is also the base class to three variations of cooking.
    The support to insert ingredients are here in the this base class
    since the rest of the variations all need ingredients.

 */
package com.company;
import java.util.InputMismatchException;
import java.util.Scanner;


//Derived from the super base class "Activity"
public class Cooking extends Activity{

    //Data members
    protected float temp;
    protected float time;
    protected ingredientManager list;
    protected int size;
    protected Scanner input;



    //Constructor
    public Cooking(){
        super();
        this.temp = 0;
        this.time = 0;
        this.size = 0;
        this.list = null;
    }



    //Copy constructor
    public Cooking(final Cooking obj){
        super(obj);
        this.temp = obj.temp;
        this.time = obj.time;
        this.size = obj.size;
        this.list = obj.list;
    }



    //Reads in the data from the user
    public void read() {
        boolean success = true;

        do {
            try {
                input = new Scanner(System.in);
                System.out.print("Name of the recipe: ");
                super.name = input.nextLine();

                System.out.print("Temperature (Fahrenheit): ");
                this.temp = input.nextFloat();

                System.out.print("Cooking time (minutes): ");
                this.time = input.nextFloat();
                success = true;
            }
            catch(InputMismatchException x){
                System.out.println("Invalid input! Need to enter a number.");
                success = false;
            }
            catch(Exception y){
                System.out.println("Invalid input!");
                success = false;
            }
        }while(!success);   //Keep looping if invalid input


        int command = 0;
        createList();   //Creates a ARR list of categories
        do{
            command = 0;
            ingredientMenu();
            command = readCmd();
            processMenu(this.list, command);

        }while(command != 5);
        //addIngredients(); //Adds ingredients to the ARR list
    }


    public void processMenu(ingredientManager list, int cmd){
        boolean success = false;
        switch(cmd){
            case 1: addIngredients();
                    break;

            case 2: display();
                    break;

            case 3: removeIngredient();
                    break;

            case 4: clearList();
                break;

            case 5: break;

            default: break;
        }
    }

    public void ingredientMenu(){
        System.out.println("\n\n");
        System.out.println("""
                ::: Ingredient menu :::
                (1): Add ingredient.
                (2): Display recipe and ingredient. 
                (3): Remove ingredient.
                (4): Clear ingredient list.
                (5): Exit ingredient menu.
                """);
    }



    //Reads in the user's command and returns the integer chosen
    public int readCmd() {
        int cmd = 0;
        boolean success = true;
        do {
            try {
                cmd = 0;
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



    //Display the data
    public void display() {
        System.out.println("Recipe: " + name);
        System.out.println("Temperature: " + temp + " F°");
        System.out.println("Cook time: " + time + "\tMin");
        if(list != null){
            displayIngredients();
        }
    }


    //Changes the name of the recipe
    public boolean change_name(final String a_name) {
        if(super.name.equals(a_name))
            return false;
        super.name = a_name;
        return true;
    }



    //Compares the current objects name with a passed in string
    public boolean compare(String a_name) {
        return (super.name.equals(a_name));
    }



    //Compares the current name of a recipe with a passed in Cooking obj
    public boolean compare(final Cooking obj) {
        return (super.name.equals(obj.name));
    }



    //Prompts the user if they want to create a category list to insert ingredients into
    //OR they can opt for a prebuilt list of categories that they can insert ingredients into
    public void createList(){
        boolean success = true;
        do {
            try {
                int answer = 0;
                System.out.println("Would you like a prebuild list of ingredient categories?\n");
                System.out.print("""
                        (1): Prebuilt category list to enter in ingredients.
                        (2): Build your own list of categories
                        """);
                System.out.print("Selection: ");
                input = new Scanner(System.in);
                answer = input.nextInt();

                if (answer == 1) {
                    this.list = new ingredientManager();
                    this.list.prebuiltCategoryList(11);
                    success = true;
                }
                else if(answer == 2) {
                    int count = 0;
                    System.out.print("How many category items do you want to enter: ");
                    count = input.nextInt();
                    this.list = new ingredientManager(count);
                    insertCategories(count);
                    success = true;
                }
                else{
                    System.out.println("Invalid choice!");
                    success = false;
                }
            }
            catch(InputMismatchException x){
                System.out.println("\nInvalid input! Must enter a number.");
                success = false;
            }
            catch(Exception y){
                System.out.println("\nThere was an error! Exiting program");
            }
        }while(!success);
    }


    //Adds ingredients to the list
    //Gives the user to continue to insert more ingredients if the wish
    public int addIngredients(){
        boolean success = true;
        int answer = 0;
        do {
            try {
                answer = 0;
                input = new Scanner(System.in);
                System.out.print("""
                        (1): Insert ingredient.
                        (2): Exit.
                         """);
                System.out.print("Selection: ");
                answer = input.nextInt();
                if (answer == 1) {
                    this.list.addIngredients();

                } else if (answer == 2) {
                    System.out.println("\nExit inserting ingredients now.");
                    success = false;
                } else {
                    System.out.println("Invalid selection! Please enter 1 or 2.");
                    success = false;
                }
            }
            catch(InputMismatchException x){
                System.out.println("\nInvalid input! Please enter a number.");
                success = false;
            }
            catch(Exception y){
                System.out.println("\nError!");
                success = false;
            }

        }while(answer != 2);
        return 1;
    }



    //Removes an ingredient from the list
    public boolean removeIngredient(){
        if(list == null)
            return false;

        list.removeIngredient();
        return true;
    }



    //Clears the ingredient list
    public boolean clearList(){
        if(list == null)
            return false;
        list.clear();
        return true;
    }



    //This function displays the contents of the array of linked list of ingredients
    //Only displays the contents if the list isn't empty
    public void displayIngredients(){
        if(list != null)
            list.displayIngredient();
        else
            System.out.println("The ingredient list is empty");
    }



    //Support to insert a category into an initialized array of linked list.
    //This method only works if the ARR is already created else we hit a exception
    public int insertCategories(final int num){
        int count = 0;
        try{
            String toInsert;
            while(count != num){

                input = new Scanner(System.in);
                System.out.print("Category name: ");
                toInsert = input.nextLine();
                this.list.addCategory(toInsert);
                ++count;
            }
        }
        catch (Exception x){
            System.out.println("There was an error! Exiting program.");
        }
        return num;
    }



}
