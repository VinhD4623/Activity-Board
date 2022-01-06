/*
    Name:           Vinh Duong
    Assignment:     Project5
    Class:          CS202
    Date:           3/17/2021

    This is the manger for the AVL tree. The tree contains object of Person type.
    It contains the root of Vertex type to manage the tree.
    In the tree it supports:    1.) Insertion of a person and activities
                                2.) Insertion of new activities for a existing person
                                3.) Search and display a person and their postings
                                4.) Display all users and postings
                                5.) clear the posting board

 */

package com.company;
import java.lang.Math;
import java.util.Scanner;

public class TreeManager {

    //Data members
    protected Vertex root;
    protected Scanner input;



    //constructor
    public TreeManager() {
        this.root = null;
        this.input = null;
    }



    //Wrapper to inserts a person into a AVL tree
    public int insertPerson(){

        //Creates a new person object and read in the data
        Person obj = new Person();
        obj.read();

        //Pass the person into the tree to be inserted
        this.root = insertPerson(this.root, obj);
        return 1;
    }



    //Inserts a person into a AVL tree
    private Vertex insertPerson(Vertex curr, Person obj) {
        //Base case: If current vertex is empty we create a new and insert the copy the data
        if (curr == null){
            curr = new Vertex(obj);
        }
        else if(isGreater(curr, obj))  //New person object is less than current vertex's person
            curr.left = insertPerson(curr.getLeft(), obj);  //Traverse left

        else if(!isGreater(curr, obj))   //New person object is greater than current vertex's person
            curr.right = insertPerson(curr.getRight(), obj);  //Traverse right

        //On the way back we need to make sure the tree is balanced
        curr = balance(curr, obj);

        curr.height = Math.max(getHeight(curr.left), getHeight(curr.right));
        ++curr.height;  //Need to make sure we increment the height before return
        return curr;
    }



    //Search for a user to display their postings
    public int searchUser(){
        if(this.root == null)
            return -1;
        input = new Scanner(System.in);
        String toFind = null;
        System.out.print("Name of the person view: ");
        toFind = input.nextLine();
        return searchUser(this.root, toFind);
       }


       //Helper to search for a user and display the postings
    private int searchUser(Vertex root, String toFind){
        if(root == null)
            return 0;
        if(toFind.compareTo(root.object.name) == 0){
            System.out.println("Name: " + root.object.name);
            root.object.list.display();
            return 1;
        }
        else if(toFind.compareTo(root.object.name) < 0)
            insertActivity(root.getRight(), toFind);
        else
            insertActivity(root.getLeft(), toFind);
        return 0;
    }




    //Wrapper to search for a user to insert more activity postings
    public int insertActivity(){
        if(this.root == null)
            return 0;
        input = new Scanner(System.in);
        String toFind = null;
        System.out.print("Name of the person to add activity: ");
        toFind = input.nextLine();

        return insertActivity(this.root, toFind);
    }


    //Traverse tree to find a matching person to insert more activities
    private int insertActivity(Vertex root, String toFind){
        if(root == null)
            return 0;
        if(toFind.compareTo(root.object.name) == 0){
            root.object.list.addActivity();
            return 1;
        }
        else if(toFind.compareTo(root.object.name) < 0)
            insertActivity(root.getRight(), toFind);
        else
            insertActivity(root.getLeft(), toFind);
        return 0;
    }


    //This function is called to balance the tree when unwinding the stack.
    private Vertex balance(Vertex curr, Person obj){

        /* Case 1: If the current vertex's left's left child is causing an imbalance
            from inserting the new item to the left's left.
            Then we need to perform a right rotation.
         */
        if(balanceFactor(curr) > 1 && isGreater(curr.left, obj))
            return rotateRight(curr);

        /* Case 2: If the current vertex's right's right child is causing an imbalance
            from inserting the new item to the right's right.
            Need to perform a right rotation.
         */
        if(balanceFactor(curr) < -1 && !isGreater(curr.right, obj))
            return rotateLeft(curr);

        /* Case 3: If the current vertex's left's right is causing the imbalance
            from inserting to the left's right.
            Need to perform a left rotation then a right rotation.
         */
        if(balanceFactor(curr) > 1 && !isGreater(curr.left, obj)) {
            curr.left = rotateLeft(curr.left);
            return rotateRight(curr);
        }

        /* Case 4: If the current vertex's right's left is causing the imbalance
            from inserting to the right's left.
            Need to perform a right rotation then a left rotation.
         */
        if(balanceFactor(curr) < -1 && isGreater(curr.right, obj)){
            curr.right = rotateRight(curr.right);
            return rotateLeft(curr);
        }
        return curr;
    }





    //Compares a vertexes person object to the passed in person object
    //This is to help simplify comparisons
    private boolean isGreater(Vertex curr, Person toCompare){
        if(curr == null)
            return false;
        else if(curr.object.compare(toCompare) > 0)
            return true;
        else
            return false;
    }




    private int balanceFactor(Vertex curr){
        return getHeight(curr.left) - getHeight(curr.right);
    }




    //This function rotates the passed in vertex with a right rotation
    private Vertex rotateRight(Vertex curr) {

        //This is when the rotation occurs
        Vertex temp = curr.left;
        curr.left = temp.right;
        temp.right = curr;

        //Update the height of the vertices
        curr.height = Math.max(getHeight(curr.left), getHeight(curr.right));
        temp.height = Math.max(getHeight(temp.left), curr.height);

        ++curr.height;
        ++temp.height;

        return temp;
    }




    //This function rotates the passed in vertex with a left rotation
    private Vertex rotateLeft(Vertex curr) {

        //This is when the rotation occurs
        Vertex temp = curr.right;
        curr.right = temp.left;
        temp.left = curr;

        //Readjust the height of the vertices
        curr.height = Math.max(getHeight(curr.left), getHeight(curr.right));
        temp.height = Math.max(getHeight(temp.right), curr.height);

        ++curr.height;
        ++temp.height;

        return temp;
    }





    //Returns the height of the Vertex passes in
    //If the Vertex is null returns a 0
    public int getHeight(Vertex curr) {
        if(curr == null)
            return 0;
        else
            return curr.height;
    }





    //Displays the tree using in order traversal
    public int displayInOrder() {

        //Print the min and max heights to compare balance factor
        int max = maxHeight(this.root);
        int min = minHeight(this.root);
        System.out.println("Max height of tree: " + max);
        System.out.println("Min height of tree: " + min);
        return displayInOrder(this.root);
    }



    //Tester function to check if insertion is correct by printing in order
    private int displayInOrder(Vertex root) {
        if (root == null)
            return 0;
        int count = displayInOrder(root.getLeft());
        ++count;
        root.object.display();
        System.out.print(" ");
        count += displayInOrder(root.getRight());
        return count;
    }




    //Tester function to display level by level to check if insertion was correct
    public int displayPreOrder(){
        int level = getHeight(root);
        System.out.println("\nHeight of tree: " + level);
        System.out.print("Root: ");
        root.object.display();
        System.out.println("\n");
        for(int i = 1; i < level + 1; i++){
            int x = i;

            System.out.println(":::Level: " + x);
            displayPreOrder(root, i);
            System.out.println();
        }
        return level;
        // return displayPreOrder(root);
    }




    //Recursive function to display the tree using pre order traversal
    private void displayPreOrder(Vertex root, int level){
        if(root == null)
            return;
        if(level == 1) {
            root.object.display();
            System.out.print("  ");
        }
        else if(level > 1) {
            displayPreOrder(root.getLeft(), level - 1);
            displayPreOrder(root.getRight(), level - 1);
        }

    }



    //Returns the highest hanging leaf in the tree
    //Uses the java.lang.Math package to return the min
    public int minHeight(Vertex root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null) {
            return minHeight(root.getRight()) + 1;
        }
        if (root.right == null) {
            return minHeight(root.getLeft()) + 1;
        }
        return Math.min(minHeight(root.left), minHeight(root.right)) + 1;
    }





    //Returns the lowest hanging leaf in the tree
    //Uses the java.lang.Math package to return the max
    public int maxHeight(Vertex root) {
        if (root == null)
            return 0;
        else
        {
            int height1 = maxHeight(root.getLeft());
            int height2 = maxHeight(root.getRight());

            //Return the larger of the two
            if (height1 > height2)
                return (height1  + 1);
            else
                return (height2 + 1);
        }
    }




    //Clears the tree
    public void clearTree(){
        root = null;
    }


}
