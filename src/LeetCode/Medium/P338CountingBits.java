package LeetCode.Medium;

/**
 * Created by Nikhil on 4/2/2017 7:07 PM.
 */
public class P338CountingBits {
    public static void main(String[] args) {
        countBits(50);
    }

    private static int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            //result[i] = result[i/2] + (i&1);
            result[i] = result[i >> 1] + (i & 1);     // >>1 meaning divide by 2.
        }
        return result;

    }
}
