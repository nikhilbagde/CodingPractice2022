package CompanyCompetetions.Booking.com;

import java.util.*;

class ValueComparator implements Comparator<Integer>{
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    public ValueComparator(HashMap<Integer, Integer> map){
        this.map.putAll(map);
    }

    @Override
    public int compare(Integer s1, Integer s2) {
        if(map.get(s1) >= map.get(s2)){
            return -1;
        }else{
            return 1;
        }
    }
}

public class SortHotelListRef {
    public static TreeMap<Integer, Integer> sortMapByValue(HashMap<Integer, Integer> map){
        Comparator<Integer> comparator = new ValueComparator(map);
        TreeMap<Integer, Integer> result = new TreeMap<Integer, Integer>(comparator);
        result.putAll(map);
        return result;
    }

    public static void sortHotelReviews(String words, int M, int[] hotelIndex, String[] hotelReview) {
        HashMap<Integer, Integer> mapResult = new HashMap<>();
        HashSet<String> mapWords = new HashSet<>();
        words = words.replaceAll("[,.]", "");
        String[] splitWords = words.split(" ");
        for(int i = 0; i < splitWords.length; i++)
            mapWords.add(splitWords[i].toLowerCase());
        for(int i = 0; i < M; i++) {
            hotelReview[i] = hotelReview[i].replaceAll("[,.]", "");
            String[] splitHotelReview = hotelReview[i].split(" ");
            int count = 0;
            for(int j = 0; j < splitHotelReview.length; j++) {
                if(mapWords.contains(splitHotelReview[j].toLowerCase())) {
                    count++;
                }
            }
            if(mapResult.containsKey(hotelIndex[i]))
                mapResult.put(hotelIndex[i], mapResult.get(hotelIndex[i]) + count);
            else
                mapResult.put(hotelIndex[i], count);
        }
        TreeMap<Integer, Integer> sortedMap = sortMapByValue(mapResult);
        for(Integer i: sortedMap.keySet()) {
            System.out.print(i + " ");
        }
    }

    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        String words = in.nextLine();
        int M = Integer.parseInt(in.nextLine());
        int hotelIndex[] = new int[M];
        String hotelReview[] = new String[M];
        for(int i = 0; i < M; i++) {
            hotelIndex[i] = Integer.parseInt(in.nextLine());
            hotelReview[i] = in.nextLine();
        }
        sortHotelReviews(words, M, hotelIndex, hotelReview);
    }
}