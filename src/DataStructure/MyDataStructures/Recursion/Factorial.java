package DataStructure.MyDataStructures.Recursion;

import java.math.BigInteger;

/**
 * Created by Nikhil on 12/27/2016 3:07 PM.
 */
public class Factorial {
    public static void main(String[] args) {
        int n = 10;
        int fact = factorial(n);
        BigInteger factBig = factorialBigInterger(new BigInteger(String.valueOf(n)));
        BigInteger factBigIterative = factorialBigIntergerIterative(n);
        System.out.println(fact + " " + factBig + " " + factBigIterative);
    }
    private static int factorial(int n)throws IllegalArgumentException{
        if(n<0) throw new IllegalArgumentException();
        else if(n==0) return 1;
        else return n * factorial(n-1);
    }
    private static BigInteger factorialBigInterger(BigInteger n)throws IllegalArgumentException{
        if(n.compareTo(BigInteger.ZERO) == -1) throw new IllegalArgumentException();
        else if(n.compareTo(BigInteger.ZERO) == 0) return BigInteger.ONE;
        else return n.multiply(factorialBigInterger(n.subtract(BigInteger.ONE)));
    }
    private static BigInteger factorialBigIntergerIterative(int n)throws IllegalArgumentException{
        BigInteger factorial = new BigInteger("1");
        while(n>1){
            factorial = factorial.multiply(BigInteger.valueOf(n));
            n--;
        }
        return factorial;
    }
}
