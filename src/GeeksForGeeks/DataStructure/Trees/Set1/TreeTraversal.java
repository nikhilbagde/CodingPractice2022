package GeeksForGeeks.DataStructure.Trees.Set1;

import GeeksForGeeks.DataStructure.Trees.BinaryTree;
import GeeksForGeeks.DataStructure.Trees.TreeNode;

/**
 * Created by Nikhi on 12/10/2016 7:54 PM.
 */
public class TreeTraversal {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(5);                        //    5
        tree.insert(1);                       //  /     \
        tree.insert(10);                    //  1         10
        tree.insert(2);                    //  / \        / \
        tree.insert(8);                   //      2      8
        tree.insert(4);                  //        \    /
        tree.insert(6);                 //          4  6

        System.out.println("PreOrder");
        preOrder(tree);
        System.out.println("InOrder");
        inOrder(tree);
        System.out.println("PostOrder");
        postOrder(tree);

        System.out.println("Size of Tree: " + tree.getSize());
        System.out.println("Height of Tree: " + tree.getHeight());

        //LevelWise Traversal
        BinaryTree tree1 = new BinaryTree();
        tree1.insert(6);                        //      6
        tree1.insert(3);                       //    /     \
        tree1.insert(10);                    //   3           10
        tree1.insert(2);                    //  / \         /   \
        tree1.insert(4);                   //  2    4      8    12
        tree1.insert(8);                  //  /      \    / \   /  \
        tree1.insert(12);                 // 1        5  7   9 11  13
        tree1.insert(1);        tree1.insert(5);        tree1.insert(7);        tree1.insert(9);
        tree1.insert(11);        tree1.insert(13);

        System.out.println("Tree 2 : InOrder : ");
        tree1.inOrder();
        for (int i = 0; i < tree1.getHeight(); i++) {
            tree1.printLevelWise(i+1);
        }
        System.out.println("Find Max K element from level L");
        tree1.getMaxKAtLevelL(4, 3 );

        BinaryTree tree2 = ConstructBST.constructBinarySearchTree();
        tree2.inOrder();

    }
    public static void preOrder(BinaryTree tree){
        preOrder(tree.getRoot());
    }
    private static void preOrder(TreeNode root){
        if(root == null){
            return;
        }else{
            //when its root, add < root.value >
            if(root.value == root.value){
                System.out.println("<"+root.value+">");
            }else{
                System.out.println(root.value);
            }
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    private static void inOrder(BinaryTree tree){
        inOrder(tree.getRoot());
    }
    private static void inOrder(TreeNode root){
        if(root == null){
            return;
        }else{
            inOrder(root.left);
            //when its root, add < root.value >
            if(root.value == root.value){
                System.out.println("<"+root.value+">");
            }else{
                System.out.println(root.value);
            }

            inOrder(root.right);
        }
    }
    static void postOrder(BinaryTree tree){
        postOrder(tree.getRoot());
    }
    private static  void postOrder(TreeNode root){
        if(root == null){
            return;
        }else{
            postOrder(root.left);
            postOrder(root.right);
            //when its root, add < root.value >
            if(root.value == root.value){
                System.out.println("<"+root.value+">");
            }else{
                System.out.println(root.value);
            }

        }
    }

    /**
     * Created by Nikhil on 1/18/2017 11:56 AM.
     */
    public static class ChildrenSumProperty {
        private static boolean isChilderSum(TreeNode root){
            if(root==null || (root.left==null && root.right==null) ) return true;   //root null or leaf node

            int leftValue = 0, rightValue = 0;
            if(root.left!=null) leftValue = root.left.value;
            if(root.right!=null) rightValue = root.right.value;

            //if(root.left!=null && root.right!=null) return (root.value == root.left.value+ root.right.value);
            return (root.value == leftValue+rightValue) &&  (isChilderSum(root.left) && isChilderSum(root.right));
        }

        public static void main(String[] args) {
            BinaryTree tree = new BinaryTree();
            tree.setRoot(new TreeNode(10));                                         //10
            tree.getRoot().left = new TreeNode(8);                              //8       2
            tree.getRoot().right = new TreeNode(2);                         //3      5      2
            tree.getRoot().left.left = new TreeNode(3);
            tree.getRoot().left.right = new TreeNode(5);
            tree.getRoot().right.right = new TreeNode(2);
            boolean result = isChilderSum(tree.getRoot());
            System.out.println(result);
        }
    }
}