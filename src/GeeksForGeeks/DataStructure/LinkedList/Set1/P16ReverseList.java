package GeeksForGeeks.DataStructure.LinkedList.Set1;

/**
 * Created by Nikhil on 2/22/2017 7:01 PM.
 */
public class P16ReverseList {
    static Node head;

    private static Node reverseList(Node node, Node prev) {
        if (node.next == null) {
            head = node;
            node.next = prev;
            return null;
        }
        Node next2 = node.next;
        node.next = prev;

        reverseList(next2, node);
        return head;
    }

    private static Node reverse(Node node) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;       //store current's next node to temp node.
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }
}
