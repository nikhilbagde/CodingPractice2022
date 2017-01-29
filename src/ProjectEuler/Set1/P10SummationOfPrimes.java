package ProjectEuler.Set1;

import java.util.Scanner;

/**
 * Created by Nikhil on 1/28/2017 11:57 PM.
 */
public class P10SummationOfPrimes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        final int MAX = 1000007;
        boolean[] prime = new boolean[MAX];
        long[] primeSummation = new long[MAX];
        for(int i=0; i<MAX ;i++) prime[i] = true;        //to cover this loop changed following code

        for (int i = 2; i < MAX; i++) {
            if (prime[i]) {
                for (int j=i+i; j<MAX; j=j+i) {
                    prime[j] = false;             //means not prime
                }
            }
        }
        //This will have summation till nth prime number preComputed.
        //So directly for given N number we can directly have that summation of prime till Nth.
        //SO beforehand calculate this, but what should be max value. It maximum value given or possible array can store.
        for (int i = 2; i < MAX; i++) {
            primeSummation[i] = primeSummation[i-1] + (prime[i] ? i: 0);        //if its prime add that ith value or just add nothing meaning zero.
        }
        for(int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();

            /*int accumulator = 0;            //as we  need summation.
            for (int i = 2; i < n; i++) {
                if (prime[i]) {
                    accumulator += i;
                }
            }*/
            System.out.println(primeSummation[n]);
        }
    }
}
