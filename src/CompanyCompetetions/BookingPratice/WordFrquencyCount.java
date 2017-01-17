package CompanyCompetetions.BookingPratice;

import java.net.Inet4Address;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nikhi on 11/18/2016.
 * Given a stream of characters (e.g. acacabcatghhellomvnsdb)
 * and a list of words (e.g. ["aca","cat","hello","world"] )
 * find and display count of each and every word once the stream ends.
 * (Like : "aca" : 2 , "cat" : 1 , "hello" : 1 , "world" : 0 ).
 */
public class WordFrquencyCount {
    public static void main(String[] args) {
        String stream = "acacabcatghhellomvnsdb";
        String[] array = {"aca", "cat", "hello", "world"};

        System.out.println(findCount(array, stream));
    }
    public static Map<String, Integer> findCount(String[] array, String stream){
        Map<String, Integer> map = new HashMap<>();

        for (String token: array) {
            int length = token.length();
            map.put(token, 0);
            for (int i = 0; i <= stream.length() - length; i++) {
                if(token.equals(stream.substring(i, i+length))){
                    map.put(token, map.get(token)+1);
                }
            }
        }
        return map;
    }
}
