package LeetCode.Math.Set1;

/**
 * Created by Nikhil on 1/21/2017 3:31 PM.
 */
public class IsPowerOfGivenNumber {
    private static boolean isPowerOfGivenNumber(int number, int base){
        return number>0 && number == Math.pow(base, Math.round(Math.log(number)/Math.log(base)) );
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfGivenNumber(25, 5) ? "YES" : "NO");
        System.out.println(isPowerOfGivenNumber(144, 12) ? "YES" : "NO");
        System.out.println(isPowerOfGivenNumber(625, 25) ? "YES" : "NO");
        System.out.println(isPowerOfGivenNumber(49, 7) ? "YES" : "NO");
    }
}
