package Books.ElementsOfProgrammingInterview.DataStructure.Ch_0_Primitives;

import java.util.Random;

public class PrimitiveTypes {
    public static void main(String[] args) {
        char a = 'a';
        byte byte_max = Byte.MAX_VALUE;     //8 Bit number   2 ^8= 256    256/2= 128   (-128 to 127]
        byte byte_min = Byte.MIN_VALUE;
        byte byte_size = Byte.SIZE;

        short short_min = Short.MIN_VALUE;  //16 bit number  2 ^16= 65536  65536/2= 32,768 (-32768 to 32767]
        short short_max = Short.MAX_VALUE;
        short short_size = Short.SIZE;

        int int_max = Integer.MAX_VALUE;    //32 bit number  2 ^32= 4,294,967,296 /2=  (-2^31 to 2^31-1]
        int int_min = Integer.MIN_VALUE;
        int int_size = Integer.SIZE;

        long long_min = Long.MIN_VALUE;     // 64 but number: 2^63  (-2^63 to 2^63-1]
        long long_max = Long.MAX_VALUE;
        long long_size = Long.SIZE;

        float float_min = Float.MIN_VALUE;
        float float_max = Float.MAX_VALUE;
        float float_size = Float.SIZE;

        double double_min = Double.MIN_VALUE;
        double double_max = Double.MAX_VALUE;
        double double_size = Double.SIZE;

        boolean bool_true = Boolean.TRUE;
        boolean bool_false = Boolean.FALSE;

        char char_min = Character.MIN_VALUE; // 16 bit Unicode character min: '\u0000' = 0 and max: '\uffff' = 65,535
        char char_max = Character.MAX_VALUE;

        /*
                Default values:

        Data Type	Default Value (for fields)
        byte	    0
        short	    0
        int	        0
        long	    0L
        float	    0.0f
        double	    0.0d
        char	    '\u0000'
        String
        (or any object)  	null
        boolean	    false

         */

        P1_CountNumberOfBitsSetTo1();

        //Box Types Factories
        Double doubleValue = Double.valueOf("1.24");
        Boolean booleanValue = Boolean.valueOf(true);
        Integer intValue = Integer.parseInt("42");
        String floatValue = Float.toString(-1.24f);

        //Comparing values
        Boolean results_d = Double.compare(doubleValue, 1.24) == 0;

        //Maths Key methods
        double mathValue_1 = Math.abs(-34.5);
        double mathValue_2 = Math.abs(-34);
        double mathValue_3 = Math.ceil(2.17);
        double mathValue_4 = Math.floor(3.14);
        double mathValue_5 = Math.min(2, -3);
        double mathValue_6 = Math.max(2, -3);
        double mathValue_7 = Math.pow(2.71, 3.14);
        double mathValue_8 = Math.sqrt(255);

        //Limit of autoboxing
        // Character[] C = new char[]{'a','b'};
        int charValue = Character.getNumericValue('x');

        //Random
        Random r = new Random();
        int nextInt_1 = r.nextInt();
        int nextInt_21 = r.nextInt();
        int nextInt_31 = r.nextInt();
        int nextInt_51 = r.nextInt();
        int nextInt_41 = r.nextInt();
        int nextInt_2 = r.nextInt(16);
        int nextInt_3 = r.nextInt(16);
        int nextInt_4 = r.nextInt(16);
        int nextInt_5 = r.nextInt(16);
        int nextInt_6 = r.nextInt(16);
        int nextInt_7 = r.nextInt(16);

        double nextDDouble_1 = r.nextDouble();
        double nextDDouble_2 = r.nextDouble();
        double nextDDouble_3 = r.nextDouble();
        double nextDDouble_4 = r.nextDouble();
        double nextDDouble_5 = r.nextDouble();
        double nextDDouble_6 = r.nextDouble();
        double nextDDouble_7 = r.nextDouble(); //nextDouble.. return values between [0,1)

        P2_ComputeParityOfAWord();

        // Swap Bits
        /**
         * A 64-bit integer can be viewed as an array of 64 bits, with the bit at index 0 corre¬
         * sponding to the least significant bit (LSB), and the bit at index 63 corresponding to
         * the most significant bit (MSB). Implement code that takes as input a 64-bit integer
         * and swaps the bits at indices i and y. Figure 5.1 illustrates bit swapping for an 8-bit
         * integer.
         *
         * //Ideas to accelerate bit manipulation
         *         // E.g x & ( x - 1 ) clears the lowest set but in x
         *         // and x & ~ ( x - 1) extracts the lowest set but of x
         *         //  101101 x
         *         //  101100 x - 1
         *         //&=101100 cleared lowest set bit.
         *         //  101100 y
         *         //  101011 y-1
         *         //&=101000
         *  Similarly extraction
         *  1. 101101 & ~(101101-1) = 101101 & ~(101100) = 101101 & 010011 = 000001
         *  2. 101110 & ~(101110-1) = 101110 & ~(101101) = 101110 & 010010 = 000010
         *
         *
         */
        P3_swapBitsInANumber();

    }


    /**
     * P1: Writing a program to count the number of bits that are set to 1 in an integer
     * Notes:
     * >>=	   x >>= 3	        x = x >> 3
     * Operator	Description	                 Example	Same as	        Result   Decimal
     * &	    AND - Sets each bit to 1 if
     * both bits are 1	              5 & 1	   0101 & 0001	    0001	 1
     * |	    OR - Sets each bit to 1
     * if any of the two bits is 1	  5 | 1	    0101 | 0001	    0101	 5
     * ~	    NOT - Inverts all the bits	  ~ 5	    ~0101	        1010	 10
     * ^	    XOR - Sets each bit to 1
     * if only one of
     * the two bits is 1	          5 ^ 1	    0101 ^ 0001	    0100	 4
     * <<	    Zero-fill left shift
     * - Shift left by pushing
     * zeroes in from the right
     * and letting the leftmost
     * bits fall off	              9 << 1	1001 << 1	0010	2
     * >>	    Signed right shift
     * - Shift right by pushing
     * copies of the leftmost bit
     * in from the left
     * and letting the rightmost
     * bits fall off	               9 >> 1	1001 >> 1	1100	12
     * >>>	    Zero-fill right shift
     * - Shift right by pushing
     * zeroes in from the left
     * and letting the rightmost
     * bits fall off	               9 >>> 1	1001 >>> 1	0100	4
     */
    private static void P1_CountNumberOfBitsSetTo1() {
        /*test 1
        n = 0;
        n=1
        n = 255  (11111111)
        n=-255   (11111111111111111111111100000001)*/
        int n = 255;
        System.out.println(Integer.toBinaryString(n));

        int numBits = 0;
        while (n != 0) {
            numBits = numBits + (n & 1);
            //BUG:
            // n = n>>1;    // if I use >> it will always append 1 in the left most bit
            n = n >>> 1;      // and for negative number it will fail
            // e.g. -255 11111111111111111111111100000001
            // after right shifting, it will keep appending 1 in the LMB
            // and hence it will go in infinite loop
            // Using >>> will append zero while shifting to right.
        }

        System.out.println("numBits = " + numBits);

    }
    /**
     * Note: The Bitwise examples above use 4-bit unsigned examples,
     * but Java uses 32-bit signed integers and 64-bit signed long integers.
     * Because of this,
     * in Java, ~5 will not return 10.
     * It will return -6. ~00000000000000000000000000000101
     * will return 11111111111111111111111111111010
     *
     * In Java, 9 >> 1 will not return 12. It will return 4.
     * 00000000000000000000000000001001 >> 1 will return 00000000000000000000000000000100
     */

    /**
     * The parity of a binary word is 1 if the number of 1's in the word is odd; otherwise,
     * it is 0. For example, the parity of 1011 is 1, and the parity of 10001000 is 0.
     */
    private static void P2_ComputeParityOfAWord() {
        //Approach: 1 : O(n)  : n no of bits (64)
        long x = 556; // 64 bit long number  Test: 0 , 1 , 11, -11, 556, -556

        System.out.println(Long.toBinaryString(x));
        short result = 0;
        while (x != 0) {

            result = (short) (result ^ (short) (x & 1));
            x >>>= 1;
            System.out.println(Long.toBinaryString(x) + " Result" + result);
        }
        System.out.println("result = " + result);

        //Approach: 2 : Improvement on best and average case O(k) - k no of 1st. (5)
        /*Approach2 :
         * given a number
         * E.g. 1000101101
         * we are planning to iterate only no of k times where K is no of occurrence of 1 no.
         * So for no: 1000101101
         * if we negate 1 from this no.
         * 1000101101
         * -        1
         *=1000101100 ( - 1)
         * &            &
         * 1000101101 (original no)
         *=1000101100 ( we can remove lease significant bit with value 1)
         *
         * 100-1=
         * 011  This flips all the bits. If we & it, it will vanish.
         * 100 & 011 = 0 */
        long x1 = 556; // 64 bit long number  Test: 0 , 1 , 11, -11, 556, -556

        System.out.println(Long.toBinaryString(x1));
        short result1 = 0;
        while (x1 != 0) {
            result1 = (short) (result1 ^ 1);
            x1 = x1 & (x1 - 1);
        }
        System.out.println("result = " + result1);

        //Approach 3: log(n) where n is the size of the number
        /**
         * We know that XOR bitwise is commutative and associative
         * 0 ^ 0 ^ 1 = (0 ^ 0) ^ (1) also = (0^1) ^ 0 =1
         * We can use existing number to compute the parity:
         * E.g. 8 Bit number: 11010111 - Divide it into 2 4 bits set
         * 1101 ^ 0111 = 1010 and store it in LSB of same word.
         * So original number would be now: from 11010111 -> 11011010 (Only last 4 digits are changed)
         * Now, we move forward with last 4 bits, - Divide it into two separate 2 bits.
         * 1010 -> 10 ^ 10 = 00
         * Store it in same number: 11011000 ( only last 2 bits update)
         * 00 - divide it in 0 ^ 0 = 0
         * 11011000 - updated last bit to same 0.
         *
         * Now last digit is the answer. Extract it with bitwise-AND (00000001) & 11011000 = 0.
         *
         * WE don't care of MSB one we got working LSB.
         */
        long x2 = 256; // 64 bit long number  Test: 0 , 1 , 11, -11, 556, -556,  Long.MAX_VALUE-1

        System.out.println(Long.toBinaryString(x2));
        x2 = x2 ^ x2 >>> 32; //100000000
        x2 = x2 ^ x2 >>> 16; //100000000
        x2 = x2 ^ x2 >>> 8; //100000000
        x2 = x2 ^ x2 >>> 4; //100000001
        x2 = x2 ^ x2 >>> 2; //100010001
        x2 = x2 ^ x2 >>> 1; //101010101

        short result2 = (short) (x2 & 1L);
        System.out.println("result2 = " + result2);

    }
    /**
     * Note: while going through all digits, initially it result is zero
     * Whenever we encounter 1, we exOR.
     * Now exOr is set to 1 when one of the digit is 1.
     * So when we encounter next 1, we change result from 0 to 1.
     * Now when duplicate next 1 is found then result 1 is clears as 1 ^ 1 = 0.
     * Initially result was 0
     * when 1st 1 was found we set it to 1.
     * before finding next 1, if we even encounter zeros in between, 1 ^ 0 = 1, keep the count of one alive.
     * Unless next one is found. 1 ^ 1 = 0.
     * And for 0 ^ 0 = always 0.
     * DEBUG:
     * 1000101101 Result = 0.   0 ^ 1&1 => 1
     * 100010110 Result = 1.    1 ^ 0&1 => 1
     * 10001011 Result = 1.     1 ^ 1&1 => 0
     * 1000101 Result = 0
     * 100010 Result = 1
     * 10001 Result = 1
     * 1000 Result = 0
     * 100 Result = 0
     * 10 Result = 0
     * 1 Result = 0
     * 0 Result = 1
     * result = 1
     *
     *
     *
     */

    /**
     * PROBLEM: A 64-bit integer can be viewed as an array of 64 bits, with the bit at index 0 corre¬
     * sponding to the least significant bit (LSB), and the bit at index 63 corresponding to
     * the most significant bit (MSB). Implement code that takes as input a 64-bit integer
     * and swaps the bits at indices i and y. Figure 5.1 illustrates bit swapping for an 8-bit
     * integer.
     */
    private static void P3_swapBitsInANumber() {


        long x3 = 73;  //1001001
        int i = 6, j = 1;

        // if bit as ith and jth are same then it does not make sense to swap it. Directly return the same number:
        long result;
        if (((x3 >>> i) & 1) != ((x3 >>> j) & 1)) {
            // i-th and j-th bits differ. We will swap them by flipping their values.
            // Select the bits to flip with bitMask.
            // Since x^ l = 0 when x = 1 and 1 when x = 0,
            // we can perform the flip XOR .
            long bitMask = (1L << i) | (1L << j);
            result = x3 ^ bitMask;
        } else {
            result = x3; // same number
        }
        System.out.println("result = " + result);
    }

    // Time complexity : O(1)

    /**
     * PROBLEM : COMPUTE X X y WITHOUT ARITHMETICAL OPERATORS
     * Write a program that multiplies two non-negative integers. The only operators you
     * are allowed to use are
     * • assignment,
     * • the bitwise operators », «, |, &, “ and
     * • equality checks and Boolean combinations thereof.
     */

    public static long multiply(long x, long y) {
        long sum = 0;
        while (x != 0) {
            // Examines each bit of x.
            if ((x & 1) != 0) {
                sum = add(sum, y);
            }
            x >>>= 1;
            y <<= 1;
        }
        return sum;
    }

    private static long add(long a, long b) {
        long sum = 0, carryin = 0, k = 1, tempA = a, tempB = b;
        while (tempA != 0 || tempB != 0) {
            long ak = a & k, bk = b & k;
            long carryout = (ak & bk) | (ak & carryin) | (bk & carryin);
            sum |= (ak ^ bk ^ carryin);
            carryin = carryout << 1;
            k <<= 1;
            tempA >>>= 1;
            tempB >>>= 1;
        }
        return sum | carryin;
    }
    /** Explanation
     * The algorithm taught in grade-school for decimal multiplication does not use
     * repeated addition—it uses shift and add to achieve a much better time complexity.
     * We can do the same with binary numbers—to multiply x and y we initialize the result
     * to 0 and iterate through the bits of x,adding 2ky to the result if the fcth bit of x is 1.
     * The value 2ky can be computed by left-shifting y by k. Since we cannot use add
     * directly, we must implement it. We apply the grade-school algorithm for addition to
     * the binary case, i.e., compute the sum bit-by-bit, and "rippling" the carry along.
     * As an example, we show how to multiply 13 = (1101)2 and 9 = (1001)2 using the
     * algorithm described above. In the first iteration, since the LSB of 13 is 1, we set the
     * result to (1001)2. The second bit of (1101)2 is 0, so we move on to the third bit.
     *
     * bit is 1, so we shift (1001)2 to the left by 2 to obtain (100100)2/ which we add to (1001)2
     * to get (101101)2. The fourth and final bit of (1101)2 is 1, so we shift (1001)2 to the left
     * by 3 to obtain (1001000)2, which we add to (101101)2 to get (1110101)2 = 117.
     * Each addition is itself performed bit-by-bit. For example, when adding (101101)2
     * and (1001000)2, the LSB of the result is 1 (since exactly one of the two LSBs of the
     * operands is 1). The next bit is 0 (since both the next bits of the operands are 0). The
     * next bit is 1 (since exactly one of the next bits of the operands is 1). The next bit is
     * 0 (since both the next bits of the operands are 1). We also "carry" a 1 to the next
     * position. The next bit is1(since the carry-in is1and both the next bits of the operands
     * are 0). The remaining bits are assigned similarly.
     */
}
