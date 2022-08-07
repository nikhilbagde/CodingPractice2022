package OTT.P6_HackerRank.DynamicProgramming.OptimalSubStructure.BottomUp;

/**
 * Created by Nikhil on 1/5/2017 11:32 PM.4
 *and LIS is {10, 22, 33, 50, 60, 80}.  = 5
 */
public class LongestIncreasingSubsequenceTabular {
    public static void main(String[] args) {
        int[] array = {10, 22, 9, 33, 21, 50, 41, 60};  //length = 8
        findLongestIncreasingSubSequence(array);
    }
    private static void findLongestIncreasingSubSequence(int [] array){
        int[] lisTable = new int[array.length];
        //int[] sortedElementOfLIS = new int[array.length];

        for (int i = 0; i < lisTable.length; i++) {
            lisTable[i] = 1;
        }

        //bottom up
        for (int next = 1; next < lisTable.length ; next++) {        //for all numbers in array starting from 2nd element
            for (int prev = 0; prev < next; prev++) {                   //consider all values from 1 to each element
                if(array[prev] < array[next] &&  lisTable[next] < lisTable[prev]+1 ){     //update only when if its less that previously stored count of LIS
                    lisTable[next] = lisTable[prev] + 1;                                        //plus 1+prev  b/c, default values are 1.
                }
            }
        }

        //find max value of LIS that would be final answer.
        int max = 0;
        for (int element : lisTable) {
            if (element > max) {
                max = element;
            }
        }
        System.out.println("Longest increasing subsequence count is " + max);

    }
}
