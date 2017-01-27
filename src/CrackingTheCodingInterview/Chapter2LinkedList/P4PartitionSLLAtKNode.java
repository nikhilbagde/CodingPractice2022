package CrackingTheCodingInterview.Chapter2LinkedList;

import DataStructure.LinkedList.SLLNode;

/**
 * Created by Nikhil on 1/17/2017 4:32 PM.
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

        while(node!=null){
            if(node.data < value){
                node.next = beforeStart;
                beforeStart = node;
            }else{
                node.next = afterStart;
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
