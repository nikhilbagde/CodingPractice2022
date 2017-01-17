package CrackingTheCodingInterview.Chapter2LinkedList;

import DataStructure.LinkedList.SLLNode;

/**
 * Created by Nikhil on 1/16/2017 6:54 PM.
 */
public class Question3DeleteANodeAtLocation {
    private static boolean deleteNode(SLLNode node){
        if(node == null || node.next ==null){
            return false;
        }
        node.data = node.next.data;
        node.next = node.next.next;
        return true;
    }
}
