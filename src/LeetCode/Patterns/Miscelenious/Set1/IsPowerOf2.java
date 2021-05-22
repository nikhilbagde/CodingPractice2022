package LeetCode.Patterns.Miscelenious.Set1;

/**
 * Created by Nikhil on 1/21/2017 2:45 PM.
 */
public class IsPowerOf2 {
    /*  0 = 0000        2 = 0010        (always have 1's 1)
        1 = 0001
        3 = 0011        4 = 0100        (1 bit only appearing once)
        5 = 0101
        6 = 0110
        7 = 0111        8 = 1000        (1 bit only appearing once)

        So power of two number would always have 1 1st in its binary representation.
        so if we negate 1 from that number resulting number will be always i bit less and will contain all 11111.
        e.g 32 = 100000     1 + (5 times 0)
            32-1 = 31 = 011111  0 + (5times 1)
            so 32 & 31 = 100000 & 011111 = 000000 should be all zero. meaning this is our number which has only 1
        number-1 would give
     */
    private static boolean isPowerOf2(int number){
        //System.out.println(Integer.toBinaryString(number));
        //System.out.println(Integer.toBinaryString(number-1));
        return number>0 && (number & number-1) == 0;
    }
    private static boolean isPowerof2V3(int number){
        return number > 0 && number == Math.pow(2, Math.round(Math.log(number) / Math.log(2)));
    }
    private static boolean isPowerOf2V2(int number){
        int bitCount = 0;
        int useNumber = number;
        while(useNumber>0){
            useNumber = useNumber>>1;
            bitCount++;
        }
        int msb = (int) Math.pow(10, bitCount);
        boolean containbit1 = false;
        useNumber = number>>1;         // if it is 1000000 get userNumber = 0111111
        while(bitCount-1>0){
            if( (useNumber&1) ==1) containbit1 = true;
            useNumber >>= 1;
        }
        return ((msb&1) ==1) && !containbit1;           //if it has only 1 as msb and all other bits should not contact 1
    }


    public static void main(String[] args) {
        boolean result = isPowerOf2(32);
        System.out.println("result = " + result);

        boolean result2 = isPowerOf2V2(32);
        System.out.println("result = " + result2);
    }
}
