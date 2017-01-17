package DataStructure.MyDataStructures.Stacks;

/**
 * Created by Nikhi on 12/14/2016 2:23 AM.
 */
public interface MyStack<E> {
    void push(E e);
    E pop();
    int size();
    boolean empty();
    E peek();

}
