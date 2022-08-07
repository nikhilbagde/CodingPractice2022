package Books.B1_CrackingTheCodingInterview.Chapter2LinkedList;

import DataStructure.LinkedList.SLLNode;

/**
 * Created by Nikhil on 1/16/2017 6:04 PM.
 * Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
    Hints:
        #8,     = What if you know linked list size. Kth from last means whatth from start ?
        #25,    = If linkedList size is not know. Can we calculate it? How much computation ?   - Yes | O(n)
        #41,    = can be solved recursevly.
        #67,
        #126
 */
public class P2KthNodeFromLastSLL {
    public static void main(String[] args) {

    }
    //1->2->3->4->5->6->7->8->9->10 k=7
    /*
    Time: O(n) Space: O(1)
     */
    private static SLLNode KthNodeFromLastSLL(SLLNode head, int K){
        if(K<=0) return null;

        SLLNode first = head;
        SLLNode second = head;
        for (int i = 1; i < K; i++) {       //1,2,3,4,5                 move 1 pointer to k
            assert second.next!= null;
            second = second.next;
        }
        if(second == null) return null;
        while(second.next != null){                              //iterate both pointer with same speed.
            first=first.next;
            second=second.next;
        }
        return first;
    }
    private static SLLNode KthNodeFromLastSLLExplained(SLLNode head, int K){
        if(K<=0) return null;                                       //Use two pointer SLLNode
                                                                    //Start 2nd Pointer from Kth node to End.
        SLLNode node1 = head;                                          //At same time start 1st pointer from start.
        SLLNode node2 = head;                                          //for 2nd pointer to reach last node (length-k)steps
        for (int i = 1; i < K; i++) {       //1,2,3,4,5             //Similarly 1st pointer would b k nodes from last.
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
    public class ValueWrap{
        public int value = 0;
    }
    private static SLLNode kthNodeFromEndRecursive(SLLNode head, int k, ValueWrap obj){
        if(head==null) return null;
        SLLNode node = kthNodeFromEndRecursive(head.next, k, obj);
        //start counting from here.
        obj.value =  obj.value + 1;
        if(obj.value == k){
            return head;        //return head node which is current node in stack
        }
        return node;        //otherwise, continue with returning prev node.         returning intermediate node.
    }
}
