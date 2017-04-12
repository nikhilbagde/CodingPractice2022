package CompanyCompetetions.Amazon.Interview1;

import java.util.Stack;

/**
 * Created by Nikhil on 4/6/2017 4:04 PM.
 */
public class BalanceParenthesis {
    public static void main(String[] args) {
        String a = "{[[[]]]}";
        String b = "{[[]]]}";

        System.out.println(isBalanceParenthesis(a));
        System.out.println(isBalanceParenthesis(b));
    }

    private static boolean isBalanceParenthesis(String s) {
        String opening = "{[(";
        String closing = "}])";

        Stack<Character> stack = new Stack<>();
        char[] a = s.toCharArray();
        for (int i = 0; i < a.length; i++) {
            if (opening.indexOf(a[i]) > 0) {
                stack.push(a[i]);
            } else if (closing.indexOf(a[i]) > 0) {
                if (stack.isEmpty()) return false;
                if (opening.indexOf(stack.pop()) != closing.indexOf(a[i])) return false;
            }
        }
        return stack.isEmpty();
    }
}
