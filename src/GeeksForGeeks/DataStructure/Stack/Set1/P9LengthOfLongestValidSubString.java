package GeeksForGeeks.DataStructure.Stack.Set1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Nikhil on 2/25/2017 2:19 PM.
 */
public class P9LengthOfLongestValidSubString {
    private static boolean isValidSubString(String input) {
        String opening = "{[(";
        String closing = "}])";
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        for (char bracker : input.toCharArray()) {
            if (opening.indexOf(bracker) != -1) {
                stack.push(bracker);
            } else if (closing.indexOf(bracker) != -1) {
                if (stack.isEmpty()) return false;
                char openeingBracker = stack.pop();
                if (closing.indexOf(bracker) == opening.indexOf(openeingBracker)) {
                    queue.add(openeingBracker);
                    queue.add(bracker);
                }
            }
        }
        System.out.println(queue + " Length of Longest Valid String is = " + queue.size() / 2);
        return false;
    }

    public static void main(String[] args) {
        isValidSubString("((()))");
    }
}
