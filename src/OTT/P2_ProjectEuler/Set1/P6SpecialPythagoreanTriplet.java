package ProjectEuler.Set1;

import java.util.Scanner;

/**
 * Created by Nikhil on 1/28/2017 9:21 PM.
 * a < b < c
 * a + b + c = N
 * a2 + b2 = c2
 */
public class P6SpecialPythagoreanTriplet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while(T-- >0){
            int N = scanner.nextInt();
            long result = -1;
            for (int c = 1; c < N/2; ++c) {                   // b < c -> N+c/2 < c -> N+c = 2c -> N=C
                for (int b = (N-c)/2; b < N-c && b < c; ++b) {           // a < b -> (N-b-c) < b -> N-c < 2b  ->  N-c/2 < b  -> b[N-c/2,N-c]
                    int a = N - b - c;                  // a + b + c = N -> a = N - b-c
                    if(a > b) continue;
                    if(a*a + b*b == c*c)
                        result = Math.max(result, (long) a*b*c);   //once we find such a,b,c pair then find its a*b*c
                }
            }
            System.out.println("result = " + result);
        }
    }
}
