package Books.CrackingTheCodingInterview.Chapter2LinkedList;

import DataStructure.LinkedList.SLLNode;

/**
 * Created by Nikhil on 1/16/2017 6:54 PM.
 * 2.3 Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but
     the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
     that node.
     EXAMPLE
     lnput:the node c from the linked lista->b->c->d->e->f
     Result: nothing is returned, but the new linked list looks like a->b->d->e- >f
     Hints:#72  =
 */
public class P3DeleteANodeAtLocation {
    private static boolean deleteNode(SLLNode node){
        if(node == null || node.next ==null){
            return false;
        }
        node.data = node.next.data;     // copy next value to current node
        node.next = node.next.next;     // move current next to next.next.
        return true;
    }
}
