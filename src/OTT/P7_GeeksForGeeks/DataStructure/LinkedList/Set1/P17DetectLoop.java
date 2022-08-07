package OTT.P7_GeeksForGeeks.DataStructure.LinkedList.Set1;

/**
 * Created by Nikhil on 2/22/2017 8:35 PM.
 */
public class P17DetectLoop {
    static Node head;

    private static boolean isCycle(Node head) {
        if (head == null) return false;

        Node slow = head;
        Node fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.data == fast.data) return true;
        }
        //Extra find node where there is a cycle.
        slow = head;
        while (slow.data != fast.data) {
            slow = slow.next;
            fast = fast.next;
        }
        return false;
    }

}
