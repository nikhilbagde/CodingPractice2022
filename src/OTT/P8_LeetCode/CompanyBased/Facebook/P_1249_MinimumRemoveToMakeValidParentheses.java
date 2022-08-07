package LeetCode.CompanyBased.Facebook;

import java.util.Stack;

/**
 * @author Nikhil Bagde
 * @date 4/24/2021- 9:21 PM
 **/
public class P_1249_MinimumRemoveToMakeValidParentheses {
    public static void main(String[] args) {
    /*
    Example 1:
    Input: s = "lee(t(c)o)de)"
    Output: "lee(t(c)o)de"
    Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.

    Example 2:
    Input: s = "a)b(c)d"
    Output: "ab(c)d"

    Example 3:
    Input: s = "))(("
    Output: ""
    Explanation: An empty string is also valid.

    Example 4:
    Input: s = "(a(b(c)d)"
    Output: "a(b(c)d)"
     */
    }

    /**
     *      Idea is when letter are found directly append to the sb
     *      when opening bracket is found put the INDEX of that opening bracket - (all counts of closing brackets occurred before opening as DeleteCount) - ALSO add to sb
     *      when closing bracket is found - check if stack is not empty. if stack is not empty, means we had opening bracket index already to balance it.  - Add to sb.
     *                                                              if stack is empty meaning these are the bracket which are wrong and need to increment the deleteCounter.
     *      now, just iterate over stack till it not empty, it contains all indexed we need to remove fromt he sb. Sb.deleteCharAt(index)
     *      The reason why we are storing index and not ( . is we are actually tracking the index at which we need to delete all elements later
     */
    public static String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb  = new StringBuilder();
        int deleteCount =  0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isLetter(c)){
                sb.append(c);
            } else if ( c =='(') {
                stack.push(i - deleteCount);     // - delete count since, this will be at least 1 when we have encounter closing backer before opening (.
                sb.append(c);                                       // also even when stack is empty. meaning there are no opening brackets. by deleting this count meaning we are
            } else if ( c == ')') {                                   // keeping the actual index of those ) closing brackets which came before opening. e.g. )))(((  decCont = 3;
                if(!stack.isEmpty()){                              // so while pushing current index. (=4th) 4-3=1 we are actually removing first occurrence of )
                    stack.pop();
                    sb.append(c);
                }else {
                    deleteCount++;
                }
            }
        }
        while(!stack.isEmpty()){
            int index = stack.pop();
            sb.deleteCharAt(index);
        }
        return sb.toString();
    }
}
