package Contest.WorldCodeSprint8.Solution;

import java.util.*;

/**
 * 1. Binary Search = Notice value of min = mid + ((max-min)<<1);
 *      and while loop should run if(min<=max)
 * 2. Pass initial max value as 1 minus total size of an array.
 * 3. Remember to check for values which are not in array case. return -1 and handle that case.
 * 4. I learnt from this problem to consider edge cases, and how handle long input, binary search is efficient solution.
 * 5. Still lack in speed. (First write down the algorithm by solving example) Then start writing code fast.
 * Created by Nikhi on 12/17/2016 12:21 PM.
 */
public class P2_ClimingTheLeaderBoard {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] scores = new int[n];
        int[] rank = new int[n];
        Map<Integer,List<String>> rankMap = new LinkedHashMap<>();
        int currentRank = 0;
        for(int scores_i=0; scores_i < n; scores_i++){
            int score = in.nextInt();
            scores[scores_i] = score;
            //rank[scores_i] = currentRank + 1;
            if(scores_i>0){
                rank[scores_i] = scores[scores_i-1]== score ? rank[scores_i-1] : rank[scores_i-1]+1;
            }else {
                rank[scores_i] = currentRank +1;
            }
            currentRank = processLeaderBoardUsingMap(rankMap, score, currentRank);
        }
        int m = in.nextInt();
        int[] alice = new int[m];
        for(int alice_i=0; alice_i < m; alice_i++){
            int aliceCurrentScore = in.nextInt();
            alice[alice_i] = aliceCurrentScore;
            //int index = 0;
            //int index = Arrays.binarySearch(scores, aliceCurrentScore);
            int index = binarySearch(scores, aliceCurrentScore);
            /*while(index< scores.length && scores[index] > aliceCurrentScore ){
                index++;
            }*/
            //System.out.println(index>= rank.length ? rank[index-1]+1: rank[index]);
            System.out.println( (index== -1 || index >= rank.length)? rank[rank.length-1]+1: rank[index]);
        }

    }
    private static int binarySearch(int[] scores, int aliceCurrentScore){
        return binarySearch(scores, aliceCurrentScore, 0, scores.length-1);
    }
    private static int binarySearch(int[] scores, int aliceCurrentScore, int min , int max){
        if(min<=max) {
            int mid = min + ((max-min) >> 1);
            if(scores[mid] == aliceCurrentScore){
                return mid;
            }
            if(max-min <= 2){
                int index = min;
                while(index<= max && scores[index] > aliceCurrentScore ){
                    index++;
                }
                return index;
            }
            if(aliceCurrentScore > scores[mid]){
                return binarySearch(scores, aliceCurrentScore, min, mid-1);
            }
            return binarySearch(scores, aliceCurrentScore, mid+1, max);
        }
        return -1;
    }

    private static int processLeaderBoardUsingMap(Map<Integer, List<String>> rankMap, int score, int currentRank){
        if(!rankMap.containsValue(score)){
            rankMap.put(score, Arrays.asList(String.valueOf(currentRank+1)));
        }else {
            List<String> lastRankList = rankMap.get(score);
            String  lastRankString = lastRankList.get(lastRankList.size()-1);
            //String lastRankString = rankMap.get(score).toString();
            int lastRank = Integer.parseInt(lastRankString)+1;

            lastRankString = String.valueOf(lastRank);
            lastRankList.add(lastRankString);
            rankMap.put(score, lastRankList);

            currentRank = lastRank;
        }
        return currentRank;
    }
}
