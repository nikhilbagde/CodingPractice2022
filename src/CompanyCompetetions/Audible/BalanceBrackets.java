package CompanyCompetetions.Audible;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Nikhi on 12/1/2016.
 */
public class BalanceBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] array = new String[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.next();

        }
        braces(array);
    }
    //{[}]}
        static String[] braces(String[] values) {
            String[] result  = new String[values.length];
            for (int i = 0; i < values.length; i++) {
                if(checkMatchingParenthesis(values[i].toCharArray())){
                    result[i] = "YES";
                }else {
                    result[i] = "NO";
                }
            }
            return values;

        }

        public static boolean checkMatchingParenthesis(char[] stream){
            Stack<Character> stack = new Stack<>();
            for (char c: stream) {
                if(checkOpeningBracket(c)){
                    stack.push(c);
                }else if(checkClosingBracket(c)){
                    if(stack.isEmpty()){
                        return false;
                    }else{
                        //I can eliminate creating these two character and compare inplace.
                        //But for understanding.
                        char leftBracket = stack.pop();
                        char rightBracker = c;
                        if(!checkPair(leftBracket,rightBracker)){
                            return false;
                        }
                    }
                }
            }
            return true;
        }
        public static boolean checkOpeningBracket(char c){
            return (c == '{' || c == '[' || c == '(');
        }
        public static boolean checkClosingBracket(char c){
            return (c == '}' || c == ']' || c == ')');
        }
        public static boolean checkPair(char left, char right){
            return (left == '(' && right == ')'
                    || left == '{' && right == '}'
                    || left == '[' && right == ']');
        }
}
