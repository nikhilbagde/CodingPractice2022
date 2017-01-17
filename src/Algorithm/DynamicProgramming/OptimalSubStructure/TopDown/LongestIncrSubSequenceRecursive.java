package Algorithm.DynamicProgramming.OptimalSubStructure.TopDown;

/**
 * Created by Nikhil on 1/5/2017 10:53 PM.
 * The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence
 * of a given sequence such that all elements of the subsequence are sorted in increasing order.
 * For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6
 * and LIS is {10, 22, 33, 50, 60, 80}.
 */
public class LongestIncrSubSequenceRecursive {
    static int maxLISLength;
    public static void main(String[] args) {
        int[] array = {10, 22, 9, 33, 21, 50, 41, 60};  //length = 8

        calculateLIS(array);
    }
    private static void calculateLIS(int[] array){
        maxLISLength = 1;
        calculateLISRec(array, array.length);
        System.out.println(maxLISLength);
    }
    private static int calculateLISRec(int[] array, int length){
        if(length == 1){
            return 1;
        }
        int currentLISLength = 1;
        //for each ending i th element of an array, calculate LIS.
        for (int subLength = 0; subLength < length-1; subLength++) {   //1st to third last element. (50)
            int subProblemLISlength = calculateLISRec(array, subLength);        // subLength = 0,1,2,3,4,5,6
            if(array[subLength] < array[length-1] && currentLISLength < (1+ subProblemLISlength)){
                currentLISLength = 1 + subProblemLISlength;
            }
        }
        if(currentLISLength > maxLISLength) {
            maxLISLength = currentLISLength;
        }
        return currentLISLength;
    }
}

/*
Optimal Substructure:
Let arr[0..n-1] be the input array and L(i) be the length of the LIS ending at index i
such that arr[i] is the last element of the LIS.
Then, L(i) can be recursively written as:
L(i) = 1 + max( L(j) ) where 0 < j < i and arr[j] < arr[i]; or
L(i) = 1, if no such j exists.
To find the LIS for a given array, we need to return max(L(i)) where 0 < i < n.
Thus, we see the LIS problem satisfies the optimal substructure property as the
main problem can be solved using solutions to subproblems.
 */
/*
               lis(4)
           /    |       \
      lis(3)    lis(2)   lis(1)
     /   \        /
   lis(2) lis(1) lis(1)
   /
lis(1)
 */