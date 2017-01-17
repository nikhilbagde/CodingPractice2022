package DataStructure.MyDataStructures.Queue;

/**
 * Created by Nikhi on 12/14/2016 6:48 AM.
 */
public class Client {
    public static void main(String[] args) {
        MyArrayQueue<Integer> queue = new MyArrayQueue<>(10);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println(queue.toString());
        System.out.println("Removing: ... "+ queue.remove());
        System.out.println(queue.toString());
        System.out.println("Adding 1..." );
        queue.enqueue(1);
        System.out.println(queue.toString());
        System.out.println("Removing 3 elements: ... "+ queue.remove()+ queue.remove()+ queue.remove());
        System.out.println(queue.toString());
    }
}
