package CrackingTheCodingInterview.Chapter2LinkedList;

import DataStructure.LinkedList.SLLNode;

import java.util.Stack;

/**
 * Created by Nikhil on 1/27/2017 5:05 AM.
 * Palindrome: Implement a function to check if a linked list is a palindrome.
    Hints:#5, #13, #29, #61, #101
 */
public class P6Pallindrom {
    private static boolean isPallindromList(SLLNode head, int length){
        return isPallindromListRec(head, length, (length/2)+1);
    }
    private static boolean isPallindromListRec(SLLNode head, int length, int count){
        return false;
    }

    private static boolean isPallindromStack(SLLNode head){
        SLLNode fast = head, slow = head;
        Stack<SLLNode> stack = new Stack<>();
        while(fast!=null && fast.next!=null){
            stack.push(slow);
            slow = slow.next;
            fast = fast.next.next;
        }
        //check if length is odd
        if(fast!=null){     //
            slow = slow.next; //skipped middle node check for odd case.
        }

        while(slow!=null){
            int value = stack.pop().data;
            if(value!= slow.data) return false;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        SLLNode node1 = new SLLNode(1);
        SLLNode node2 = new SLLNode(2);
        SLLNode node3 = new SLLNode(3);
        SLLNode node4 = new SLLNode(2);
        SLLNode node5 = new SLLNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

    }
}
