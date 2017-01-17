package DataStructure.Trees.Methods;

/**
 * Created by Nikhil on 1/12/2017 3:30 AM..
 *
 */
public class MirrorTree {
    static Node mirror(Node node){
        if( node == null){
            return node;
        }
        Node left = mirror(node.left);
        Node right = mirror(node.right);

        node.left = right;
        node.right = left;

        return node;
    }
    private static void inOrder(Node root){
        if(root!=null){
            inOrder(root.left);
            System.out.println(root.data + " ");
            inOrder(root.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        /* print inorder traversal of the input tree */
        System.out.println("Inorder traversal of input tree is :");
        inOrder(tree.root);
        System.out.println("");

        /* convert tree to its mirror */
        mirror(tree.root);

        /* print inorder traversal of the minor tree */
        System.out.println("Inorder traversal of binary tree is : ");
        inOrder(tree.root);
    }
}
