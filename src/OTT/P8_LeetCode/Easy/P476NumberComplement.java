package LeetCode.Easy;

/**
 * Created by Nikhil on 3/29/2017 10:03 PM.
 */
public class P476NumberComplement {
    public static void main(String[] args) {
        // System.out.println(findComplement(5));
        System.out.println(findComplimet2(10));
/*
        System.out.println("Long " + findComplement(5L));

        int num = 5;
        System.out.println("Bit count of " + num + "is " + Integer.bitCount(num));
        int a = Integer.decode("-11232135");
        System.out.println("a = " + a);
        System.out.println("Number of leading zero " + Integer.numberOfLeadingZeros(5));*/
    }

    private static int findComplement(int num) {
        int leadingZeroCount = Integer.numberOfLeadingZeros(num);
        int remaining = 32 - leadingZeroCount;

        num = ~num;
        System.out.println(Integer.toBinaryString(num));
        int checker = 0;
        while (leadingZeroCount > 0) {
            int temp = 1 << leadingZeroCount - 1;
            //System.out.println(Integer.toBinaryString(temp));
            checker |= temp;
            //System.out.println(Integer.toBinaryString(checker));
            leadingZeroCount--;
        }
        while (remaining-- > 0) {
            checker = checker << 1;
            //System.out.println(Integer.toBinaryString(checker));
        }
        System.out.println(Integer.toBinaryString(checker));
        return num;
    }

    private static long findComplement(long num) {
        System.out.println(Long.toBinaryString(num));
        System.out.println(Long.toBinaryString(~num));
        return ~num;
    }

    private static int findComplimet2(int num) {

        /*
        1010 -> 4 digit number -> its compliment is 1111 1111 1111 1111 1111 1111 1111 0101
        we dont want it, we want only last 4 digits -? 0101
        HOw to eliminate other 1 digit at front.
        we are hoping to adding it (1111 1111 1111 1111 1111 1111 1111 0101)
                    with           (0000 0000 0000 0000 0000 0000 0000 1111)
                    to get                                             0101 part
                         so we need to get this number (0000 0000 0000 0000 0000 0000 0000 1111)
                         means 1111.
        Step 1:
        Intger.highestOneBit(10) -> give number with MSB bit = 1 and all other zeros
        for 1010 -> 1000
        10 -> 8

        Step 2:
        left shift it
        1000 -> 1000 << 1 -> 10000


        Step 3: to get 1111
        10000 - 1 = 1111
        Hurray!

        Now we can and it with its compliment to get final value as seen before
                                    (1111 1111 1111 1111 1111 1111 1111 0101)
                    with           &(0000 0000 0000 0000 0000 0000 0000 1111)
                    to get           0000 0000 0000 0000 0000 0000 0000 0101 part final answer.
         */
        System.out.println(Integer.toBinaryString(num));
        int numberWithHighestOneAllOtherZeros = Integer.highestOneBit(num);
        int temp = (numberWithHighestOneAllOtherZeros << 1);
        temp = temp - 1;    //10000 - 1 = 1111;
        System.out.println(Integer.toBinaryString(temp));
        System.out.println(Integer.toBinaryString(~num));

        return ~num & temp;
        //return ~num & ((numberWithHighestOneAllOtherZeros<< 1) - 1);
        //return ~num & ((Integer.highestOneBit(num)<< 1) - 1);
    }
}