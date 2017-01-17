package CompanyCompetetions.Booking.com.CodingTest;

import java.util.Scanner;

/**
 * Created by Nikhi on 12/7/2016 8:34 PM.
 * https://www.hackerrank.com/contests/booking-passions-hacked-backend/challenges/destinations-together-3
 */
public class Problem6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int citiesJohn = sc.nextInt();
        int citiesZizy = sc.nextInt();
        int citiesCommon = sc.nextInt();
        /*
        3 4 2
        Unique 1 + 2 + 2 = 5
        https://www.mathsisfun.com/combinatorics/combinations-permutations.html
        in combination order doesn't matter
        In permutation it does - check (it will give us different paths)
        we have 5 unique places to visit.
        _ _ _ _ _ = first place can be anything out of 5 = 5 choices, 2nd place = 4 choices, 3rd place = 3 choices
        , 4th place = 2 choices , 5th place = 1 choice. = 5*4*3*2*1= 24 ways
         */
    }
}
