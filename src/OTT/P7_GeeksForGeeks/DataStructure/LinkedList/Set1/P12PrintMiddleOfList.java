package OTT.P7_GeeksForGeeks.DataStructure.LinkedList.Set1;

/**
 * Created by Nikhil on 2/22/2017 6:34 PM.
 * 1->2->3->4->5->6 then output should be 4.
 */
public class P12PrintMiddleOfList {
    static Node head;

    private static Node getMiddleOfList(Node head) {
        if (head == null) return null;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
