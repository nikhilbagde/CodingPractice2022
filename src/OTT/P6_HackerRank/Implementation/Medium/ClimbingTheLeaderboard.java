package OTT.P6_HackerRank.Implementation.Medium;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by nbagde on 8/19/2018.
 */
public class ClimbingTheLeaderboard {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //System.out.println(Long.MAX_VALUE);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i]= scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i]= scanner.nextInt();
        }
        climbingLeaderboard(a,b);

    }

    private static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int duplicateCount = 0;
        for (int i = 1; i < scores.length; i++) {
            if (scores[i]==scores[i-1])
                duplicateCount++;
        }
        System.out.println(duplicateCount);
        int [] rank = new int[scores.length-duplicateCount];
        rank[0] = scores[0];
        int count = 1;
        for (int i = 1; i < scores.length; i++) {
            if(scores[i]!=scores[i-1])
                rank[count++] = scores[i];
        }
        System.out.println(Arrays.toString(rank));

        int[] result = new int[alice.length];
        int resultCounter = 0;
        for (int i = 0; i < alice.length ; i++) {
            int index = Arrays.binarySearch(rank, alice[i]);
            if(index<0) {
                index = findLowestMax(rank, alice[i]);
            }
            System.out.println(alice[i]> rank[0]? 1: (index==-2)? count+1: index);
            result[resultCounter++]=alice[i]> rank[0]? 1: (index==-2)? count+1: index;
        }
        //System.out.println(result);
        return result;
    }
    private static int findLowestMax(int[] rank, int score){
        if(rank.length>100){
            int middle = rank.length/2;
            if(rank[middle]<score){
                for (int i = 0; i < middle; i++) {
                    if(rank[i]<score)
                        return i+1;
                }
            }else {
                for (int i = middle; i < rank.length; i++) {
                    if(rank[i]<score)
                        return i+1;
                }
            }
        }
        for (int i = 0; i < rank.length; i++) {
            if(rank[i]==score){
                return i+1;
            }
            if(rank[i]<score)
                return i+1;
        }
        return -2;
    }
}

