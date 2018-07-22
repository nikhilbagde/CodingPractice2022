package LeetCode.Easy;

/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4 -> 9)
Output: 7 -> 0 -> 8 -> 9
Explanation: 342 + 9465 = 9807.
 */
public class P2AddTwpoNumbers {

    public static void main(String[] args) {
        ListNode a = new ListNode(2);
        a.next = new ListNode(3);
        a.next.next = new ListNode(4);

        ListNode b = new ListNode(5);
        b.next = new ListNode(6);
        b.next.next = new ListNode(4);
        b.next.next.next = new ListNode(9);

        ListNode c = addTwoNumbers(a, b);

        printList(c);
    }

    public static ListNode addTwoNumbers(ListNode a, ListNode b) {
        ListNode aa = a;
        ListNode bb = b;
        ListNode result = new ListNode(0);
        ListNode temp = result;
        int carry = 0;
        while (aa != null || bb != null) {

            int sum = (aa == null ? 0 : aa.value) + (bb == null ? 0 : bb.value) + carry;
            sum = sum % 10;
            carry = sum / 10;

            temp.next = new ListNode(sum);
            temp = temp.next;
            aa = aa != null ? aa.next : aa;
            bb = bb != null ? bb.next : bb;
        }

        if (carry > 0) {
            temp.next = new ListNode(carry);
        }
        return result.next;     //because we started from 0 as dummay node.

    }

    public static void printList(ListNode c) {
        ListNode temp = c;
        while (temp != null) {
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.print("null");
    }


}


