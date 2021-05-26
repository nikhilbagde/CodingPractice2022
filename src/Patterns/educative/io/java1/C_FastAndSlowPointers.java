package Patterns.educative.io.java1;


/**
 * Pattern: Fast & Slow pointers (7)
 * LinkedList Cycle (easy): LC 141
 * Start of LinkedList Cycle (medium): LC 142
 * Happy Number (medium): LC 202
 * Middle of the LinkedList (easy): LC 876
 * Problem Challenge 1: LC 234
 * Problem Challenge 2: LC 143
 * Problem Challenge 3: LC 457
 */

class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

public class C_FastAndSlowPointers {
    public static boolean hasCycle(ListNode head) {
        //Error check
        if(head==null) return false;

        //Set fast and slow pointer pointing to head node
        ListNode fast = head;
        ListNode slow = head;

        //Move both pointers till  nodes before tail since we are going to move fast.next check for null.
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow) return true;
        }
        return false;
    }

    public static ListNode findCycleStart(ListNode head) {
        if(head==null) return head;

        ListNode fast = head;
        ListNode slow = head;
        boolean flag = false;
        // 3  -> 2  -> 0 -> -4 -> 2
        //There will be point when fast will be equal to slow i there is a cycle.
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                flag = true;
                break;
            }
        }
        if (!flag) return null;

        //Following logic is to take notice of length of the cycle
        // we will drive same loop but till fast!=slow. As soon as they are equal we have length
        /*int length = 0;
        do {
            fast = fast.next.next;
            slow = slow.next;
            length++;
        } while (fast != slow);

        // set first pointer to start (HEAD)
        // and second pointer to length of the cycle.
        // As second pointer will keep moving size of cycle, we are moving fast (first) pointer in same length.
        // hence we should be able to find the node from start where cycle starts/ends

        fast = head;
        slow = head;
        for (int i = 0; i < length; i++) {
            slow = slow.next;
        }*/

        //without all above we can simple move fast pointer to head
        fast = head;
        // as slow is already pointing to same node we met previously.
        // if we keep moving till both meets is same node where cycle starts/ends
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public static void main(String[] args) {

        //has cycle
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println("LinkedList has cycle: " + hasCycle(head));

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList has cycle: " + hasCycle(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList has cycle: " + hasCycle(head));
        
        
        // find cycle node
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(6);

        head1.next.next.next.next.next.next = head1.next.next;
        System.out.println("LinkedList cycle start: " + C_FastAndSlowPointers.findCycleStart(head1).value);

        head1.next.next.next.next.next.next = head1.next.next.next;
        System.out.println("LinkedList cycle start: " + C_FastAndSlowPointers.findCycleStart(head1).value);

        head1.next.next.next.next.next.next = head1;
        System.out.println("LinkedList cycle start: " + C_FastAndSlowPointers.findCycleStart(head1).value);

        //
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(3);
        head2.next.next.next.next = new ListNode(2);
        head2.next.next.next.next.next = new ListNode(1);

        System.out.println("LinkedList cycle start: " + C_FastAndSlowPointers.isPalindrome2(head2));
        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(2);
        head3.next.next = new ListNode(3);
        head3.next.next.next = new ListNode(4);
        head3.next.next.next.next = new ListNode(3);
        head3.next.next.next.next.next = new ListNode(2);
        head3.next.next.next.next.next.next = new ListNode(1);
        System.out.println("LinkedList cycle start: " + C_FastAndSlowPointers.isPalindrome2(head3));
    }

    public static boolean happyNumber(int num) {
        int fast = num, slow = num;
        do {
            fast = getNext(getNext(fast));          //call twice
            slow = getNext(slow);                                   // call onces
        } while (fast != slow);
        return fast == 1;
    }

    private static int getNext(int num) {
        int sum = 0;
        int i;
        while (num > 0) {               // do till number becomes zero    4/10=0 after processing 4 as unit place.
            i = num % 10;               // take the unit place number
            sum += i*i;                    // square it and store it in local sum variable
            num /= 10;                     // divide number by 10 to eliminate the unit place number
        }
        return sum;     //sum would be squares of all unit place numbers.
    }

    public static ListNode findMiddle(ListNode head) {
        if(head==null) return head;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode reverseHalf = reverse(slow);
        ListNode rightHead = reverseHalf;
        while (rightHead != null) {
            if (rightHead.value != head.value) break;
            rightHead = rightHead.next;
            head = head.next;
        }

        reverse(reverseHalf);
        if (rightHead != null) return false;
        return true;
    }


    private static ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static boolean isPalindrome2(ListNode head) {
        //check for edge cases
        if (head == null || head.next == null) return true;

        //Bring out slow at mid
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //Reverse the list at mid
        // 1 2 3 4 3 2 1   VS  1 2 3 3 2 1
        //Trick, if fast is null that means list if of even size
        // if fast is NOT null that means of odd size

        ListNode reverseHalfHead = reverse(slow);  //slow location: 1 2 3 (3) 2 1  and 1 2 3 (4) 3 2 1

        printList(head);
        printList(reverseHalfHead);

        ListNode rightH = reverseHalfHead;
        ListNode leftH = head;
        //check rightH pointer and go next for both left and right Head.
        while (rightH != null) {            // in case of even list, anyways rightH will be shorted and in case of odd list, both leftR and rightR will be at equal distance
            if (rightH.value != leftH.value) break;
            rightH = rightH.next;
            leftH = leftH.next;
        }

        //restore original list
        ListNode originalMid = reverse(reverseHalfHead);
        printList(originalMid);

        System.out.println("Original List");
        printList(head);

        // since right would be come to null first as in case of even size, rightH would be smaller,
        // and also in case of odd list, rightH and leftH both will come to null at same time.
        if (rightH != null) return false;
        return true;
    }
    static void printList(ListNode head){
        ListNode cur = head;
        while(cur!=null){
            System.out.print(cur.value + " -> " );
            cur = cur.next;
        }
        System.out.println(" NULL ");

    }
}
