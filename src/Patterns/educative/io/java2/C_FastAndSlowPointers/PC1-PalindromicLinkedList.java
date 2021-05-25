package Patterns.educative.io.java2.C_FastAndSlowPointers;

class ListNode3 {
    int value = 0;
    ListNode3 next;

    ListNode3(int value) {
        this.value = value;
    }
}

class PalindromicLinkedList {

    public static boolean isPalindrome(ListNode3 head) {
        // TODO: Write your code here
        if (head == null || head.next == null) return true;
        ListNode3 fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode3 reverseHalf = reverse(slow);
        ListNode3 copy = reverseHalf;
        while (copy != null) {
            if (copy.value != head.value) break;
            copy = copy.next;
            head = head.next;
        }

        reverse(reverseHalf);
        if (copy != null) return false;
        return true;
    }

    private static ListNode3 reverse(ListNode3 head) {
        ListNode3 curr = head;
        ListNode3 prev = null;
        while (curr != null) {
            ListNode3 next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode3 head = new ListNode3(2);
        head.next = new ListNode3(4);
        head.next.next = new ListNode3(6);
        head.next.next.next = new ListNode3(4);
        head.next.next.next.next = new ListNode3(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

        head.next.next.next.next.next = new ListNode3(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
    }
}