package Patterns.educative.io.java2.C_FastAndSlowPointers;

class ListNode4 {
    int value = 0;
    ListNode4 next;

    ListNode4(int value) {
        this.value = value;
    }
}

class RearrangeList {

    public static void reorder(ListNode4 head) {
        // TODO: Write your code here
        ListNode4 fast = head, slow = head;
        int len = 0;
        while (fast != null && fast.next != null) {
            len += 2;
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast == null) len--;
        ListNode4 copy = head;
        ListNode4 reverseHalf = reverse(slow);
        int count = 0;
        while (count < len/2) {
            count++;
            ListNode4 temp = head.next;
            head.next = reverseHalf;
            reverseHalf = reverseHalf.next;
            head = head.next;
            head.next = temp;
            head = head.next;
        }
        head = copy;
        return;
    }

    private static ListNode4 reverse(ListNode4 head) {
        ListNode4 prev = null;
        ListNode4 curr = head;
        while (curr != null) {
            ListNode4 next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode4 head = new ListNode4(2);
        head.next = new ListNode4(4);
        head.next.next = new ListNode4(6);
        head.next.next.next = new ListNode4(8);
        head.next.next.next.next = new ListNode4(10);
        head.next.next.next.next.next = new ListNode4(12);
        RearrangeList.reorder(head);
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
}