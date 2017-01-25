package GeeksForGeeks.CodingProblems.Trees.Set4;

import GeeksForGeeks.CodingProblems.Trees.BinaryTree;
import GeeksForGeeks.CodingProblems.Trees.Set1.ConstructBST;
import GeeksForGeeks.CodingProblems.Trees.TreeNode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Nikhil on 1/25/2017 12:30 PM.
 */
public class VerticalSumRec {
    private static void getVerticalSum(TreeNode root){
        if(root==null) return;
        Map<Integer, Integer> map = new LinkedHashMap<>();      //used linkedHashMap to display it in order of insertion.

        int horizontalDistance = 0;
        verticalSum(root, map, horizontalDistance);         //solving recursively
        if(!map.isEmpty()){
            System.out.println("map = " + map.entrySet());
        }
    }
    private static void verticalSum(TreeNode root, Map<Integer,Integer> map,  int horDist){
        if(root==null) return;
        verticalSum(root.left, map, horDist-1);                     //first go to leftmost
        int totalHorizontalDistance = map.get(horDist)==null ? 0 : map.get(horDist);
        totalHorizontalDistance += root.value;
        map.put(horDist, totalHorizontalDistance);      //store its hd in map | adding root.value b/c we are calculating vertical sum of same HD
        verticalSum(root.right, map, horDist+1);                    //do same for right subtree
    }

    public static void main(String[] args) {
        BinaryTree tree = ConstructBST.constructBST();
        getVerticalSum(tree.getRoot());

        BinaryTree tree1 = ConstructBST.constructBSTLeftInclined();
        getVerticalSum(tree1.getRoot());
    }
}

/*
/*                              height = 3;
//         6                        0
//      /     \
//    3           10                1
//   / \         /   \
//  2    4      8    12             2
// /      \    / \   /  \
// 1        5  7   9 11  13         3
*/