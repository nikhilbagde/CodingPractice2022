package GeeksForGeeks.DataStructure.Stack.Set1;

import java.util.Stack;

/**
 * Created by Nikhil on 2/24/2017 4:42 PM.
 */
public class P7SpecialStackWithGetMin {


    public static void main(String[] args) {
        StackA<Integer> stackA = new StackA<>();
        stackA.push(-5);
        stackA.push(2);
        stackA.push(-9);
        stackA.push(10);
        stackA.push(1000);


        System.out.println(stackA.getMin());
    }

    public static class StackA<E> {
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MAX_VALUE;

        public void push(int value) {
            min = Math.min(min, value);
            stack.push(value);
        }

        public int pop(int value) {
            return stack.pop();
        }

        public int getMin() {
            return min;
        }

        public boolean isFull() {
            return stack.capacity() == stack.size();
        }

        public void print() {
            System.out.println(stack);
        }
    }

}
