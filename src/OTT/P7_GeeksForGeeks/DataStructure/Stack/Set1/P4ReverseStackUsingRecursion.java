package OTT.P7_GeeksForGeeks.DataStructure.Stack.Set1;

import java.util.Stack;

/**
 * Created by Nikhil on 2/24/2017 4:21 PM.
 */
public class P4ReverseStackUsingRecursion {
    /*
    only operations allowed: Stack S: isEmpty(S) push(S) pop(S)
    */
    private static void reverseAStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            reverseAStack(stack);
            insertIntoStack(stack, temp);
        }
    }

    private static void insertIntoStack(Stack<Integer> stack, int value) {
        if (stack.isEmpty()) {
            stack.push(value);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        reverseAStack(stack);
    }
}
