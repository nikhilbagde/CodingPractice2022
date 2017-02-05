package ProjectEuler.Set2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Nikhil on 2/5/2017 3:21 AM.
 */
public class P16PowerDigitSum {
    final static int MAX = 1000+7;
    final static long[] sqr = new long[MAX];
    public static void main(String[] args) {
        sqr[0] = 1;
        sqr[1] = 2;
        for (int i = 2; i < MAX; i++) {        //notice max= 31 after 31 value repeats.
            //int number = i;
            long number = 1 << i;
            sqr[i] = number;
        }
        System.out.println(Arrays.toString(sqr));
        for (int i = 0; i < 1000; i++) {
            System.out.println(i +" " + getDigitSum(sqr[i]));
            //System.out.println(i+ " " + getDigitSum(i > 31 ? sqr[i%31]-1: sqr[i%31]));
        }
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            System.out.println(sqr[N] + " " + getDigitSum(sqr[N]));
            //System.out.println(getDigitSum(N > 31 ? sqr[N%31]-1: sqr[N%31] ));
        }
    }
    private static int getDigitSum(long number){
        int result = 0;
        while(number>0){                //1234
            result += (int) number % 10;
            number = number/10;
        }
        return result;
    }
}
