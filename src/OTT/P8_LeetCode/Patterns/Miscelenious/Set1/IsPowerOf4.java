package LeetCode.Patterns.Miscelenious.Set1;

/**
 * Created by Nikhil on 1/21/2017 3:27 PM.
 */
public class IsPowerOf4 {
    private static boolean isPowerOf4(int n){
        return n>0 && n== Math.pow(4, Math.round(Math.log(n)/Math.log(4)));
    }

    public static void main(String[] args) {
        boolean result = isPowerOf4(16);
        System.out.println("result = " + result);
    }
}
