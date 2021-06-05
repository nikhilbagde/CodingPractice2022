package Patterns.educative.io.java1;

/**
 * @author Nikhil Bagde
 * @date 6/3/2021- 9:32 PM
 **/
public class R_Misc {
    static public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {        // T: O(Max(m, n))
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        int carry = 0;
        while(l1!=null || l2!=null){
            int sum = carry;
            if(l1!=null){
                sum+= l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum+= l2.val;
                l2=l2.next;
            }

            curr.next = new ListNode(sum%10);   //%10 will give unit place no.
            curr = curr.next;
            carry = sum/10;                                             //  /10 will give carry
        }
        if(carry!=0){
            curr = new ListNode(carry);
        }
        return dummy.next;
    }
}
