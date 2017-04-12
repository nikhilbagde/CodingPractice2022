package CompanyCompetetions.Amazon.Interview1;

/**
 * Created by Nikhil on 4/6/2017 5:15 PM.
 */
public class ReverseSecondHalfOfLinkedList {
    public static void main(String[] args) {

    }

    private static Node getMidNode(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean isPalindrome(Node head) {
        if (head == null || head.next == null)
            return true;
        Node fast = head, slow = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        slow = reverseHalf(slow);
        while (head != null && slow != null) {
            if (head.value != slow.value)
                return false;
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    private Node reverseHalf(Node head) {
        Node prev = null, cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            next = null;
        }
    }
}
