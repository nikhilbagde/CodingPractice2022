package LeetCode.Patterns.SlidingWindow;


import java.util.HashMap;
import java.util.Map;

/**
 * @author Nikhil Bagde
 * @date 5/10/2021- 12:17 AM
 **/
public class P_76_Min_Windows {
    public static void main(String[] args) {
//Input: s = "ADOBECODEBANC", t = "ABC"
        //Output: "BANC"
        // test case https://leetcode.com/submissions/detail/491166498/testcase/  = failing
        String s = minWindow("ADOBECODEBANC", "ABC");
        System.out.println("s = " + s);
    }

    public static String minWindow(String s, String t) {
        //Input: s = "ADOBECODEBANC", t = "ABC"
        //Output: "BANC"
       /*
        int[] countT = new int[26];
        int[] countS = new int[26];

        for(char c: t.toCharArray()){
            countT[c-'a']++;
        }
        int start = 0;
        for(int end =0; end < s.length(); end++){
            countS[s.charAt(end) - 'a']++;
            if(containsAllChars(countS, countT)){ // BLOCKER: JUMP 1
                minLength = Math.min(minLenght, end-start+1);
            }
        }
        */
        //JUMP 1:its hard to determine if two char arrays are same
        //as we cannot stop as we need to keep growing untill we cover all
        // unique counts of char from T.

        // we can keep count of unique chars using HashMap key set size.

        if(s.length()==0 || t.length()==0) return "";

        Map<Character, Integer> mapT = new HashMap<>();
        for(char c: t.toCharArray()){
            mapT.put(c, mapT.getOrDefault(c,0)+1);
        }

        //to match size of unique chars.
        int requiredSize = mapT.keySet().size(); //mapT.size();
        int achivedSize = 0;


        Map<Character, Integer> mapS = new HashMap<>();
        int start = 0;
        int minSize = s.length()+1;

        Pair<Integer,Integer> pair = new Pair(0,0);

        for(int end =0; end< s.length(); end++){


            //mapS.put(s.charAt(end), mapS.getOrDefault(s.charAt(end)+1)); ---> get will give Integer value. Compilation error. Need to either convert to int or use intVal()
            mapS.put(s.charAt(end), mapS.getOrDefault( s.charAt(end), 0)+1);

            //check if current character is in T map
            //And it its frequency is same.
            // Then we are closer to achivedSize. incremet it.
            if(mapT.containsKey(s.charAt(end))   // BUG: not map.constains() -> map.containsKey()
                    && mapS.get(s.charAt(end)) == mapT.get(s.charAt(end))){
                achivedSize++;
            }

            //if finally sometime we get achivedSize == requiredSize
            //not we need to stragetically move start pointer
            //BUT also need to make sure, start char is part
            //of T map with same frequency, if YES, we need
            // to decrement achivedSize. + decreament current count
            // from S Map.
            //Now this could cross paths of start and end. so make sure start<end
            while(start< end && achivedSize == requiredSize){
                //minSize = Math.min(minSize, end-start+1);
                if(end-start+1 < minSize ){
                    pair = new Pair(start, end);
                    minSize = end-start +1;
                }
                //check character we are going to move from
                //if its character from Tmap, meaning helped us
                //for achivedSize? if yes, decrement achivedSize
                char startChar = s.charAt(start);
                if(mapT.containsKey(startChar)
                        && mapT.get(startChar) == mapS.get(startChar)){
                    achivedSize--;
                }
                //decrease the frequency
                mapS.put(startChar, mapS.get(startChar)-1);
                start++;
            }
        }
        return (minSize == s.length()+1) ? "":  s.substring(pair.first, pair.second+1);
    }

    private static class Pair<T,C>{
        T first;
        C second;

        Pair(T t, C c){
            first = t;
            second = c;
        }

        public T getObj1() {
            return first;
        }

        public C getObj2() {
            return second;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "first=" + first +
                    ", second=" + second +
                    '}';
        }
    }
}
