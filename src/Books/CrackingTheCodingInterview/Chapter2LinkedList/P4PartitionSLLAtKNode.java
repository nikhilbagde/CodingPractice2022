package Books.CrackingTheCodingInterview.Chapter2LinkedList;

import DataStructure.LinkedList.SLLNode;

/**
 * Created by Nikhil on 1/17/2017 4:32 PM.
 * 2.4 Partition: Write code to partition a linked list around a value x, such that all nodes less than x come
     before all nodes greater than or equal to x. If x is contained within the list, the values of x only need
     to be after the elements less than x (see below). The partition element x can appear anywhere in the
     "right partition"; it does not need to appear between the left and right partitions.
     EXAMPLE
     Input:     3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition= 5]
     Output:    3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
     Hints: #3,     = Many solutions possible.
            #24     =
 */
public class P4PartitionSLLAtKNode {
    private static SLLNode partition(SLLNode head, int value){
        SLLNode beforeStart = null, beforeEnd = null;
        SLLNode afterStart = null, afterEnd = null;
        SLLNode node = head;

        while(node!=null){
            if(node.data < value){
                if(beforeStart==null){
                    beforeStart = node;
                    beforeEnd = node;
                }else {
                    beforeStart.next = node;
                    beforeEnd = node;
                }
            }else{
                if(afterStart==null){
                    afterStart = node;
                    afterEnd = node;
                }else {
                    afterStart.next = node;
                    afterEnd = node;
                }
            }
            node = node.next;
        }

        if(beforeStart==null) return afterStart;

        beforeEnd.next = afterStart;
        return beforeStart;
    }
    //2 less pointers
    private static SLLNode partition2(SLLNode head, int value){
        SLLNode beforeStart = null;     //, beforeEnd = null;
        SLLNode afterStart = null;      //, afterEnd = null;
        SLLNode node = head;

        while(node!=null){                          //1. iterate
            if(node.data < value){                  //2. check
                node.next = beforeStart;            //3. add to respective list
                beforeStart = node;
            }else{
                node.next = afterStart;             //appending at front.
                afterStart = node;
            }
            node = node.next;
        }

        if(beforeStart==null) return afterStart;

        SLLNode finalHead = beforeStart;        //return this later
        while(beforeStart.next!=null){          //get node before null
            beforeStart = beforeStart.next;
        }
        beforeStart.next = afterStart;          //merged.
        return finalHead;
    }
}
