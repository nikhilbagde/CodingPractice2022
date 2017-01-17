package Contest.WeekOfCode26.MySolutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Optimal Path Problem
 * Created by Nikhi on 12/11/2016 7:01 PM.
 */
public class StreetParade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Number of dividing points of concert
        int n = scanner.nextInt();
        //All Points on axis
        int[] locations = new int[n];
        for (int i = 0; i < n; i++) {
            locations[i] = scanner.nextInt();
        }
        //Total Distance he plan to cover in +ve direction
        int expectedDistance = scanner.nextInt();
        //Min numbers of hours he can spend at any concert
        int minHours = scanner.nextInt();
        //Max number of time he can spend on any concert.
        int maxHours = scanner.nextInt();

        //objective: to find optimal location from where he can start.
        System.out.println(findOptimalStartPoint(locations, expectedDistance, minHours, maxHours));

    }
    private static int findOptimalStartPoint(int []locations, int expectedDistance, int minHours, int maxHours){

        //Iterate Over all Points
        //Find distance between first and second point
        //Match this distance with available Hours (Min Or Max)
        // its min then decrease it from total distance he has to cover.
        for (int firstLocation = 0; firstLocation < locations.length-1; firstLocation++) {
            int difference = Math.abs(locations[firstLocation] - locations[firstLocation+1]);
            if(difference == minHours || difference== maxHours){
                expectedDistance -= difference;
            }
        }
        //finally negative any one of max/min distance from expectedDistance
        // Menaing from last point he will again attain any concert for that much time.
        //I consider min time to negate
        expectedDistance = expectedDistance - minHours;
        int remainingDistance = expectedDistance;
        //Get reminaing distance
        //Negate it from starting location of array.
        //Thats the optimal point to start.
        int startingLocation = locations[0];
        int optimalFinalStartingPoint = startingLocation - remainingDistance;
        return optimalFinalStartingPoint;
    }
}

/*
Failed;
3
1 3 5
4 3 4
 */