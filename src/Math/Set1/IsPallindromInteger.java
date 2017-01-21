package Math.Set1;

/**
 * Created by Nikhil on 1/21/2017 1:27 PM.
 */
public class IsPallindromInteger {
    private static boolean isPallindrom(int number){
        if(number<0) return false;
        else return number == reverseInteger(number);
    }
    private static int reverseInteger(int number){
        int result = 0;
        while(number!=0){
            result = result *10 + number%10;
            number/=10;
        }
        return result;
    }

    public static void main(String[] args) {
        boolean result = isPallindrom(121);
        boolean result1 = isPallindrom(1221);
        boolean result2 = isPallindrom(10021);
        System.out.println("result = " + result);       //expected true
        System.out.println("result = " + result1);      //expected true
        System.out.println("result = " + result2);      //expected false
    }
}
