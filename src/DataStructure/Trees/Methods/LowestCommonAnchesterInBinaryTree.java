package DataStructure.Trees.Methods;

/**
 * Created by Nikhil on 1/14/2017 9:20 PM.
 */
public class LowestCommonAnchesterInBinaryTree {
    private static Node lcaBinaryTree(Node root, Node n1, Node n2){
        if(root == null){
            return null;
        }
        if(root == n1 || root == n2){
            return root;
        }

        Node left = lcaBinaryTree(root.left, n1,n2);
        Node right = lcaBinaryTree(root.right, n1,n2);

        if(left != null && right != null){      //Case 1: go up the ladder when found (both not null)
            return root;
        }
        if(left == null && right == null){      //Case 2: both null return null (not found)
            return null;
        }
        return left == null ? left : right;     //Case 3: if one of left or right is null and match other one.
    }
}
