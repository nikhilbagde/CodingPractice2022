package OTT.P7_GeeksForGeeks.DataStructure.LinkedList.Set1;

/**
 * Created by Nikhil on 2/22/2017 5:45 PM.
 */
public class P9SwapNodesWithoutData {
    static Node head;

    /*
    Hint :  1. keep previous and current pointer.
            2. first change next of previous pointer and then next of current pointer.
            3. first check if both node are present in linked-list or not
            4. What if one of the node is head node
            5. what if both nodes are middle nodes
            6. what if one of the node is tail node -> this doesn't make any difference.
    */
    private static void swapNodes(int x, int y) {

        //search for node and keep track
        if (x == y) {
            System.out.println("Same Nodes");
            return;
        }

        Node prevOne = null;
        Node currOne = head;

        while (currOne != null && currOne.data != x) {
            prevOne = currOne;
            currOne = currOne.next;
        }

        Node prevTwo = null;
        Node currTwo = head;

        while (currTwo != null && currTwo.data != y) {
            prevTwo = currTwo;
            currTwo = currTwo.next;
        }

        if (currOne == null || currTwo == null) System.out.println("Node not presnet!");

        //x is head
        if (prevOne == null) {                        //  head->1->2-3-4-5-6-7-8        x=1 y=4
            head = currTwo;                         //  head->4
        } else {    //when its node head            //  head->1->2-3-4-5-6-7-8        x=3 y=7
            prevOne.next = currTwo;                 //  2->7
        }


        //y is head
        if (prevTwo == null) {                        //  head->1->2-3-4-5-6-7-8        x=5 y=1
            head = currOne;                         //  head->5
        } else {    //when its node head            //  head->1->2-3-4-5-6-7-8        x=3 y=7
            prevTwo.next = currOne;                 //  6->3
        }

        //when both node are middle nodes.
        //or both nodes are tail nodes.
        Node temp = currOne.next;
        currOne.next = currTwo.next;
        currTwo.next = temp;
    }
}
