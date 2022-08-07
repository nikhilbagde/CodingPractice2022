package ProjectEuler.Set2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Nikhil on 2/5/2017 2:24 AM.
 * Starting in the top left corner of a  2x2 grid,
 * and only being able to move to the right and down,
 * there are exactly 6 routes to the bottom right corner.
 *
 *  How many such routes are there through a N x M grid?
 *  As number of ways can be very large, print it modulo .
 *  Input Format
 *  The first line contains an integer T, i.e., number of test cases.
 *  Next T lines will contain integers N (1<N<500)and M(1<N<1000).
 */
public class P15LatticePaths {
    private final static int MOD = 1000000 + 7;
    private final static int MAX = 10;
    private static int[][] comb = new int[MAX][MAX];

    public static void main(String[] args) {
        comb[0][0] = 1;

        for (int i = 1; i < MAX; ++i) {
            comb[i][0] = 1;
            for (int j = 1; j <= i; ++j) {
                comb[i][j] = (comb[i-1][j-1] + comb[i-1][j]) % MOD;
            }
        }
        System.out.println(Arrays.deepToString(comb));

        printPascalTriangle(comb);

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            System.out.printf("N+M=%d , M=%d ", N+M, M);
            System.out.println("result = comb["+(N+M)+"]["+M+"]="+  comb[N+M][N]);     //? comb[N+M][N]
         }
    }
    private static void printPascalTriangle(int[][] comb){
        System.out.print("\t");
        for (int i = 0; i < MAX; i++) {
            System.out.printf("%7d ", i);
        }
        System.out.println();
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j <=i ; j++) {
                if(j==0) System.out.print(i+"\t");
                System.out.printf("%7d ",comb[i][j]);
            }
            System.out.println();
        }
    }
}
