package GeeksForGeeks.CodingProblems.Trees.Set2;

import GeeksForGeeks.CodingProblems.Trees.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Nikhil on 1/18/2017 1:19 PM.
 */
public class ConvertToSumOfChildren {
    //POST ORDER
    private static void convertTree(TreeNode root){
        if (root==null || root.left==null && root.right==null) return;
        else{
            convertTree(root.left);                 //first convert all left->right->self (PostOrder)
            convertTree(root.right);                //

            int leftV= root.left!=null? root.left.value:0;
            int rightV= root.right!=null? root.right.value:0;
            int diff = (leftV+rightV)-root.value;

            if(diff>0){         //ROOT < (LEFT+RIGHT)
                root.value += diff;
            }else if(diff<0){   //Root > (LEFT+RIGHT)
                increment(root, -diff);        //MAKE IT POSITIVE AND PASS
            }
        }
    }
    private static void increment(TreeNode root, int diff){
        if(root.left!=null){
            root.left.value += diff;
            increment(root.left, diff);
        }else if(root.right!=null) {
            root.right.value += diff;
            increment(root.right, diff);
        }
    }
}
