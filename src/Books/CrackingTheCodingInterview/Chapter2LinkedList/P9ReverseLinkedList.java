package Books.CrackingTheCodingInterview.Chapter2LinkedList;

/**
 * Created by Nikhil on 2/7/2017 6:29 AM.
 */
public class P9ReverseLinkedList {
    public static void main(String[] args) {
        NodeB head = new NodeB(1, new NodeB(2, new NodeB(3, new NodeB(4, new NodeB(5, null)))));
        head = reverseLinkedList(head);
        NodeB nodeB = head;
        while (nodeB != null) {
            System.out.println(nodeB.value);
            nodeB = nodeB.next;
        }

    }

    private static NodeB reverseLinkedList(NodeB head) {
        if (head == null || head.next == null) return head;
        NodeB remainingList = reverseLinkedList(head.next);      //go till end then remainingList will have last Node
        //change current node to last Node.
        // CurrHead -> finalNode -> Null     objective is to copy CurrentHead to null
        head.next.next = head;              // replacing null with head
        head.next = null;                   //set its next value which is remainingList = null
        return remainingList;               //we wont lose remainingList which was last node as its already stored.
    }

    private static void reverseLinkedListRec2(NodeB node, NodeB head) {
        if (node.next == null) {
            head = node;
            return;
        }
        reverseLinkedListRec2(node.next, head);
        NodeB prev = node.next;         //      combined node.next.next = node.
        prev.next = node;               //
        node.next = null;
    }

    /*first
    * reamingList = 5
    * 4.5.null = 4              = 1.2.3.4.5.4   remaining 5.null -> 5.4     5,3's next = 4
    * 4.5 = null                = 1.2.3.4.*null  remaining 5.4.*null      both at same time.
    * return remainingList=5    = 5.4 returned
    *
    * Second
    * reamingList = 5.4
    * 3.4.null = 3              = 1.2.3.4.3,  5.4.3         both 5 and 3's next is 4.
    * 3.4 = null                = 1.2.3.null.3  remaining 5.4.3.null
    * return remainingList=5    = 5.4.3 returned
    *
    * Third
    * reamingList = 5.4.3
    * 2.3.null = 2              = 1.2.3.(null=2),  5.4.3.2.null
    * 2.3 = null                = 1.2.null.null.  remaining 5.4.3.2.null
    * return remainingList=5    = 5.4.3 returned*/

    static class NodeB {
        int value;
        NodeB next;

        NodeB(int valueIn, NodeB nextIn) {
            value = valueIn;
            next = nextIn;
        }
    }

    /*private static NodeB rerverse3(Node head){

    }*/
}

