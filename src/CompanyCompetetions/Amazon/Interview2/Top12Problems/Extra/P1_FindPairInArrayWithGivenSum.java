package CompanyCompetetions.Amazon.Interview2.Top12Problems.Extra;

/*
Given an array A[] and a number x, check for pair in A[] with sum as x
Write a C program that, given an array A[] of n numbers and another number x,
determines whether or not there exist two elements in S whose sum is exactly x.
 */
public class P1_FindPairInArrayWithGivenSum {
    /*
    Let Array be {1, 4, 45, 6, 10, -8} and sum to find be 16
     */
    public static void main(String[] args) {
        int [] a = {1,4,45,6,10,-8};
        int sum = 16;
        findPair(a, sum);
    }
    private static boolean findPair(int[] a, int sum){
        java.util.Arrays.sort(a);

        System.out.println(a);

        int left= 0, right = a.length-1;
        while(left< right){
            if(a[left]+ a[right] ==  sum){
                System.out.println("Found");
                return true;
            }else if(a[left]+a[right]<sum) {
                left++;
            }else{
                right++;
            }
        }
        return false;
    }
}
