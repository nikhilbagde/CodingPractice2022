package CompanyCompetetions.Booking.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Nikhi on 11/23/2016.
 */
public class SortHotelList2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //remove . and ,
        String[] givenReviewsArray = br.readLine().replaceAll("[.,]","").toLowerCase().split("\\s+");
        List<String> givenReviewslist = Arrays.asList(givenReviewsArray);

        HashMap<Integer, Integer> hotelToCustomerReviewMap = new HashMap<>();
        int reviewsCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < reviewsCount; i++) {
            int hotelID = Integer.parseInt(br.readLine());
            int totalFrequency = getTotalFrequency(br.readLine().replaceAll("[.,]","").toLowerCase().split("\\s+"), givenReviewslist);
            if(!hotelToCustomerReviewMap.containsKey(hotelID)) {
                hotelToCustomerReviewMap.put(hotelID, totalFrequency);
            }else{
                // Else add new words frequency to original total Frequency.
                hotelToCustomerReviewMap.put(hotelID, hotelToCustomerReviewMap.get(hotelID) + totalFrequency);
            }
        }
        System.out.println(hotelToCustomerReviewMap);
        HashMap<Integer,Integer> map  = new HashMap<>(hotelToCustomerReviewMap);

        //Doesn't Work!!!
        TreeMap<Integer,Integer> sortedHotelMapTry1 = new TreeMap<>((o1, o2) -> {
            //wow! :D
            return map.get(o1)> map.get(o2) ? -1 : (map.get(o1)<map.get(o2) ? 1 : (o1>o2? 1:-1));
        });
        sortedHotelMapTry1.putAll(map);
        System.out.println("Try 1" + map);

        //Try2 - works. Meaning creating class, and extending comparator is a must.
        TreeMap<Integer,Integer> sortedHotelMapTry2 = new TreeMap<>(new ValueComparatorForMap(hotelToCustomerReviewMap));
        sortedHotelMapTry2.putAll(hotelToCustomerReviewMap);
        System.out.println("Try 2" + sortedHotelMapTry2);
        //sortBySimilarWordCount(CustomerReviewMap, givenReviews);

        //Try 3: New Method to sort
        //Section 3:
        //Comaprator things
        /* This is for not MAp.
        0)
            ArtistCompare artistCompare = new ArtistCompare();
            Collections.sort(songList, Collections.reverseOrder(artistCompare));
        1)
            Comparator<Song> songRatingComparator = Comparator.comparing(Song::getRating);
            Collections.sort(songList, songRatingComparator.reversed());
            And you can, of course, also use the Streams framework:

        2)
            List<Song> sortedSongList = songList.stream()
                .sorted(Comparator.comparing(Song::getRating).reversed())
                .collect(Collectors.toList());*/


    }
    private static void sortBySimilarWordCount(Map<Integer,String > hotelReviewMap, String[] words){
        // Form a set of all words from given String
        Set<String> uniqueWordSet = getUniqueWordSet(words);
        // Find frequency of words in each review from given String.

    }
    private static Set<String> getUniqueWordSet(String[] wordsArray){
        Set<String> uniqueWordsSet = new HashSet<>();
        for (int i = 0; i < wordsArray.length; i++) {
            uniqueWordsSet.add(wordsArray[i]);
        }
        return uniqueWordsSet;
    }
    private static Map<String, Integer> setWordFrequencyMap(Map<String,Integer> wordFrequencyMap, List<String> wordsInReview, List<String> givenwordList){
        //int frequency = 0;
        for (String word: wordsInReview) {
            //first check if word in review is in given words list.
            if(givenwordList.contains(word)) {
                //Set the frequency Map.
                if (!wordFrequencyMap.containsKey(word)) {
                    wordFrequencyMap.put(word, 1);
                } else {
                    wordFrequencyMap.put(word, wordFrequencyMap.get(word) + 1);
                }
            }
        }
        return wordFrequencyMap;
    }
    private static int getTotalFrequency(Map<String, Integer> wordFrequencyMap){
        int totalFrequncy = 0;
        for (Integer frequency : wordFrequencyMap.values()) {
            totalFrequncy += frequency;
        }
        return totalFrequncy;
    }
    private static int getTotalFrequency(String[] reviewArray, List<String> givenReviewList){
        int totalFrequency = 0;

        for (String word: reviewArray) {
            //change string[] to list because can use contain function easily.
            if(givenReviewList.contains(word)){
                totalFrequency++;
            }
        }
        return totalFrequency;
    }

}
class ValueComparatorForMap implements Comparator<Integer>{
    HashMap<Integer,Integer> map = new HashMap<>();
    ValueComparatorForMap(Map<Integer,Integer> mapIn){
        this.map.putAll(mapIn);
    }
    @Override
    public int compare(Integer o1, Integer o2){
        return map.get(o1)>map.get(o2) ? -1 : (map.get(o1)<map.get(o2)? 1: (o1>o2 ? 1 :-1));
    }
}
/*
breakfast beach citycenter location metro view staff price
5
1
This hotel has a nice view of the citycenter. The location is perfect.
2
The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth.
1
Location is excellent, 5 minutes from citycenter. There is  also a metro station very close to the hotel.
1
They said I couldn't take my dog and there were other guests with dogs! That is not fair.
2
Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter.


*/