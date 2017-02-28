package GeeksForGeeks.DataStructure.Stack.Set1;

import java.util.Stack;

/**
 * Created by Nikhil on 2/23/2017 8:58 PM.
 */
public class P2CheckBalanceParenthesis {
    private static boolean checkBalanceParenthesis(String input) {
        String opening = "{[(";
        String closing = "}])";

        Stack<Character> stack = new Stack<>();

        for (char letter : input.toCharArray()) {
            if (opening.indexOf(letter) != -1) {
                stack.push(letter);
            } else if (closing.indexOf(letter) != -1) {
                if (stack.isEmpty()) return false;
                if (closing.indexOf(letter) != opening.indexOf(stack.pop())) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
