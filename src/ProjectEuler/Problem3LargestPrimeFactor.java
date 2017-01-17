package ProjectEuler;

import java.util.*;
/*
Let's say m = sqrt(n) then m × m = n.
Now if n is not a prime then n can be written as n = a × b, so m × m = a × b.
Notice that m is a real number whereas n, a and b are natural numbers.

Now there can be 3 cases:

a > m ⇒ b < m
a = m ⇒ b = m
a < m ⇒ b > m
In all 3 cases, min(a, b) ≤ m. Hence if we search till m, we are bound to find at least one factor of  n, which is enough to show that n is not prime.
 */
public class Problem3LargestPrimeFactor {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long number = in.nextLong();
            long primeFactor = 1;

            for (long factor = 2; factor*factor <= number ; factor++) {
                while(number%factor==0){
                    primeFactor = factor;
                    number /= factor;
                }
            }
            if(number>1) primeFactor = number;
            System.out.println(primeFactor);
        }
    }
}
