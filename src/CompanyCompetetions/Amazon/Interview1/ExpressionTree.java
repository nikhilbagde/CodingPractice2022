package CompanyCompetetions.Amazon.Interview1;

import java.util.Stack;

/**
 * Created by Nikhil on 4/6/2017 4:59 PM.
 */
public class ExpressionTree {
    //given postfix expression convert it into tree.

    public static void main(String[] args) {
        String postFix = "23+45*6*-";
        createExpressionTree(postFix.toCharArray());
    }

    private static void createExpressionTree(char[] postFix) {
        Stack<Node> stack = new Stack<>();
        for (int i = 0; i < postFix.length; i++) {
            if (!isOperator(postFix[i])) {
                stack.push(new Node(postFix[i]));
            } else {
                Node t = new Node(postFix[i]);
                t.left = stack.pop();
                t.right = stack.pop();
                stack.push(t);
            }
        }

        //finally there would be root in the stack.
        System.out.println(stack.peek());

        //using this root now we can travel tree in PostOrder, PreOrder or InOrder.
        System.out.println("InOrder");
        inOrder(stack.peek());
        System.out.println("preOrder");
        preOrder(stack.peek());
        System.out.println("PostOrder");
        postOrder(stack.peek());
    }

    private static void inOrder(Node root) {
        if (root == null) return;
        else {
            inOrder(root.left);
            System.out.println(root.value);
            inOrder(root.right);
        }
    }

    private static void preOrder(Node root) {
        if (root == null) return;
        else {
            System.out.println(root.value);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    private static void postOrder(Node root) {
        if (root == null) return;
        else {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.value);
        }
    }

    private static boolean isOperator(char a) {
        return a == '*' || a == '/' || a == '+' || a == '-' || a == '^';
    }

    static class Node {
        char value;
        Node left;
        Node right;

        public Node(char v) {
            value = v;
            left = right = null;
        }
    }

}
