package Algorithm.Implementation.Medium;

import java.util.Scanner;

/**
 * Created by Nikhil on 3/13/2017 9:09 PM.
 */
public class Soduku {
    static int s(int i, int j, int[][] g) {
        if (i > 8) {
            i = 0;
            if (++j > 8)
                return 1;

        }
        if (g[i][j] > 0)
            return s(i + 1, j, g);

        for (int v = 0; ++v <= 9; )
            if (l(i, j, v, g) > 0) {
                g[i][j] = v;
                if (s(i + 1, j, g) > 0)
                    return 1;

            }

        g[i][j] = 0;
        return 0;

    }

    static int l(int i, int j, int v, int[][] g) {
        for (int k = 0; k < 9; k++)
            if (v == g[k][j] || v == g[i][k] || v == g[i / 3 * 3 + k % 3][j / 3 * 3 + k / 3])
                return 0;
        return 1;
    }

    public static void main(String[] a) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), g[][] = new int[9][9], i = 0, j, l;
        for (; i++ < n; ) {
            for (j = 0; j < 81; )
                g[j / 9][j++ % 9] = s.nextInt();
            s(0, 0, g);
            for (l = 0; l < 81; )
                System.out.print(g[l / 9][l++ % 9] + " ");

        }

    }

}
/*
Sample Input

2
0 0 0 0 0 0 0 0 0
0 0 8 0 0 0 0 4 0
0 0 0 0 0 0 0 0 0
0 0 0 0 0 6 0 0 0
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
2 0 0 0 0 0 0 0 0
0 0 0 0 0 0 2 0 0
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
0 0 8 0 0 0 0 4 0
0 0 0 0 0 0 0 0 0
0 0 0 0 0 6 0 0 0
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
2 0 0 0 0 0 0 0 0
0 0 0 0 0 0 2 0 0
0 0 0 0 0 0 0 0 0
Sample Output

3 4 5 6 7 8 9 1 2
6 7 8 9 1 2 3 4 5
9 1 2 3 4 5 6 7 8
1 2 3 4 5 6 7 8 9
4 5 6 7 8 9 1 2 3
7 8 9 1 2 3 4 5 6
2 3 4 5 6 7 8 9 1
5 6 7 8 9 1 2 3 4
8 9 1 2 3 4 5 6 7
3 4 5 6 7 8 9 1 2
6 7 8 9 1 2 3 4 5
9 1 2 3 4 5 6 7 8
1 2 3 4 5 6 7 8 9
4 5 6 7 8 9 1 2 3
7 8 9 1 2 3 4 5 6
2 3 4 5 6 7 8 9 1
5 6 7 8 9 1 2 3 4
8 9 1 2 3 4 5 6 7
 */