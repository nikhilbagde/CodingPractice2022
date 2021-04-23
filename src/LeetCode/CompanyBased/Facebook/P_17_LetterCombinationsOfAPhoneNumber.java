package LeetCode.CompanyBased.Facebook;

import java.util.List;

public class P_17_LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {

    }
    public static List<String> letterCombinations(String digits) {
        // error check
        // for every letter we can match up with every other letter.
        // e.g. "23"   2 ="abc" 3="def"
        //  2 a->d, a->e a->f, similar for b.
        // we can do it recursively, tracking result list, input string, blank string to start with, current index where are we at to finally check with input length, mappings

        List<String> results = new java.util.ArrayList<>();
        if(digits==null || digits.length()==0){
            return results;
        }

        String [] mappings = {
                "0",
                "1",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };
         letterCombinationsRecursive(results, digits, "", 0, mappings );
         return results;
    }
    //A -> index count can be replaced by input.length
    public static void letterCombinationsRecursive(List<String> results, String digits, String input, int index, String[] mappings){
        if(index== digits.length()) {       //A
            results.add(input);
            return;
        }
        //int letter = digits.charAt(index) - '0';
        int letter = Character.getNumericValue(digits.charAt(index)); //A
        String options = mappings[letter];

        for (int i = 0; i < options.length(); i++) {
            letterCombinationsRecursive(results, digits, input + options.charAt(i), index + 1, mappings); //A
        }

    }
}
