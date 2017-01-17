package DataStructure.DoubleLinkedList;

/**
 * Created by Nikhil on 8/17/2016.
 */
public class DLLNode {
    int data;
    DLLNode next;
    DLLNode prev;
    DLLNode(int data){
        this.data = data;
        next = prev = null;
    }
}

