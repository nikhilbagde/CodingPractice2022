package ElementsOfProgrammingInterview.DataStructure.Primitives;

public class PrimitiveTypes {
    public static void main(String[] args) {
        char a = 'a';
        byte byte_max = Byte.MAX_VALUE;     //8 Bit number   2 ^8= 256    256/2= 128   (-128 to 127]
        byte byte_min = Byte.MIN_VALUE;
        short short_min = Short.MIN_VALUE;  //16 bit number  2 ^16= 65536  65536/2= 32,768 (-32768 to 32767]
        short short_max = Short.MAX_VALUE;
        int int_max = Integer.MAX_VALUE;    //32 bit number  2 ^32= 4,294,967,296 /2=  (-2^31 to 2^31-1]
        int int_min = Integer.MIN_VALUE;
        long long_min = Long.MIN_VALUE;     // 64 but number: 2^63  (-2^63 to 2^63-1]
        long long_max = Long.MAX_VALUE;
        float float_min = Float.MIN_VALUE;
        float float_max = Float.MAX_VALUE;
        double double_min = Double.MIN_VALUE;
        double double_max = Double.MAX_VALUE;
        boolean bool_true = Boolean.TRUE;
        boolean bool_false = Boolean.FALSE;
        char char_min = Character.MIN_VALUE; // 16 bit Unicode character min: '\u0000' = 0 and max: '\uffff' = 65,535
        char char_max = Character.MAX_VALUE;

        System.out.println("byte_min = " + byte_min);
        System.out.println("byte_max = " + byte_max);

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
}
