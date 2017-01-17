package CrackingTheCodingInterview.Chapter1ArrayAndString;

/**
 * Created by Nikhi on 10/14/2016.
 */
public class Question1UniqueCharacter {
    public static boolean isUniqueChars(String str) {
        if (str.length() > 128) {
            return false;
        }
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            val = 1 << val;
            if ((checker & (val)) > 0) return false;
            checker |= (val);
        }
        return true;
    }
    public static boolean isUniqueCharsExplained(String str) {
        if (str.length() > 128) {
            return false;
        }
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a'; // Difference with a =  97
            val = 1 << val;             //SET THE BIT FOR Ith CHARACTER
            System.out.println("Checker = " + Integer.toBinaryString(checker) + " Val = " + Integer.toBinaryString(val));
            if ((checker & (val)) > 0) return false;        //CHECK IF ITS ALREDY BEEN SET BY ADDING > 0
            System.out.println("Checker & Val = "  + Integer.toBinaryString(checker & val));
            checker |= (val); //Its like addition 0011 (3) + 0100 (4) = 0111 (7)    //STORE THAT CHARACTER AS SET INTO CHECKER.
            System.out.println("Checker | val = " + Integer.toBinaryString(checker | val));
            System.out.println("Checker = " + Integer.toBinaryString(checker));
        }
        return true;
    }

    public static boolean isUniqueChars2(String str) {
        if (str.length() > 128) {
            return false;
        }
        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) return false;
            char_set[val] = true;
        }
        return true;
    }

    public static boolean isUniqueDigits(String str) {
        if (str.length() > 10) {
            return false;
        }
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - '0';
            val = 1 << val;
            if ((checker & (val)) > 0) {
                return false;
            }
            checker |= (val);
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "apple", "kite", "padle", "zz"};
        for (String word : words) {
            System.out.println(word + ": " + isUniqueChars(word) + " " + isUniqueChars2(word));
        }

        String[] Numbers = {"012345", "54321", "1232", "99", "901", "98765"};
        for (String num : Numbers) {
            System.out.println(num + ": " + isUniqueDigits(num) + " " + isUniqueDigits(num));
        }


    }
}
