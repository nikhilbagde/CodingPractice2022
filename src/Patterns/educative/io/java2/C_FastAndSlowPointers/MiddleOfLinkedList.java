package Patterns.educative.io.java2.C_FastAndSlowPointers;

class ListNode2 {
    int value = 0;
    ListNode2 next;

    ListNode2(int value) {
        this.value = value;
    }
}

class MiddleOfLinkedList {

    public static ListNode2 findMiddle(ListNode2 head) {
        // TODO: Write your code here
        ListNode2 fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode2 head = new ListNode2(1);
        head.next = new ListNode2(2);
        head.next.next = new ListNode2(3);
        head.next.next.next = new ListNode2(4);
        head.next.next.next.next = new ListNode2(5);
        System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);

        head.next.next.next.next.next = new ListNode2(6);
        System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);

        head.next.next.next.next.next.next = new ListNode2(7);
        System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);
    }
}