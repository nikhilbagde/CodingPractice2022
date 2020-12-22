package Books.CrackingTheCodingInterview.Chapter4TreeGraph;

/**
 * Created by Nikhil on 2/15/2017 12:54 AM.
 * Successor: Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a
 * binary search tree. You may assume that each node has a link to its parent.
 * Hints:
 * #79, - Think how inOrder traversal work and reverse engineer it.
 * #91  - Here's one step of the logic: The successor of a specific node is the leftmost node of the
 * right subtree. What if there is no right subtree, though?
 */
public class P6Successor {

    TreeNodeWithP inorderSucc(TreeNodeWithP node) {
        if (node == null) return null;

        if (node.right != null) {
            return leftMostNode(node.right);
        } else {
            TreeNodeWithP temp = node;
            TreeNodeWithP parent = temp.parent;
            while (parent != null && parent.left != temp) {
                temp = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }

    TreeNodeWithP leftMostNode(TreeNodeWithP node) {
        if (node == null) return null;

        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

}

class TreeNodeWithP {
    int value;
    TreeNodeWithP left;
    TreeNodeWithP right;
    TreeNodeWithP parent;

    TreeNodeWithP(int value) {
        this.value = value;
        left = right = parent = null;
    }
}
