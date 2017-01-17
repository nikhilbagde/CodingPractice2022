package DataStructure.MyDataStructures.Queue;

/**
 * Created by Nikhi on 12/14/2016 5:01 AM.
 */
public interface MyQueue<E> {
    //update methods
    void enqueue(E e);
    E dequeue();

    //Accessor Methods
    E first();
    int size();
    boolean isEmpty();

    //
    boolean offer(E e);
    E poll();
}
