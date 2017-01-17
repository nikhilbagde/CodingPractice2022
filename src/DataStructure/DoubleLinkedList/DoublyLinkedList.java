package DataStructure.DoubleLinkedList;

/**
 * Created by Nikhil on 8/17/2016.
 */
public class DoublyLinkedList {
    DLLNode head, tail;


    public static void main(String[] args) {
        DoublyLinkedList list1 = new DoublyLinkedList();

        System.out.println("Before Adding 5");
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(6);
        list1.add(7);

        int[] array = new int[10];

        list1.printList();
        System.out.println("After Adding 5");
        list1.SortedInsert(list1.head , 8);

        list1.printList();


        DoublyLinkedList list2 = new DoublyLinkedList();
        list2.SortedInsert(list2.head, 2);
        list2.printList();

    }
    DLLNode SortedInsert(DLLNode head, int data) {
        if(head==null){
            DLLNode temp = new DLLNode(data);
            this.head = temp;
            return head;
        }else{
            DLLNode temp = this.head;
            DLLNode prev = null;
            while(temp!=null && !(data<=temp.data)){
                prev = temp;
                temp = temp.next;
            }
            DLLNode newNode = new DLLNode(data);
            newNode.next = temp;
            newNode.prev = prev;

            prev.next = newNode;
            temp.prev = newNode;
            return head;

        }

    }
    public void add(int data){
        if(head == null){
            DLLNode node = new DLLNode(data);
            head = node;
        }else{
            DLLNode node = new DLLNode(data);
            DLLNode temp = head;
            while (temp.next!=null){
                temp = temp.next;
            }
            temp.next = node;
            node.prev = temp;
        }
    }
    public void printList(){

        DLLNode node = head;
        while(node!=null){
            System.out.print(node.data + "->");
            node = node.next;
        }
        System.out.println("NULL");
    }

}
