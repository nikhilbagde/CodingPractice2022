package LeetCode.Easy;

/**
 * Created by Nikhil on 3/29/2017 9:49 PM.
 */

public class P461HammingDistance {
    public static void main(String[] args) {
        hammingDistance(1, 4);
    }

    private static int hammingDistance(int x, int y) {
        int result = 0, count = 0;
        result = x ^ y;
        System.out.println(Integer.toBinaryString(result));
        while (result > 0) {
            if ((result & 1) == 1)
                ++count;
            result = result >> 1;
        }
        return count;
    }
}
/*
Hamming distance is total number of different bits of two integers
Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.
 */