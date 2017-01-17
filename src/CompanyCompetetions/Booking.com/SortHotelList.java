package CompanyCompetetions.Booking.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.*;

/**
 * Created by Nikhi on 11/23/2016.
 */
public class SortHotelList {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //remove . and ,
        String[] givenReviews = br.readLine().replaceAll("[.,]","").toLowerCase().split("\\s+");
        List<String> givenWordlist = Arrays.asList(givenReviews);

        Map<Integer, Integer> hotelToCustomerReviewMap = new HashMap<>();
        //Map<Integer, String> CustomerReviewMap = new HashMap<>();
        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        int reviewsCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < reviewsCount; i++) {
            int hotelID = Integer.parseInt(br.readLine());
            //Important Line 1.Parse 2.Convert to Arrays of String 3.Covert To List
            List<String> wordsInReview = Arrays.asList(br.readLine().replaceAll("[.,]","").toLowerCase().split("\\s+"));
            wordFrequencyMap = setWordFrequencyMap(wordFrequencyMap, wordsInReview, givenWordlist);
            int totalFrequency = getTotalFrequency(wordFrequencyMap);
            // Above three lines can be combined, No need to use List, or Map, Directly get frequency Count.

            if(!hotelToCustomerReviewMap.containsKey(hotelID)) {
                hotelToCustomerReviewMap.put(hotelID, totalFrequency);
            }else{
                // Else add new words frequency to original total Frequency.
                hotelToCustomerReviewMap.put(hotelID, hotelToCustomerReviewMap.get(hotelID) + totalFrequency);
            }
        }

        //sortBySimilarWordCount(CustomerReviewMap, givenReviews);

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