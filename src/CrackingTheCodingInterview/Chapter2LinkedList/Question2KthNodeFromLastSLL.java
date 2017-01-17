package CrackingTheCodingInterview.Chapter2LinkedList;

import DataStructure.LinkedList.SLLNode;

/**
 * Created by Nikhil on 1/16/2017 6:04 PM.
 */
public class Question2KthNodeFromLastSLL {
    public static void main(String[] args) {

    }
    //1->2->3->4->5->6->7->8->9->10 k=7
    /*
    Time: O(n) Space: O(1)
     */
    private static SLLNode KthNodeFromLastSLL(SLLNode head, int K){
        if(K<=0) return null;

        SLLNode node1 = head;
        SLLNode node2 = head;
        for (int i = 1; i < K; i++) {       //1,2,3,4,5
            assert node2.next!= null;
            node2 = node1.next;
        }
        if(node2 == null) return null;
        while(node2.next != null){
            node1=node1.next;
            node2=node2.next;
        }
        return node1;
    }
    private static SLLNode KthNodeFromLastSLLExplained(SLLNode head, int K){
        if(K<=0) return null;                                       //Use two pointer SLLNode
                                                                    //Start 2nd Pointer from Kth node to End.
        SLLNode node1 = head;                                          //At same time start 1st pointer from start.
        SLLNode node2 = head;                                          //for 2nd pointer to reach last node (length-k)steps
        for (int i = 1; i < K; i++) {       //1,2,3,4,5             //Simiarly 1st pointer would b k nodes from last.
            assert node2.next!= null;
            node2 = node1.next;
        }
        if(node2 == null) return null;
        while(node2.next != null){
            node1=node1.next;
            node2=node2.next;
        }
        return node1;
    }
}
