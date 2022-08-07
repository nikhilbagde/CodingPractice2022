package OTT.P8_LeetCode.Tags.Random_Math;

import java.util.Arrays;
import java.util.Scanner;

public class P_492_B_MinimumDIstanceToLitWholeStreet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfLights = scanner.nextInt();
        int lengthOfStreet = scanner.nextInt();
        int [] lightPositionArray = new int[numOfLights];
        for (int i = 0; i < numOfLights; i++) {
            lightPositionArray[i] = scanner.nextInt();
        }
        Arrays.sort(lightPositionArray);
        double maxDistanceBetweenTwoPoints = lightPositionArray[0];
        for (int i = 1; i < lightPositionArray.length; i++) {
            int distance = lightPositionArray[i] - lightPositionArray[i-1];
            if(distance> maxDistanceBetweenTwoPoints)
                maxDistanceBetweenTwoPoints = distance;
        }
        //if no light at both corners check what is the distance with most closest light from both ends.
        // take max of it
        maxDistanceBetweenTwoPoints= maxDistanceBetweenTwoPoints/2;
        if(lightPositionArray[0]!=0){
            maxDistanceBetweenTwoPoints = Math.max(maxDistanceBetweenTwoPoints, lightPositionArray[0]);
        }
        if(lightPositionArray[lightPositionArray.length-1] != lengthOfStreet ){
            maxDistanceBetweenTwoPoints = Math
                    .max(maxDistanceBetweenTwoPoints, lengthOfStreet-lightPositionArray[lightPositionArray.length-1]);
        }
        System.out.println(maxDistanceBetweenTwoPoints);
    }
}
