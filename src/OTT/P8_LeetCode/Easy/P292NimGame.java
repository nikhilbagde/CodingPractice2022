package LeetCode.Easy;

/**
 * Created by Nikhil on 3/30/2017 11:18 PM.
 */
public class P292NimGame {
    public static void main(String[] args) {
        canWinNim(5);
    }

    private static boolean canWinNim(int n) {
        //if number is multiple of 4 you will never win.
        // So job is to just check for multiple for 4.
        //4 8 12 16 20 24 28 32 36 40
        /*for (int i = 1; i < 10; ++i) {
            System.out.println(i*4 + " " + Integer.toBinaryString(i*4));

        }*/
        //notice last tow LSB are always zero.
        // to check number is divisible by 4, fasted way
        // and number with 11 if its zero then you lose, if its not zero you can win.

        //int a = 0b11111;
        return (n & 0b11) != 0;

    }
}
