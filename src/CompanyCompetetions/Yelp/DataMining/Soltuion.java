package CompanyCompetetions.Yelp.DataMining;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Nikhil on 2/5/2017 11:09 PM.
 */
class Solution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < number1; i++) {
            int key = scanner.nextInt();
            int value = scanner.nextInt();
            map.put(key, value);
        }
        int product = 0;
        for (int i = 0; i < number2; i++) {
            int key = scanner.nextInt();
            int value = scanner.nextInt();
            if (map.containsKey(key))
                product += map.get(key) * value;
        }
        System.out.println(product);
    }
}