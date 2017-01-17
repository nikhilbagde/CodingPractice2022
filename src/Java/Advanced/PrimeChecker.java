package Java.Advanced;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.reflect.*;
/**
 * Created by Nikhi on 11/27/2016.
 * problem with using in variable in InputStreamReader -> Using Static import for Constansts
 * In is Static variable from java.lang.System class.
 * So import it like, import static java.lang.System.in
 */

import static java.lang.System.in;      //static import for static varible from those class hence can use directly
import static java.lang.System.out;
// hence instead of using System.in use in directly.

public class PrimeChecker {
    public static void main(String[] args) {
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(in));
            int n1=Integer.parseInt(br.readLine());
            int n2=Integer.parseInt(br.readLine());
            int n3=Integer.parseInt(br.readLine());
            int n4=Integer.parseInt(br.readLine());
            int n5=Integer.parseInt(br.readLine());
            Prime ob=new Prime();
            ob.checkPrime(n1);
            ob.checkPrime(n1,n2);
            ob.checkPrime(n1,n2,n3);
            ob.checkPrime(n1,n2,n3,n4,n5);
            Method[] methods=Prime.class.getDeclaredMethods();
            Set<String> set=new HashSet<>();
            boolean overload=false;
            for(int i=0;i<methods.length;i++)
            {
                if(set.contains(methods[i].getName()))
                {
                    overload=true;
                    break;
                }
                set.add(methods[i].getName());

            }
            if(overload)
            {
                throw new Exception("Overloading not allowed");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

}
class Prime{
    void checkPrime(int... arg){
        String output = "";
        for(int i : arg){
            if(isPrime(i)){
                output += i +" ";
            }
        }
        if(!output.equals(" ")){
            output = output.substring(0,output.length()-1);
            System.out.println(output);
        }
        System.out.println();

    }
    boolean isPrime(int number){
        if(number<2){
            return false;
        }
        for (int i = 0; i < number/2 +1; i++) {
            if(i%2==0){
                return false;
            }
        }
        return true;
    }
    void checkPrimeNew(int... number ){
        for (int i :number) {
            isPrimeUsingBigInteger(i);
        }
    }
    boolean isPrimeUsingBigInteger(int i){
        return BigInteger.valueOf(i).isProbablePrime(1);
    }

}
