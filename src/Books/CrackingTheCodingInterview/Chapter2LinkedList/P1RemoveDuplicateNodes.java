package Books.CrackingTheCodingInterview.Chapter2LinkedList;

import DataStructure.LinkedList.SLLNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nikhil on 1/16/2017 1:48 PM.
     * The "Runner"Technique
     * The "runner" (or second pointer) technique is used in many linked list problems. The runner technique
        means that you iterate through the linked list with two pointers simultaneously, with one ahead of the
        other. The "fast" node might be ahead by a fixed amount, or it might be hopping multiple nodes for each
        one node that the "slow" node iterates through.
     * For example, suppose you had a linked list a1 - >a2 -> ••• ->an - >b1 ->b2 -> ••• ->bn and you wanted to
        rearrange it into a1 ->b1 ->a2 - >b2 -> ••• - >an - >bn. You do not know the length of the linked list (but you
        do know that the length is an even number).
     * You could have one pointer pl (the fast pointer) move every two elements for every one move that p2
        makes. When pl hits the end of the linked list, p2 will be at the midpoint. Then, move pl back to the front
        and begin "weaving" the elements. On each iteration, p2 selects an element and inserts it after pl.

        Remove Dups! Write code to remove duplicates from an unsorted linked list.
        FOLLOW UP
        How would you solve this problem if a temporary buffer is not allowed?
        Hints: #9 - Using HashTable - In single cycle can be solved.
             #40 - for O(n) space it would take O(n2) time, maitain 2 pointers one ahead of current and check for duplicate
 */
public class P1RemoveDuplicateNodes {
    public static void main(String[] args) {

    }
    // O(N) time Space : O(N)  Runner technique
    private static void removeDuplicate(SLLNode node){
        Map<Integer, Boolean> map = new HashMap<>();
        SLLNode previous = null;
        while(node!= null){
            if(!map.containsKey(node.data)){
                map.put(node.data, true);
                previous = node;
            }else{
                assert previous != null;
                previous.next = node.next;          // prev -> SLLNode -> SLLNode's Next
            }
            node = node.next;
        }
    }

    private static void removeDuplicateImproved(SLLNode head){
        if(head==null) return;
        SLLNode current = head;
        while(current!=null){                   //check till last node
            SLLNode fast = current;
            while(fast.next!=null){             //check till second last node only.
                if(fast.next.data == current.data){     //check for next node data
                    fast.next = fast.next.next;         //move to next of next of current next.
                }else {
                    fast = fast.next;
                }
            }
        }
    }
}
