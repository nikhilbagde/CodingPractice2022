package LeetCode.Easy;

/**
 * Created by Nikhil on 3/29/2017 10:03 PM.
 */
public class P476NumberComplement {
    public static void main(String[] args) {
        System.out.println(findComplement(5));

        System.out.println("Long " + findComplement(5L));

        int num = 5;
        System.out.println("Bit count of " + num + "is " + Integer.bitCount(num));
        int a = Integer.decode("-11232135");
        System.out.println("a = " + a);
        System.out.println("Number of leading zero " + Integer.numberOfLeadingZeros(5));
    }

    private static int findComplement(int num) {
        int leadingZeroCount = Integer.numberOfLeadingZeros(num);
        num = ~num;
        System.out.println(Integer.toBinaryString(num));
        while (leadingZeroCount-- > 0) {
            num = num << 1;
            System.out.println(Integer.toBinaryString(num));
        }
        return num;
    }

    private static long findComplement(long num) {
        System.out.println(Long.toBinaryString(num));
        System.out.println(Long.toBinaryString(~num));
        return ~num;
    }
}
