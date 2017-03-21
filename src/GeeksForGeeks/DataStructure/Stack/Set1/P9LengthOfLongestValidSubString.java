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

        for (char bracket : input.toCharArray()) {
            if (opening.indexOf(bracket) != -1) {
                stack.push(bracket);
            } else if (closing.indexOf(bracket) != -1) {
                if (stack.isEmpty()) return false;
                char openingBracket = stack.pop();
                if (closing.indexOf(bracket) == opening.indexOf(openingBracket)) {
                    queue.add(openingBracket);
                    queue.add(bracket);
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
