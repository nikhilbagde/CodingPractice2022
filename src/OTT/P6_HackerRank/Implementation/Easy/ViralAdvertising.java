package OTT.P6_HackerRank.Implementation.Easy;

import java.util.Scanner;

/**
 * Created by nbagde on 9/1/2018.
 */
public class ViralAdvertising {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfDays = scanner.nextInt();
        int numberOfCommulativeLikes = viralAdvertising(numberOfDays);
        System.out.println(numberOfCommulativeLikes);
    }
    private static int viralAdvertising(int n) {
        int[] likesArray = new int[51];

        int[] accumulatorLiked = new int[51];
        accumulatorLiked[0] = 0;
        for (int i = 1; i < likesArray.length ; i++) {
            if(i==1){
                likesArray[1]= 5;
            }else {
                likesArray[i] = Math.floorDiv(likesArray[i - 1], 2) * 3;
            }
            accumulatorLiked[i] = accumulatorLiked[i-1] + Math.floorDiv(likesArray[i],2);
        }
        //System.out.println(Arrays.toString(likesArray));
        //System.out.println(Arrays.toString(accumulatorLiked));
        return accumulatorLiked[n];
    }
}
