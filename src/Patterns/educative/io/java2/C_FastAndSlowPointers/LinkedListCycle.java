package Patterns.educative.io.java2.C_FastAndSlowPointers;

class ListNode {
    int value = 0;
    ListNode1 next;

    ListNode(int value) {
        this.value = value;
    }
}

class LinkedListCycle {

    public static boolean hasCycle(ListNode1 head) {
        // TODO: Write your code here
        ListNode1 fast = head;
        ListNode1 slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode1 head = new ListNode1(1);
        head.next = new ListNode1(2);
        head.next.next = new ListNode1(3);
        head.next.next.next = new ListNode1(4);
        head.next.next.next.next = new ListNode1(5);
        head.next.next.next.next.next = new ListNode1(6);
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));
    }
}