package Books.CrackingTheCodingInterview.Chapter2LinkedList;

import DataStructure.LinkedList.SLLNode;

/**
 * Created by Nikhil on 1/29/2017 8:35 PM.
     2.7 Intersection: Given two (singly) linked lists, determine if the two lists intersect.
    Return the intersecting node.
    Note that the intersection is defined based on reference, not value. That is, if the kth
     node of the first linked list is the exact same node (by reference) as the jth node of the second
     linked list, then they are intersecting.

    Hints:  #20,    = Can be solved in O(A+B) time and  O(1) space, HashTable can also be used.
            #45,    = Draw two linked list | example helps to understand
            #55,    = find if there is intersection
            #65,    = Notice two intersection list will always have same last node, from node where they intersect to last node all are same
            #76,    = check if they intersect by travelling to end of list and checking their last node.
            #93,    = Now find where they intersect | if both list have same length ?
            #111,   = If same legnth, then move forward simultaneously and check value of each node for equality | if length not equal ?
            #120,   = if length not equal | try using difference of length of two linked lists.
            #129    = with this difference try to move pointer of longer list then start from both list simultaneously.
 * Solution 232:
 */
public class P7ListIntersection {
    private static SLLNode findIntersection(SLLNode head1, SLLNode head2){
        if(head1==null || head2==null) return null;
        //1. Run through each linked list to get the lengths and the tails.
        ResultNode result1 = getLengthAndTail(head1);
        ResultNode result2 = getLengthAndTail(head2);

        //2. Compare the tails. If they are different (by reference, not by value), return immediately. There is no intersection.
        if(result1.tail != result2.tail) return null;

        //3. Set two pointers to the start of each linked list.
        //way1
        /*SLLNode shorter = result1.length > result2.length ? head2 : head1;
        SLLNode longer = result1.length > result2.length ? head1 : head2;*/

        //way2
        SLLNode start1 = head1;
        SLLNode start2 = head2;

        //4. On the longer linked list, advance its pointer by the difference in lengths.
        if(result1.length > result2.length){
            start1 = neutralize(start1, result1.length-result2.length);
        }else {
            start2 = neutralize(start2, result2.length - result1.length);
        }

        //5. Now, traverse on each linked list until the pointers are the same.
        while(start1!=start2){
            start1 = start1.next;
            start2 = start2.next;
        }
        return start1;  //or start2
    }
    private static SLLNode neutralize(SLLNode head, int length){
        SLLNode node = head;
        while(length>0 && node!=null){
            length--;
            node = node.next;
        }
        return node;
    }
    private static ResultNode getLengthAndTail(SLLNode head){
        if(head == null) return null;
        SLLNode node = head;
        int length = 1;
        while(node.next!=null){         //at last node would be tail node
            length++;
            node = node.next;
        }
        return new ResultNode(node, length);
    }
    public static class ResultNode{
        public SLLNode tail;
        public int length;

        public ResultNode(SLLNode tail, int length) {
            this.tail = tail;
            this.length = length;
        }
    }

}

/*
Putting it all together.
We now have a multistep process.
1. Run through each linked list to get the lengths and the tails.
2. Compare the tails. If they are different (by reference, not by value), return immediately. There is no intersection.
3. Set two pointers to the start of each linked list.
4. On the longer linked list, advance its pointer by the difference in lengths.
5. Now, traverse on each linked list until the pointers are the same.
 */