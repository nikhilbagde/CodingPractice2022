package GeeksForGeeks.DataStructure.LinkedList.Set2;

import java.util.Stack;

/**
 * Created by Nikhil on 2/23/2017 8:42 AM.
 */
public class P22CheckSLLisPallindrom {
    private static boolean isPallindromSSL(Node head) {
        Node slow = head;
        Node fast = head;
        Stack<Node> stack = new Stack<>();

        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }


        while (fast != null && fast.next != null) {
            stack.push(slow);
            slow = slow.next;
            fast = fast.next.next;
        }

        if ((count & 1) == 1) {
            fast = stack.pop();
            fast = fast.next;
        }

        while (!stack.isEmpty() && fast != null) {
            if (stack.pop().data != fast.data) {
                return false;
            }
            fast = fast.next;
        }
        return true;
    }
}
