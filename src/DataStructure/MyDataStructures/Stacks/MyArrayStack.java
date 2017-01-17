package DataStructure.MyDataStructures.Stacks;

import java.util.Arrays;

/**
 * Created by Nikhi on 12/14/2016 2:26 AM.
 */
public class MyArrayStack<E> implements MyStack<E> {
    private static final int CAPACITY = 1000;
    private E[] data;
    private int t;

    MyArrayStack(){
        this(CAPACITY);
    }
    MyArrayStack(int capacity){
        data = (E[]) new Object[capacity];
        t = -1;
    }

    @Override
    public int size() {
        return (t+1);
    }

    @Override
    public boolean empty() {
        return (t == -1);
    }

    @Override
    public void push(E e) {
        if(size() == data.length) throw new IllegalStateException("MyStack is Full");
        data[++t] = e;
    }

    @Override
    public E pop() {
        if(t == -1) return null;
        E value = data[t];
        data[t] = null;
        t--;
        return value;
    }


    @Override
    public E peek() {
        if(t == -1) {
            System.out.println("Empty!");
            return null;
        }
        return data[t];
    }

    /*
        Bracket Matching function for stack
     */
    public static boolean hasMatchingBrackets(String expression){
        final String opening = "{[(";
        final String closing = "}])";
        MyStack<Character> myStack = new MyArrayStack<>(expression.length());

        for (char c : expression.toCharArray()) {
            if(opening.indexOf(c)!=-1){
                myStack.push(c);
            }else if(closing.indexOf(c)!= -1){
                if(myStack.empty()){
                    return false;
                }
                if (closing.indexOf(c)!= opening.indexOf(myStack.pop())){
                    return false;
                }
            }
        }
        return myStack.empty();
    }
    static boolean matchHTMLTags(String html){
        MyStack<String> myStack = new MyArrayStack<>();   //notice default length of 1000. (Drawback)
        int start = html.indexOf('<');              //get first index of '<' character if any
        while(start!=-1){
            int end = html.indexOf('>', start+1); //find '>' after '<'
            if(end == -1) return false;           //clearly not balanced.

            String tagName = html.substring(start+1, end);      //e.g.body

            if(!tagName.startsWith("/")){           //meaning its a start Tag. Push
                myStack.push(tagName);
            }else{  //meaning it is a end tag with /at start.
                if(myStack.empty()) return false;     //before me find match myStack is empty. Not balanced.

                if(!tagName.substring(1).equals(myStack.pop())){  //get tagName of end without '/' hence subString(1)
                    return false;
                }
            }
            start = html.indexOf('<', end+1);
        }
        return myStack.empty();
    }

    public static MyArrayStack transfer(MyArrayStack S, MyArrayStack T){
        if(S.size()!= T.size()){
            System.out.println("Cant Transfer: Different Size");
        }
        while(S.size()>0){
            T.push(S.pop());
        }
        return T;

    }

    void removeAll(){
        removeAll(this);
    }
    private static MyArrayStack removeAll(MyArrayStack stack){
        if(stack.size() != 0){
            stack.pop();
            removeAll(stack);
        }
        return stack;
    }
    @Override
    public String toString() {
        return "MyArrayStack{" +
                "data=" + Arrays.toString(data) +
                ", t=" + t +
                '}';
    }
}