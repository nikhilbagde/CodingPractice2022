package ProjectEuler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;

/**
 * Created by Nikhi on 12/13/2016 6:41 AM.
 */
public class EvenFibonnaci {
    public static void main(String[] args) throws IOException {
        BufferedReader  in = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(in.readLine());
        assert (1<= testCases && testCases <= Math.pow(10,5));
        BigInteger sum = new BigInteger("0");
        BigInteger Finalsum = new BigInteger("0");
        while(testCases-- >0){
            long N = Long.parseLong(in.readLine());
            assert (10<= N && N<= 4E16);
            long a = 1, b = 2;
            System.out.print(a+" "+b +" ");
            for (int i = 3; i < N; i++) {
                //sum = sum.add(new BigInteger(String.valueOf(a)));
                sum = sum.add(new BigInteger(String.valueOf(b)));
                if(sum.mod(new BigInteger(String.valueOf(2))).equals(BigInteger.ZERO)){
                    Finalsum = sum;
                }
                a = b;
                b = Long.valueOf(sum.toString());
                System.out.print(b +" ");
            }
            System.out.println(Finalsum);
        }


    }
}
