package Algorithm.Recursion;

import java.util.Scanner;

/**
 * Created by Nikhi on 4/20/2017.
 */
public class PowerSum {
    public static void main(String[] args) {
        int  sum  = new Scanner(System.in).nextInt();
        int  power = new Scanner(System.in).nextInt();

        int result = 0;
        for(int i=1; i< sum; i++)
            result += canSumTo(i, sum, power);
        System.out.println(result);

    }

    private static int isPowerSum(int num, int sum, int power) {
        int result = 0;
        if(sum==0) return 1;
        if( (int) Math.pow(num, power) == sum) return 1;
        //for rest of the numbers
        for (int i = num+1; i < sum; i++) {
            result += isPowerSum(i, sum- (int) Math.pow(i, power), power);
        }
        return result;
    }

    public static int canSumTo(int k, int x, int n) {
        int rest = (int) (x - Math.pow(k, n));
        if (rest == 0) {
            return 1;
        } else if (rest < 0) {
            return 0;
        }

        int r = 0;
        for (int i = k+1; i < rest; i++) {
            r += canSumTo(i, rest, n);
        }
        return r;
    }
}
