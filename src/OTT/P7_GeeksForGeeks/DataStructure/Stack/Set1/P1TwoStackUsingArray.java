package OTT.P7_GeeksForGeeks.DataStructure.Stack.Set1;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Nikhil on 2/23/2017 8:38 PM.
 */
public class P1TwoStackUsingArray {
    int[] array = new int[10];
    int top1 = -1;
    int top2 = array.length;

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();           //initial capacity of stack is 10 array.

        P1TwoStackUsingArray stackUsingArray = new P1TwoStackUsingArray();
        stackUsingArray.push1(1);
        stackUsingArray.push2(2);
        stackUsingArray.print();
        stackUsingArray.push1(3);
        stackUsingArray.push2(4);
        stackUsingArray.print();
        stackUsingArray.push1(5);
        stackUsingArray.push2(6);
        stackUsingArray.print();
        stackUsingArray.push1(7);
        stackUsingArray.push2(8);
        stackUsingArray.print();
        stackUsingArray.push1(9);
        stackUsingArray.push2(10);
        stackUsingArray.print();
        /*stackUsingArray.push1(11);
        stackUsingArray.push2(12);
        stackUsingArray.print();*/

        stackUsingArray.pop1();
        stackUsingArray.print();

        stackUsingArray.pop2();
        stackUsingArray.print();

        stackUsingArray.pop1();
        stackUsingArray.print();

        stackUsingArray.pop2();
        stackUsingArray.print();


        stackUsingArray.pop1();
        stackUsingArray.print();

        stackUsingArray.pop2();
        stackUsingArray.print();

        stackUsingArray.pop1();
        stackUsingArray.print();

        stackUsingArray.pop2();
        stackUsingArray.print();

        stackUsingArray.pop1();
        stackUsingArray.print();

        stackUsingArray.pop2();
        stackUsingArray.print();

        stackUsingArray.pop1();
        stackUsingArray.print();

        stackUsingArray.pop2();
        stackUsingArray.print();
    }

    private void push1(int x) {
        if (top1 >= top2) {
            throw new StackOverflowError();
        }
        array[++top1] = x;
    }

    private void push2(int x) {
        if (top2 <= top1) throw new StackOverflowError();
        array[--top2] = x;
    }

    private int pop1() {
        if (top1 == -1) throw new StackOverflowError();
        int x = array[top1];
        array[top1] = 0;
        top1--;
        System.out.println(x + " Removed");
        return x;
    }

    private int pop2() {
        if (top2 == array.length) throw new StackOverflowError();
        int temp = array[top2];
        array[top2] = 0;
        top2++;
        System.out.println(temp + " Removed");
        return temp;
    }

    private void print() {
        System.out.println(Arrays.toString(array));
    }

}
