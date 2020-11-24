package ElementsOfProgrammingInterview.DataStructure.Primitives;

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
     * The parity of a binary word is 1 if the number of Is in the word is odd; otherwise,
     * it is 0. For example, the parity of 1011 is 1, and the parity of 10001000 is 0.
     */
    private static void P2_ComputeParityOfAWord() {
        long x = 556; // 64 bit long number  Test: 0 , 1 , 11, -11, 556, -556

        System.out.println(Long.toBinaryString(x));
        short result = 0;
        while (x != 0) {

            result = (short) (result ^ (short) (x & 1));
            x >>>= 1;
            System.out.println(Long.toBinaryString(x) + " Result" + result);
        }
        System.out.println("result = " + result);
    }

}
