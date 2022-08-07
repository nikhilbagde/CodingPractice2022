package LeetCode.Patterns.Array;

/**
 * @author Nikhil Bagde
 * @package LeetCode.Patterns.Array
 * @created 10/29/2020
 * @date 10/29/2020- 12:01 AM
 * @project IdeaProjects
 **/
public class LC_268_MissingNumber {
    public static void main(String[] args) {
        int[] nums = {3,0,1};
        //int[] nums = {9,6,4,2,3,5,7,0,1};
    }

    public static int missingNumber(int[] nums) {

        /* sum of n positive integer = n * n+1 /2
        n=5, 4  4*5=20/2=10
       1 0 4 3 2  sum = 10
        n=1     1-1=0   0*1=1/2=0.5=0
        0       sum = 0
        n=2     1*2=2/1=1
        0 1     sum = 1
        n=3     2*3=6/2=3
        0 1 2   sum = 3
        n=4     3*4=12/2=6
        0 1 2 3  sum = 6
        */
        int sum = 0;
        for(int i=0; i<nums.length;i++){
            sum = sum + nums[i];
        }

        int length = nums.length;

        int summation = (length*(length+1))/2;

        return summation-sum;
    }
}
