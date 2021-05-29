package Patterns.educative.io.java2.E_CyclicSort;

class MissingNumber {

    //[3,0,1]
    // 0 1 2
    public static int findMissingNumber(int[] nums) {       //
        int i = 0;
        while (i < nums.length) {
            if (nums[i] < nums.length && nums[i] != nums[nums[i]]) {
                int temp = nums[nums[i]]; //
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            } else i++;
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i) return i;
        }
        return nums.length;
    }
    public int missingNumber2(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    public int missingNumber3(int[] nums) {
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
    ​

    =4∧(0∧0)∧(1∧1)∧(2∧3)∧(3∧4)
    =(4∧4)∧(0∧0)∧(1∧1)∧(3∧3)∧2
    =0∧0∧0∧0∧2
    =2
    ​



     */
}
