package LeetCode.CompanyBased.Facebook;

import java.util.*;

public class P_438_FindAnagram {
    public static void main(String[] args) {

        String s = "cbaebabacd";
        String p = "abc"; //        "abab"         "ab"

        //Failed
        String s1 = "acdcaeccde";
        String p1 = "c";

        //Failed  // I am assumping to put true for character boolean, for duplicates it wont know how many duplicate characters are there in p
        // hence for aab it will be [true, ture, false, rest all false]
        // while checking it for bab = true true , matches. comes as true which is wrong.
        String s2 = "ababababab";
        String p2 = "aab";
        //expected: [0,2,4,6]
        List<Integer> result = findAnagrams(s2, p2);  //incorrect.
        result = findAnagrams2(s2, p2);                          //correct  7ms
        result = findAnagrams3(s2, p2);                          //copied 5ms   BEST
        result = findAnagram4(s2, p2);                          //copied correct
        System.out.println("result = " + result);

    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        boolean[] arr = new boolean[26];
        for (char c : p.toCharArray())
            arr[c - 'a'] = true;

        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            String sub = s.substring(i, p.length() + i);
            boolean[] arr2 = new boolean[26];                   //only with boolean allCovered we cant be sure. p= abc s=abb this will set all covered = true.
            //boolean allCovered = true;                              //but c is missing. hence creating new arr2. will set all character of this array from current subString
            boolean allCovered2 = true;
            boolean unMatchedFound = false;
            for (char c : sub.toCharArray()) {
                arr2[c - 'a'] = true;
                if (!arr[c - 'a']) {
                    //allCovered = false;
                    i = s.indexOf(c, i);                           //faster jump.      //infinite loop.  s = acaeccde p= c, a not mached; i= index of a = 0; when i=1,matched, i=2, unmatched: s.indexof('a')=0. back to zero. Infinite loop.
                    // if in current substring any of the character is not matched meaning whole string not matched
                    unMatchedFound = true;
                    allCovered2 = false;
                    break;                                          // i can be set to curent unmarched character. anyways i++ in for loop will increament i to next position
                }                                                       // this is how we dont need to test rest of the character of current substring. We can start from next substring
            }                                                           //starting from next character of current unmatched character of current subString
//            if(allCovered){
//                result.add(i);
//            }
            if (!unMatchedFound) {
                for (int j = 0; j < 26 && allCovered2; j++) {              // allCovered2 can be added to for condition && allCovered2, once its false it wont go further
                    if (arr[j] != arr2[j]) {
                        allCovered2 = false;
                        break;  //enhancement: if found not matched. just break don't loop 26 times.2
                    }
                }
            }

            if (allCovered2) {
                result.add(i);
            }

        }
        return result;

    }

    /**
     * CORRECT   7 ms: 2nd fastest
     *
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams2(String s, String p) {
        List<Integer> result = new LinkedList<>();
        if (p.length() > s.length()) return result;

        //Since in anagram there can be duplicates we need to keep track of frequency
        //Hence using int and keeping count make sense and not boolean.

        int[] sCount = new int[26];
        int[] pCount = new int[26];

        /* Sliding Window: we will check frequency of all p.length elements of string s
        - every time we move window, we will increment the frequency of current character (ending)
        - and we will decrease the frequency of first character of the windows (starting)
        - so current status of both int array would have frequency of current window chars
        - Now we will simply compare two arrays using utility and if frequency is same, then
        - those two string are anagram of each other. Not the first character of the current string
        */
        //- set frequency for targer p String
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }
        //set only first p element frequency of s string
        for (int i = 0; i < p.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
        }

        //now start from the character where we stopped above. which is p.length()
        int i;// defining here as I need to use it outside of for loop
        for (i = p.length(); i < s.length() /*- p.length() +1*/; i++) {

            //check first window equal THEN add starting character which is, i - p.length()
            if (Arrays.equals(pCount, sCount)) {
                result.add(i - p.length());
            }

            //Now increment current character count
            //and decrement starting character of windows
            sCount[s.charAt(i) - 'a']++;   //e.g p=3,  0,[1,2,3++]
            sCount[s.charAt(i - p.length()) - 'a']--; //0--,[1,2,3]

            //we will miss out checking last windows as there is no check
        }
        //add check for last window
        if (Arrays.equals(pCount, sCount)) {            //this can be improved. dont need to check all element.
            // write for loop for 26, and add && condition with anangram boolean value initially set to true, if sCount[i]!=pCount[i] set it to false.
            result.add(s.length() - p.length()); //as after above for loop i would be
            //increament to s.length()-p.length()+1
        }
        /* IMPROVED
             for (int j = 0; j < 26 && allCovered2; j++) {              // allCovered2 can be added to for condition && allCovered2, once its false it wont go further
                    if (arr[j] != arr2[j]) {
                        allCovered2 = false;
                        break;  //enhancement: if found not matched. just break don't loop 26 times.2
                    }
                }
         */
        return result;
    }

    /**
     * FASTEST 5 ms ***************************
     *
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams3(String s, String p) {
        int n = s.length(), m = p.length();
        int[] countS = new int[26];
        int[] countP = new int[26];
        List<Integer> list = new ArrayList<>();

        for (char ch : p.toCharArray()) {
            countP[ch - 'a']++;
        }

        for (int i = 0; i < n; i++) {
            countS[s.charAt(i) - 'a']++;
            boolean isAnagram = true;
            if (i >= m) {
                countS[s.charAt(i - m) - 'a']--;
                isAnagram = (countS[s.charAt(i) - 'a'] == countP[s.charAt(i) - 'a'])
                        && countS[s.charAt(i - m) - 'a'] == countP[s.charAt(i - m) - 'a'];
            }
            for (int j = 0; j < 26 && isAnagram; j++) {
                if (countS[j] != countP[j]) {
                    isAnagram = false;
                }
            }
            if (isAnagram)
                list.add(i - m + 1);
        }
        return list;
    }

    /*
    Copied  https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/Sliding-Window-algorithm-template-to-solve-all-the-Leetcode-substring-search-problem.
     */
    public static List<Integer> findAnagram4(String s, String t) {
        List<Integer> result = new LinkedList<>();
        if (t.length() > s.length()) return result;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int counter = map.size();

        int begin = 0, end = 0;
        int head = 0;
        int len = Integer.MAX_VALUE;


        while (end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) counter--;
            }
            end++;

            while (counter == 0) {
                char tempc = s.charAt(begin);
                if (map.containsKey(tempc)) {
                    map.put(tempc, map.get(tempc) + 1);
                    if (map.get(tempc) > 0) {
                        counter++;
                    }
                }
                if (end - begin == t.length()) {
                    result.add(begin);
                }
                begin++;
            }

        }
        return result;
    }

    /**
     * TEMPLATE
     *
     * @param s
     * @param t
     * @return
     */
    public List<Integer> slidingWindowTemplateByHarryChaoyangHe(String s, String t) {
        //init a collection or int value to save the result according the question.
        List<Integer> result = new LinkedList<>();
        if (t.length() > s.length()) return result;

        //create a hashmap to save the Characters of the target substring.
        //(K, V) = (Character, Frequence of the Characters)
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //maintain a counter to check whether match the target string.
        int counter = map.size();//must be the map size, NOT the string size because the char may be duplicate.

        //Two Pointers: begin - left pointer of the window; end - right pointer of the window
        int begin = 0, end = 0;

        //the length of the substring which match the target string.
        int len = Integer.MAX_VALUE;

        //loop at the begining of the source string
        while (end < s.length()) {

            char c = s.charAt(end);//get a character

            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);// plus or minus one
                if (map.get(c) == 0) counter--;//modify the counter according the requirement(different condition).
            }
            end++;

            //increase begin pointer to make it invalid/valid again
            while (counter == 0 /* counter condition. different question may have different condition */) {

                char tempc = s.charAt(begin);//***be careful here: choose the char at begin pointer, NOT the end pointer
                if (map.containsKey(tempc)) {
                    map.put(tempc, map.get(tempc) + 1);//plus or minus one
                    if (map.get(tempc) > 0)
                        counter++;//modify the counter according the requirement(different condition).
                }

                /* save / update(min/max) the result if find a target*/
                // result collections or result int value

                begin++;
            }
        }
        return result;
    }

    /*
     //counter is the category of characters in target.
            while(counter == 0){
                // Add to result when window size matches and counter is zero.
                if(end-begin == t.length()) result.add(begin);
                char tempc = s.charAt(begin);
                if(map.containsKey(tempc)){
                    //counter++ when a 'registered' character is found
                    // After counter updates, it exits while-loop.
                    if(map.get(tempc) == 0) counter++;
                    map.put(tempc, map.get(tempc) + 1);
                }
                //window reduces from the left.
                begin++;
            }
     */

}
