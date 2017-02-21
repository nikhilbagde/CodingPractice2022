package ProjectEuler.Set3;

import java.math.BigInteger;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Created by Nikhil on 2/8/2017 4:56 AM.
 */
public class P25NDigitFibonacci {
    static int MAX = 5000 + 7;
    static BigInteger[] arr;

    public static void main(String[] args) {
        /*arr = new BigInteger[MAX];
        arr[0] = new BigInteger("0");
        arr[1] = new BigInteger("1");

        for (int i = 2; i < MAX ; i++) {
            //arr[i] = new BigInteger(String.valueOf(i-1)).add(new BigInteger(String.valueOf(i-2)));
            arr[i] = arr[i-1].add(arr[i-2]);
        }
        for (int i = 0; i < MAX; i++) {
            out.println(arr[i].toString());
        }
        Scanner scanner = new Scanner(in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            N = (int) Math.pow(10,N-1);
            int result = 1;
            for (int i = 1; i < MAX; i++) {
                if(arr[i].divide(new BigInteger(String.valueOf(N))).compareTo(new BigInteger("1")) == 1) {
                    result = i;
                    //System.out.print(i + " ");
                    break;
                }
            }
            out.println("result = " + (result-1) );       //as arr start from 0.
        }
*/

        Scanner scanner = new Scanner(in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            int index = 2;
            BigInteger a = BigInteger.ONE;
            BigInteger b = BigInteger.ONE;
            while (b.toString().length() < N) {
                BigInteger c = a.add(b);
                a = b;
                b = c;
                ++index;
            }
            out.println(index);
        }
    }
}
