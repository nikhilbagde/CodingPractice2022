package CompanyCompetetions.Booking.com;

import java.util.Scanner;

/**
 * Created by Nikhi on 11/23/2016.
 */
public class IsSumofPairExists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        int size = scanner.nextInt();
        int[] list = new int[size];

        for (int i = 0; i < size ; i++) {
            list[i] = scanner.nextInt();
        }
        System.out.println(isSumofPairExists(list, sum) ? "1" : "0");
    }
    private static boolean isSumofPairExists(int[] list, int sum){
        int [] memorize = new int[list.length];
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length; j++) {
                if(i==j) continue;



                if(list[i]+list[j] == sum){
                    return true;
                }
            }
        }
        return false;
    }
}
