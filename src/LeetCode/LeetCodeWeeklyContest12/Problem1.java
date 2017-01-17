package LeetCode.LeetCodeWeeklyContest12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Nikhi on 12/10/2016 10:00 PM.
 */
public class Problem1 {
    public static void main(String[] args) throws IOException {
        /*
        Find minimum radius of heater so that all the houses could be covered
         */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();
        String [] lineA = line.split(",");
        int[] houses  = new int[lineA.length];

        for (int i = 0; i < lineA.length; i++) {
            houses[i] = Integer.parseInt(lineA[i]);
        }
        line = bufferedReader.readLine();
        String [] lineB = line.split(",");

        int [] heaters = new int[lineB.length];

        for (int i = 0; i < lineB.length; i++) {
            heaters[i] = Integer.parseInt(lineB[i]);
        }

        findRadius(houses, heaters);
    }
    /*
    123 2
     */
    private static int findRadius( int[] houses, int[] heaters){
        Arrays.sort(houses);
        Arrays.sort(heaters);
        List housesL = Arrays.asList(houses);
        List heatersL = Arrays.asList(heaters);

        for (int heater = 0; heater < heatersL.size(); heater++) {
            int heaterIndex = housesL.indexOf(heatersL.get(heater));
            int radiumfromFirst = Math.abs(heaterIndex - housesL.indexOf(0));
            int radiumfromLast = Math.abs( housesL.indexOf(housesL.size()-1) - heaterIndex);
            int maxRadius = radiumfromFirst < radiumfromLast ? radiumfromLast : radiumfromFirst;
        }
        return 0;
    }
}
