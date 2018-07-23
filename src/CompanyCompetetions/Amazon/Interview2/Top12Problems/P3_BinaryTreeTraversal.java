package CompanyCompetetions.Amazon.Interview2.Top12Problems;

/**
 * Created by nbagde on 7/23/2018.
 */
public class P3_BinaryTreeTraversal {

    //Inner static class
    public static class TreeNode{
        public int value;
        public TreeNode left, right, parent;
        TreeNode(int value){
            this.value = value;
            left = right = parent = null;
        }
    }

    //Member Variables.
    TreeNode root;

    //Constructor
    public P3_BinaryTreeTraversal(){
        root = null;
    }
    P3_BinaryTreeTraversal(int value){
        root = new TreeNode(value);
    }

    public TreeNode getRoot(){
        return root;
    }
    /*
    If root is null create first node as root
    if root already there, insert recursively.
     */
    public void insert(int value){
        if(root==null){
            root = new TreeNode(value);
        }else {
            root = insertRec(root, value);
        }
    }
    private TreeNode insertRec(TreeNode root, int value){
        //Insert to left
        if(value < root.value){
            root.left = (root.left ==null) ? new TreeNode(value) : insertRec(root.left, value);
        }else if(value>root.value){
            root.right = (root.right==null) ? new TreeNode(value) : insertRec(root.right, value);
        }else{
            System.out.println("Duplicate can not be inserted!");
        }
        return root;
    }

    //TRAVERSAL
    //TOP VIEW
    //                       5
    //           /                       \
    //          2                       7
    //      /        \              /       \
    //    1          3           6         8
    // OUTPUT: 1 2 5 7 8

    public void topView(TreeNode root){
        //First go to the left and left most node then when reach to null then start printing.
        if(root.left!=null){
            goLeft(root.left);
        }
        //Then print root
        System.out.println(root.value);
        //Then keep printing Right first then move to right most node.
        if(root.right!=null){
            goRight(root.right);
        }
    }
    private void goLeft(TreeNode  node){
        if(node.left!=null)
            goLeft(node.left);
        //when Node.left == null meaning left most
        System.out.println(node.value);
    }
    private void goRight(TreeNode node){
        //first print then go deep
        System.out.println(node.value);
        if(node.right!=null)
            goRight(node.right);
    }

    public static void main(String[] args) {
        int [] a = {5,2,7,1,3,6,8};
        P3_BinaryTreeTraversal binaryTree = new P3_BinaryTreeTraversal();
        for (Integer  i: a ) {
            binaryTree.insert(i);
        }
        binaryTree.topView(binaryTree.getRoot());
    }








}
