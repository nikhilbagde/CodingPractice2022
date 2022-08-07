package LeetCode.CompanyBased.Facebook;

import java.util.Arrays;
import java.util.LinkedHashSet;

/**
 * @author Nikhil Bagde
 * @package LeetCode.CompanyBased.Facebook
 * @created 04/05/2021
 * @date 4/5/2021- 9:01 PM
 *
 **/
public class P_269_AlienDictionary {
    public static void main(String[] args) {
        String[] words = new String[] {
                "wrt",
                "wrf",
                "er",
                "ett",
                "rftt"
        };

        String result = alienOrder(words);
        System.out.println("result = " + result);

    }

    public static String alienOrder(String[] words) {
        int maxLength = Integer.MIN_VALUE;
        int minLength = Integer.MAX_VALUE;

        for (String s : words){
            maxLength = Math.max(s.length(), maxLength);
            minLength = Math.min(s.length(), minLength);
        }

        char[][] wordArray = new char[words.length][maxLength];
        for (int i = 0; i <words.length ; i++) {
            for (int j = 0; j < words[i].length() ; j++) {
                wordArray[i][j] = words[i].charAt(j);
            }
        }
        System.out.println(Arrays.deepToString(wordArray));

        LinkedHashSet<Character> linkedHashSet = new LinkedHashSet<>();

        java.util.Map<Character, Integer> map = new java.util.LinkedHashMap<>();

        for (int col = 0; col < maxLength; col++) {
            char lastChar = '\0';
            for (int row = 0; row < words.length; row++) {
                if(wordArray[row][col]!='\0') {
                    linkedHashSet.add(wordArray[row][col]);
                    char currentChar = wordArray[row][col];
                    boolean contains = map.containsKey(currentChar);
                    if(contains && map.get(currentChar) < row && lastChar!=currentChar){     //if given strings is not in lexicographical order
                        return "";
                    }
                    if(!contains) {
                        map.put(wordArray[row][col], map.getOrDefault(wordArray[row][col], 0) + 1);
                    }
                    lastChar = currentChar;
                }
            }
        }
        System.out.println(linkedHashSet);

        return  linkedHashSet.toString();
    }

}

/*
 269	Alien Dictionary

 There is a new alien language which uses the latin alphabet.
 However, the order among letters are unknown to you.

 You receive a list of words from the dictionary, where words are sorted lexicographically
 by the rules of this new language.

 Derive the order of letters in this language.

 For example,

 Given the following words in dictionary,
   [
     "wrt",
     "wrf",
     "er",
     "ett",
     "rftt"
   ]

 The correct order is: "wertf".


 Input:
 [
 "z",
 "x",
 "z"
 ]

 Output: ""

 Explanation: The order is invalid, so return "".


 Note:
     You may assume all letters are in lowercase.
     If the order is invalid, return an empty string.
     There may be multiple valid order of letters, return any one of them is fine.
 */