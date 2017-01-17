package CompanyCompetetions.WeightWatcher;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Nikhi on 12/23/2016 8:01 PM.
 */
public class Problem3 {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().toLowerCase().replaceAll("\\s+","");

        Map<Integer,Boolean> map = new HashMap<>();

        /*int v1 = 'a'; //97
        int v2 = 'z'; //122
        int v3 = 'A'; //65
        int v4 = 'Z'; //90
        System.out.println(v1 + " " + v2 + " " + v3 + " " + v4);
        */
        for (int i = 97; i <  123; i++) {
            map.put(i, false);
        }
        System.out.println(isPangams(input, map));

    }
    private static String isPangams(String input, Map<Integer, Boolean> map){
        for (int i = 0; i < input.length(); i++) {
            if(map.containsKey((int) input.charAt(i))){
                map.put((int) input.charAt(i), true);
            }
        }

        if(map.containsValue(false)){
            return "not pangram";
        }

        /*for ( Map.Entry<Integer,Boolean> entry : map.entrySet() ) {
            if(!entry.getValue()){
                return "not pangram";
            }
        }*/

        return "pangram";
    }
}
