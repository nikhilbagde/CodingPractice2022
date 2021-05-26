package Patterns.educative.io.java2.C_FastAndSlowPointers;

 class ListNode1 {
    int value = 0;
    ListNode1 next;

    ListNode1(int value) {
        this.value = value;
    }
}

class LinkedListCycleStart {

    public static ListNode1 findCycleStart(ListNode1 head) {
        ListNode1 fast = head, slow = head;
        boolean flag = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                flag = true;
                break;
            }
        }
        if (!flag) return null;

        int length = 0;
        do {
            fast = fast.next.next;
            slow = slow.next;
            length++;
        } while (fast != slow);

        fast = head;
        slow = head;
        for (int i = 0; i < length; i++) {
            slow = slow.next;
        }
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public static void main(String[] args) {
        ListNode1 head = new ListNode1(1);
        head.next = new ListNode1(2);
        head.next.next = new ListNode1(3);
        head.next.next.next = new ListNode1(4);
        head.next.next.next.next = new ListNode1(5);
        head.next.next.next.next.next = new ListNode1(6);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);
    }
}