package CompanyCompetetions.Indeed.Questions;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Nikhi on 12/19/2016 7:00 PM.
 */
public class Question3 {

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < n; i++) {

            String operation = sc.nextLine();
            if(operation.contains("push")) {
                String[] array = operation.split(" ");
                stack.push(Integer.parseInt(array[1]));
                System.out.println(stack.isEmpty() ? "EMPTY" : stack.peek());
            }else if(operation.contains("pop")) {
                if(!stack.isEmpty())
                    stack.pop();
                System.out.println(stack.isEmpty() ? "EMPTY" : stack.peek());
            }else if(operation.contains("inc")){
                String[] array = operation.split(" ");
                int rank = Integer.parseInt(array[1]);
                int numeberToAdd = Integer.parseInt(array[2]);
                Stack<Integer> tmp = new Stack<Integer>();
                for(int j = 0; j < rank; j++) {
                    if(!stack.isEmpty()) {
                        tmp.add(stack.peek());
                        stack.pop();
                    }
                }
                for(int j = 0; j < rank; j++) {
                    if(!tmp.isEmpty()) {
                        stack.add(tmp.peek() + numeberToAdd);
                        tmp.pop();
                    }
                }

                System.out.println(stack.isEmpty() ? "EMPTY" : stack.peek());
            }
        }




    }

    /*public static void main(String args[] ) throws Exception {
        /// Enter your code here. Read input from STDIN. Print output to STDOUT
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            MyArrayStack stack = new MyArrayStack();
            String operation = sc.next();
            if(operation.contains("push")){
                String[] array = operation.split("\\s+");
                stack.push(array[1]);
                System.out.println(stack.peek() == null ? "EMPTY" : stack.peek());
            }else if(operation.contains("pop")){
                String[] array = operation.split("\\s+");
                stack.pop();
                System.out.println(stack.peek() == null ? "EMPTY" : stack.peek());
            }else if(operation.contains("inc")){
                String[] array = operation.split("\\s+");
                int rank = Integer.parseInt(array[1]);
                int numeberToAdd = Integer.parseInt(array[2]);
                stack.changeBottom(rank, numeberToAdd);
                System.out.println(stack.peek() == null ? "EMPTY" : stack.peek());
            }
        }




    }*/
}
/*class MyArrayStack {
    private static final int CAPACITY = 1000;
    private int[] data;
    private int t;

    MyArrayStack(){
        this(CAPACITY);
    }
    MyArrayStack(int capacity){
        data = new int[capacity];
        t = -1;
    }


    public int size() {
        return (t+1);
    }

    public boolean empty() {
        return (t == -1);
    }

    public void push(int e) {
        if(size() == data.length) throw new IllegalStateException("MyStack is Full");
        data[++t] = e;
    }

    public int pop() {
        if(t == -1) return -1;
        int value = data[t];
        data[t] = null;
        t--;
        return value;
    }


    public E peek() {
        if(t == -1) {
            System.out.println("Empty!");
            return null;
        }
        return data[t];
    }

    public void changeBottom(int rank, int number){
        for (int i = data.length-1; i > rank; i--) {
            data[i] = data[i] + (int) number;
        }

    }*/
//}