package LeetCode.Patterns.Miscelenious.Set1;

/**
 * Created by Nikhil on 1/21/2017 3:20 PM.
 */
public class IsPowerOf3 {
    /*
                number = 3^ Something
                take log, "log aaya dar gaya, udi mara daba diya"
                (Swap position of number and something in above formula  and suppress 3)
                Something = log(number) (to the base 3)
                Something = log(number) / log 3
     */
    private static boolean isPowerOf3(int number){
        return number>0 && number == Math.pow(3,  Math.round(     Math.log(number)/Math.log(3)    )       );
    }

    public static void main(String[] args) {
        boolean result = isPowerOf3(9);
        System.out.println("result = " + result);

        boolean result1 = isPowerOf3(64);
        System.out.println("result = " + result1);
    }
}


