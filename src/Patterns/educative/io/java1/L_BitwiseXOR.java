package Patterns.educative.io.java1;

import java.util.HashMap;
import java.util.Map;

public class L_BitwiseXOR {
    public static int findSingleNumber(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) res ^= arr[i];
        return res;
    }
    public static int findSingleNumber2(int[] nums) {
        for(int i=1; i< nums.length ; i++){
            nums[i] = nums[i] ^ nums[i-1];
        }
        return nums[nums.length-1];
    }
    public static int[] findSingleNumbers(int[] nums) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 2)-1);
        }
        int count = 0;
        for (Integer i: map.keySet()) {
            if (map.get(i) == 1) res[count++] = i;
        }
        return res;
    }
    public  static int[] findTwoNumberAppearingOnces(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        // Pass 1 :
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        diff &= -diff;
        // Pass 2 : diff will distinguish two wanted numbers
        int[] rets = {0, 0}; // this array stores the two numbers we will return
        for (int num : nums) {
            if ((num & diff) == 0) { // the bit is not set
                rets[0] ^= num;
            } else { // the bit is set
                rets[1] ^= num;
            }
        }
        return rets;
        /**
        This question is actually a very clever use of the ·Single Number· solution, because that solution can accurately find a number that appears only once, but the premise is that other numbers must appear twice.
        And this question has two numbers that only appear once, so if we can find a way to divide the original array into two small arrays, the two different numbers are in the two small arrays, so that the Single Number solution is called separately You can get the answer.
        So how to achieve it, first we XOR all the original array, then we will get a number, this number is the result of the XOR of two different numbers, we take out any one of the bits that is ‘1’, For the sake of convenience, we use ·a &= -a· to take out the bit whose rightmost end is ‘1’, specifically how to operate this.
        Take the example in the title, if we “exclusive OR” all of them, we know that the “exclusive OR” of the same two numbers is 0, then the two 1, and the two 2 are cancelled out, and there is nothing left 3 and 5’exclusive OR’, which is the binary 11 and 101’exclusive OR’, get 110.
        Then we perform a &= -a operation. First change the negative number. In binary, the negative number is in the form of complement, and the complement is the complement +1, then the complement of 110 is 11…1001, then after adding 1, it is 11…1010, and then 110 And, get 10, which is the diff variable in the code.
        With this diff, the original array can be divided into two arrays. Why, if two identical numbers are “XOR”, each of them will be 0, and different numbers will be “XOR”, there must be different corresponding bits, one 0 and one 1, so “XOR” ‘ it’s 1.
        For example, the binary 11 and 101 of 3 and 5, if you look from low to high, the first difference is the second digit. Then we use the second digit to AND each number in the array. Depending on the result, it must be possible to distinguish 3 and 5, and because the other numbers appear in pairs, they are also paired. In the end, they will be XORed into 0, and 3 and 5 will not be affected. XOR the numbers in the two groups separately to get the final result.
         */
    }
    public static int findComplement(int num) {
        return ~num & (Integer.highestOneBit(num) - 1);
    }
    public static int findComplement2(int num) {
        int mask = (Integer.highestOneBit(num) << 1) - 1;
        num = ~num;
        return num & mask;
        /* According to the problem, the result is :
            The flipped version of the original input but
            Only flip N bits within the range from LEFTMOST bit of 1 to RIGHTMOST.
            For example input = 5 (the binary representation is 101),
             the LEFTMOST bit of 1 is the third one from RIGHTMOST (100, N = 3).
             Then we need to flip 3 bits from RIGHTMOST and the answer is 010

            To achieve above algorithm, we need to do 3 steps:
            Create a bit mask which has N bits of 1 from RIGHTMOST.
            In above example, the mask is 111.
            And we can use the decent Java built-in function Integer.highestOneBit to get the LEFTMOST bit of 1,
             left shift one, and then minus one.
             Please remember this wonderful trick to create bit masks with N ones at RIGHTMOST, you will be able to use it later.
            Negate the whole input number.
            Bit AND numbers in step 1 and 2.
         */
    }
}
