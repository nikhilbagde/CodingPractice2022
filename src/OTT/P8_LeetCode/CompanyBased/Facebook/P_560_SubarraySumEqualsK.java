package LeetCode.CompanyBased.Facebook;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Nikhil Bagde
 * @package LeetCode.CompanyBased.Facebook
 * @created 04/24/2021
 * @date 4/24/2021- 2:19 PM
 * @project HackerRank2017
 **/
public class P_560_SubarraySumEqualsK {

    static int count = 0;
    public static void main(String[] args) {
        int [] A = { 3, 4, -7, 1, 3, 3, 1, -4 };
        int k = 7;
        subArraySum(A,k);
        System.out.println("Total = " + count);

        count  = subArraySumHashMap(A, k);
        System.out.println("Total = " + count);

        count = subArraySumHashMapUnderstood(A, k);
        System.out.println("Total = " + count);
    }

    /**
     *  3 4 -7 1 3 3 1 -4
     *  sum = 7
     *
     *  3    4 -7 1 3 3 1 -4
     *
     */
    public static void subArraySum(int[] nums, int k) {  // Time : O(n)^2  , Space: O(1)
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length ; j++) {
                sum = sum + nums[j];
                System.out.print( " nums[j] = " + nums[j] + "," );
                if(sum == k){
                    count++;
                }
            }
            System.out.println();
        }
    }

    /**
     *
     * @param nums
     * @param k
     */
    public static int  subArraySumHashMap(int [] nums, int k){ // Time : O(n)^2  , Space: O(1)
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int currentCount = map.getOrDefault( sum - k, 0);
                                                                                                                                                                                System.out.println("currentCount = " + currentCount);
            count += currentCount;
//            int sumCount = map.getOrDefault(sum, 0);
//            map.put(sum, sumCount);

            map.put(sum, map.getOrDefault(sum, 0)+1);

        }
        return count;
    }

    /**
     * Video = https://www.youtube.com/watch?v=HbbYPQc-Oo4
     *  when we are adding sum till that element and keeping it in a hashmap.
     *  for each next index, we are going to find summations till that index.
     *  If we find the different between current sum = k. Meaning we are trying to see if at some other subArray index sum is possible.
     *  if currentSum - k is already present in the map, means that index next to that if I start adding till current index I will again get the sum = k.
     *  0 1 2 3   4  5      (index)
     *  3 2 4 1   4 -2      k = 7
     *  3 5 9 10                            10 - 7 =3 we have 3 in the map. 3 was found at index 0th, if I start from 1st index till 3rd index, I will get 7 as sum.
     *                                           [2 + 4 + 1] = 7   so we had  3 + 7 = 10     3 was already present, we have some subArray whose sum is 7 and currentSum = 10
     *  3 5 9 10 14 12                  Again here, 12-7=5 was found in the map. Meaning till 1st index we have summation =5,
     *                                           if I start from 2nd index till current index 5, I will get sum = 7
     *                                           [4 + 1 + 9 - 2] = 7               5 + (7) = 12  sumArray with sum 7 was found
     *
     */
    public static int subArraySumHashMapUnderstood(int[] nums, int k){  //TIME: O(N) Space O(1)
        int sum = 0;
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);//if I put 0 has seen as 0th time it does not work.We have seen 0the sum once, just assume that
        for(int num: nums ){
            sum = sum + num;
            int alreadySumArrayFoundTillThatIndexCount = map.getOrDefault(sum-k,0);
            count = count + alreadySumArrayFoundTillThatIndexCount;
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
