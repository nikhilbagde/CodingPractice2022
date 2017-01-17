package DataStructure.Trees;


/**
 * Created by Nikhil on 4/29/2016.
 */
public class TreePreOrderTransversal {
    int data;
    TreePreOrderTransversal left;
    TreePreOrderTransversal right;

    void preOrder(TreePreOrderTransversal root){
        System.out.println(root.data + " ");

        if(root.left!= null){
            preOrder(root.left);
        }
        if(root.right!=null){
            preOrder(root.right);
        }
    }

}

