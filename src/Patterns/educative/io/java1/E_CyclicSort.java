package Patterns.educative.io.java1;

import java.util.ArrayList;
import java.util.List;

public class E_CyclicSort {
    public static int missingNumber2(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    public static int missingNumber3(int[] nums) {
        int expectedSum = nums.length*(nums.length + 1)/2;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        return expectedSum - actualSum;
    }
    /*
    Because we know that nums contains nn numbers and that it is missing exactly one number on the range [0..n-1][0..n−1], we know that nn definitely replaces the missing number in nums. Therefore, if we initialize an integer to nn and XOR it with every index and value, we will be left with the missing number. Consider the following example (the values have been sorted for intuitive convenience, but need not be):
    Index	0	1	2	3
    Value	0	1	3	4
    \begin{aligned} missing &= 4 \wedge (0 \wedge 0) \wedge (1 \wedge 1) \wedge (2 \wedge 3) \wedge (3 \wedge 4) \\ &= (4 \wedge 4) \wedge (0 \wedge 0) \wedge (1 \wedge 1) \wedge (3 \wedge 3) \wedge 2 \\ &= 0 \wedge 0 \wedge 0 \wedge 0 \wedge 2 \\ &= 2 \end{aligned}
    missing
    =4∧(0∧0)∧(1∧1)∧(2∧3)∧(3∧4)
    =(4∧4)∧(0∧0)∧(1∧1)∧(3∧3)∧2
    =0∧0∧0∧0∧2
    =2
     */

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int i =0; i< nums.length; i++){
            int temp = Math.abs(nums[i]);
            if(nums[temp-1]>0) nums[temp-1] *= -1;
        }
        for(int i =0; i< nums.length; i++){
            if(nums[i]>0) result.add(i+1);
        }
        return result;
    }

    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        for (int i : nums) {
            int index = Math.abs(i);
            if (nums[index - 1] > 0) {
                nums[index - 1] *= -1;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }

    public static List<Integer> findDisappearedNumbers3(int[] nums) {
        List<Integer> res = new ArrayList();
        for(int i = 0;i<nums.length;i++){
            int temp = Math.abs(nums[i]); //it's a value from array
            if(nums[temp-1] > 0) nums[temp-1] *= -1; //making it as a -ve index
        }               //  > 0 because in below loop we are going from 1 ->= n
        for(int i = 1;i<=nums.length;i++){
            if(nums[i-1] > 0) // all positive indexes will be collected
                res.add(i);
        }
        return res;
    }

    public static int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);
        slow = 0;
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
