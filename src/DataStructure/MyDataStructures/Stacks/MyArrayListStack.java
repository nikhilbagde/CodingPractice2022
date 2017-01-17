package DataStructure.MyDataStructures.Stacks;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikhi on 12/14/2016 7:06 AM.
 */
public class MyArrayListStack<E> implements MyStack<E> {
    private List<E> list;
    MyArrayListStack(){
        list = new ArrayList<>();
    }
    MyArrayListStack(int size){
        list = new ArrayList<>(size);
    }

    @Override
    public void push(E e) {
        list.add(e);
    }

    @Override
    public E pop() {
        return list.remove(list.size()-1);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean empty() {
        return list.isEmpty();
    }

    @Override
    public E peek() {
        return list.get(list.size()-1);
    }

    @Override
    public String toString() {
        return "MyArrayListStack{" +
                "list=" + list +
                '}';
    }
}
