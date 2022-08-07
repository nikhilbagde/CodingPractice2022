package ProjectEuler.Set1;

import java.util.Scanner;

/**
 * Created by Nikhil on 1/29/2017 4:49 AM.
 */
public class P6SumSquareDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while(T-- >0){
            int N = scanner.nextInt();
            long sumOfSquare = (N*(N+1)*(2*N + 1))/6;
            long squareOfSumOfNumber = (N*(N+1)/2);
            long result = squareOfSumOfNumber * squareOfSumOfNumber - sumOfSquare;
            System.out.println("result = " + result);
        }
    }
}
