package CompanyCompetetions.IPSoft;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by Nikhi on 11/11/2016.
 */
public class EvenLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    }
    static LinkedListNode deleteEven(LinkedListNode list) {

        LinkedListNode current=list;
        while(current.val%2==0){
            current=current.next;
        }
        list=current;
        while(current.next!=null){
            //Check if current -> Next node has even value
            // And not the current.val should be checked with even number value.
            if(current.next.val%2==0){
                current.next=current.next.next;
            }else{
                current=current.next;
            }
        }
        return list;
    }
}
class LinkedListNode{
    int val;
    LinkedListNode next = null;
}
        /*PriorityQueue<Integer> pq=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1>o2){
                    return -1;
                }else if(o1<o2){
                    return 1;
                }
                return 0;
            }
        });

        pq.add(3);
        pq.add(5);
        pq.add(7);
        System.out.println(pq.peek());*/


        /*
 * Complete the function below.
 */
/*
For your reference:
LinkedListNode {
    int val;
    LinkedListNode *next;
};
*/



