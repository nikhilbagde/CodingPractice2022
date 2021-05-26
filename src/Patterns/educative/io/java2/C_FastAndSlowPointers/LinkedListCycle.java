package Patterns.educative.io.java2.C_FastAndSlowPointers;

class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

class LinkedListCycle {

    public static boolean hasCycle(ListNode head) {
        //Error check
        if(head==null) return false;

        //Set fast and slow pointer pointing to head node
        ListNode fast = head;
        ListNode slow = head;

        //Move both pointers till 2 nodes before tail since we are going to move fast.next.next check for null.
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));
    }
}