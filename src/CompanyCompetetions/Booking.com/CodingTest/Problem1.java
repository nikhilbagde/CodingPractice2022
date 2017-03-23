package CompanyCompetetions.Booking.com.CodingTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Nikhi on 12/7/2016.
 */
public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> set; //= new HashSet<>(4);
        int squareCount = 0, recCount = 0, polyCount = 0;
        while (sc.hasNextLine()) {
            String temp = sc.nextLine();
            if (temp.isEmpty()) break;
            set = new HashSet<>(Arrays.asList(temp.split(" ")));

            switch (set.size()) {
                case 4:
                    polyCount++;
                    break;
                case 2:
                    recCount++;
                    break;
                case 1:
                    squareCount++;
                    break;
            }
        }
        System.out.println(squareCount + " " + recCount + " " + polyCount);
    }
}

/*
Input
36 30 36 30
15 15 15 15
46 96 90 100
86 86 86 86
100 200 100 200
-100 200 -100 200

Output:
2 2 2
 */
