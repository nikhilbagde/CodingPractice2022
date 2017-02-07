package CompanyCompetetions.PayPal.Practice;

import DataStructure.LinkedList.SLLNode;

/**
 * Created by Nikhil on 2/6/2017 5:00 PM.
 * Given a linkedList head find its middle node.
 */
public class P1FindMiddleOfLinkedList {
    public static void main(String[] args) {
        SLLNode head = new SLLNode(1); SLLNode node1 = new SLLNode(2); head.next = node1;
        getMiddleNode(head);
    }
    private static SLLNode getMiddleNode(SLLNode head){
        if(head==null) return null;
        SLLNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
