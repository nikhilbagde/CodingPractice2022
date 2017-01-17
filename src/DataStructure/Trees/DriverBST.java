package DataStructure.Trees;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Nikhil on 9/14/2016.
 */
public class DriverBST {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(9);
        tree.insert(11);
        tree.insert(5);
        tree.insert(4);
        tree.insert(6);
        tree.insert(2);
        tree.insert(3);
        tree.insert(1);
        tree.insert(10);
        tree.insert(12);
        tree.insert(13);

        tree.levelOrder(tree.getRoot());
        newLine();
        System.out.println( "Height is " + tree.height(tree.getRoot()));
        newLine();
        tree.preOrder(tree.getRoot());
        newLine();
        tree.inOrder(tree.getRoot());
        newLine();
        tree.postOrder(tree.getRoot());

        newLine();
        //tree.inOrderUsingStack(tree.getRoot()); //Not working, infinite loop
        newLine();
        System.out.println("Size of Tree is " + tree.size(tree.getRoot()));

        BinaryTree tree1 = new BinaryTree(9);
        tree1.insert(11);
        tree1.insert(5);
        tree1.insert(4);
        tree1.insert(6);
        tree1.insert(2);
        tree1.insert(3);
        tree1.insert(1);
        tree1.insert(10);
        tree1.insert(12);
        tree1.insert(13);

        System.out.println("Is two trees are identical ? -> " + tree1.isIdentical(tree.getRoot(), tree1.getRoot()));

        //Print path from root to leave in every line
        System.out.println("Printing path ");
        tree.printPath(tree.getRoot());

        //Print leaf count test
        System.out.println("Leaf count of tree is = " + tree.leafCount());

  /*      String name[] = new String[100];
        name[0] = "Nikhil YOu have been selected";

        System.out.println(name[0]);
*/
/*
        char name1[] = new char[100];
        String message = "NIKHIL YOU HAVE BEEN SELECTED!";
        System.out.println(message);*/

        //Test levelwise printing of nodes with calculating max 3 elemenet at given level.
        BinaryTree binaryTree = new BinaryTree(50);
        binaryTree.insert(17);
        binaryTree.insert(76);
        binaryTree.insert(9);
        binaryTree.insert(23);
        binaryTree.insert(54);
        binaryTree.insert(78);
        binaryTree.insert(14);
        binaryTree.insert(19);
        binaryTree.insert(12);
        binaryTree.insert(72);
        binaryTree.insert(67);
        binaryTree.preOrder(binaryTree.getRoot());

        binaryTree.printLevelLargest(binaryTree.getRoot(), 3, 2);



    }
    public static void newLine(){
        System.out.println();
    }



}
