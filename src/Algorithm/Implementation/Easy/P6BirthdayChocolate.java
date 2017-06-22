package Algorithm.Implementation.Easy;

import java.util.Scanner;

/**
 * Created by nbagde on 6/21/2017.
 */
public class P6BirthdayChocolate {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
        for(int s_i=0; s_i < n; s_i++){
            s[s_i] = in.nextInt();
        }
        int d = in.nextInt();
        int m = in.nextInt();
        int result = solve(n, s, d, m);
        System.out.println(result);

    }
    static int solve(int n, int[] s, int d, int m){
        //month 1-12
        //day 1-31
        int resultCount = 0;
        if(m < s.length) {
            for (int i = 0; i < s.length - m - 1; i++) {
                int sum = 0;
                for (int j = i; j < i + m; j++) {
                    sum += s[j];
                }
                if(sum == d){
                    resultCount++;
                    continue;
                }
            }
        }else if( s.length == 1 && m == 1){
            resultCount =1;
        }
        //System.out.println(resultCount);
        return resultCount;
    }
}
