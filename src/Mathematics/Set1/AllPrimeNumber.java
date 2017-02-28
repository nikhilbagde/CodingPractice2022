package Mathematics.Set1;

import java.util.Arrays;

/**
 * Created by Nikhil on 1/28/2017 4:52 PM.
 * Print all prime numbers less than equal to N.
 */
public class AllPrimeNumber {
    private static void printAllNPrime(int number){
        //step 1: create a boolean array of size n+1 and set it to true.
        boolean prime[] = new boolean[number+1];
        for (int i = 0; i < number; i++) {
            prime[i]= true;
        }

        //step 2: check for all prime and set its multiple to false.
        for (int i = 2; i*i < number; i++) {        // for i< square root of n or i*i< n (don't use square root as it return double value)
            if(prime[i]){
                for (int j = i*2; j <=number; j = j+i) {        //start j with next multiple of i | till last number | increment by i
                    prime[j] = false;           //set to false as we are setting multiples of that prime number to false
                }
            }
        }
        System.out.println("Arrays.toString(prime) = " + Arrays.toString(prime));
        for (int i = 2; i < number; i++) {
            if(prime[i]) System.out.print(" " + i);
        }
    }

    public static void main(String[] args) {
        printAllNPrime(50);
    }

    private static void generateAllPrime(int number) {
        boolean[] primes = new boolean[number + 1];

        for (int i = 0; i < primes.length; ++i) {
            primes[i] = true;
        }

        for (int i = 2; i < number; ++i) {
            if (primes[i]) {
                for (int j = i + i; j <= number; j = j + i) {
                    primes[j] = false;
                }
            }
        }

    }
}
