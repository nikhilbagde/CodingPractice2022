package CrackingTheCodingInterview.Chapter2LinkedList;

import DataStructure.LinkedList.SLLNode;

/**
 * Created by Nikhil on 1/29/2017 9:47 PM.
 * 2.8 Loop Detection: Given a circular linked list,
 * PAGE 95
 * implement an algorithm that returns the node at the beginning of the loop.
 * DEFINITION :
 *  Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node,
 *  so as to make a loop in the linked list.
 *  EXAMPLE
 *  Input: A -> B -> C - > D -> E -> C [the same C as earlier]
 *  Output: C
 *  Hints:  #50, = Actually two part of problem, 1. Detect if there is a loop 2. Find where loop starts.
 *          #69, = TO Detect loop, try runner method, where out of two pointers one pointer move fast.
 *          #83, = One pointer move fast, both pointers will collide | They land at same location at same time | what is this location ? where they collide ?
 *          #90  = Where two pointers start ?
 *          1->2->3->4->5->6->7->8->9->?
 *          lets assume ? points to 1.  they meet at 1. after 9 iterations. 1 full iteration
 *          assume ? point to 2.        they meet ar 2 after 1 full iteration again.
 *          assume ? points to 3
 * Solution: 223
 */

public class P8LoopDetection {
    private static SLLNode findStartOfCollision(SLLNode head){
        //1. Create two pointers, FastPointer and SlowPointer.
        SLLNode slow = head;
        SLLNode fast = head;

        //2. Move FastPointer at a rate of 2 steps and SlowPointer at a rate of 1 step.
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow ==fast){
                break;
            }
        }
        //3. When they collide, move SlowPointer to LinkedListHead. Keep FastPointer where it is.
        slow = head;

        //4. Move SlowPointer and FastPointer at a rate of one step. Return the new collision point.
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;        //or return fast.
    }
}

/*
Steps:
1. Create two pointers, FastPointer and SlowPointer.
2. Move FastPointer at a rate of 2 steps and SlowPointer at a rate of 1 step.
3. When they collide, move SlowPointer to LinkedListHead. Keep FastPointer where it is.
4. Move SlowPointer and FastPointer at a rate of one step. Return the new collision point.
 */