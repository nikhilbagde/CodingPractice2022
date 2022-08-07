package OTT.P7_GeeksForGeeks.DataStructure.LinkedList.Set3;


/**
 * Created by Nikhil on 2/23/2017 2:27 PM.
 */
public class P31DeleteAlternateNodes {
    private static Node deleteAlternate(Node head, String order) {
        if (head == null) return null;

        boolean even = false, odd = false;
        if (order.equals("Even")) {
            even = true;
        } else if (order.equals("Odd")) {
            odd = true;
        }

        if (even) {
            Node current = head;
            while (current != null) {
                current.next = current.next.next;
            }
        } else {
            Node current = head.next;
            while (current != null) {
                current.next = current.next.next;
            }
        }
        return head;
    }
}

