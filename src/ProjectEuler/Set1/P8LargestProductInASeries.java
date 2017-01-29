package ProjectEuler.Set1;

import java.util.Scanner;

/**
 * Created by Nikhil on 1/28/2017 8:57 PM.
 * Find the greatest product of K consecutive digits in the  N digit number.
 */
public class P8LargestProductInASeries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while(T-- > 0) {
            int N = scanner.nextInt(), K = scanner.nextInt();
            String number = scanner.next();
            int result = 0;
            for (int i = 0; i < N-K+1; ++i) {           //we have to start from 0 till K digits and before N-K end add 1 b/c/ we are starting from 0
                int mul = 1;
                for (int j = 0; j < K; ++j) {
                    mul =  mul * (number.charAt(j+i) - '0');
                }
                if(mul > result) result = mul;
            }
            System.out.println("result = " + result);
        }
    }
}

/*
2
10 5
3675356291
10 5
2709360626

 */