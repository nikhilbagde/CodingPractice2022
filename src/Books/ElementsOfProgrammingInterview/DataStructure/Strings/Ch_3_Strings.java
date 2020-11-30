package Books.ElementsOfProgrammingInterview.DataStructure.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ch_3_Strings {
    private static final String[] MAPPING = {"0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};

    private static void P1_isPalindromic() {
        String input = "aabbssssbbaa";
        String input_1 = "aabaa";
        String input_2 = "aabbaa";
        String input_3 = "";

        for (int i = 0, j = input.length() - 1; i < j; i++, j--) {
            if (input.charAt(i) != input.charAt(j)) {
                System.out.println(" Not a Palindromic");
            }
        }
        System.out.println("It is Palindromic");
    }
    //Time: O(N) and Space: O(1)

    private static void P2_intToString() {
        int x = 314;
        boolean isNegative = x < 0;

        StringBuilder sb = new StringBuilder();

        while (x != 0) {
            sb.append((char) ('0' + Math.abs(x % 10)));
            x = x / 10;
        }
        if (isNegative)
            sb.append("-");
        System.out.println(sb.reverse().toString());
    }

    private static void P3_stringToInt() {
        String s = "314";
        int result = 0;
        for (int i = s.charAt(0) == '-' ? 1 : 0; i < s.length(); i++) {
            result = result * 10 + (s.charAt(i) - '0');         //charAt will give character value of an integer: e.g. '4'
        }
        result = s.charAt(0) == '-' ? -result : result;
        System.out.println("result = " + result);
    }

    /**
     * Implement a function that converts a spreadsheet column id to the corresponding
     * integer, with "A" corresponding to 1. For example, you should return 4 for "D", 27
     * for "AA", 702 for "ZZ", etc. How would you test your code?
     * Hint: There are 26 characters in ["A","Z"], and each can be mapped to an integer.
     */
    private static void P5_ssDecodeColId() {

        //Questions to think about: Are all capital letters.
        // I am assuming that input only have character and no number and no special characters.
        String col = "AA";
        String col1 = "ZZ";
        String col2 = "VG";

        // A B C .. Z  AA
        // 1 2 3 // 26 27
        // Number system with base 26 but numbers does not start from 0 but 1.

        int result = 0;
        for (int i = 0; i < col.length(); i++) {
            result = result * 26 + (col.charAt(i) - 'A') + 1; // + 1 to avoid zero. And - 'A' since col.charAt(i) would get character
            // and we are trying to add it as a integer. This will convert char to integer value
            // which we do not want. 'A' in integer would be decimal value of 65
            // now to get actual relative value of capitalized letters, we start
            // from 'A' any letter which is more than 'A' we can get diff and hence value from 1st number.
        }

        System.out.println("result = " + result);

    }
    //Time: O(n) space O(1)

    /**
     * Write a program which takes as input an array of characters, and removes each 'b' and
     * replaces each 'a' by two 'd's. Specifically, along with the array, you are provided an
     * integer-valued size. Size denotes the number of entries of the array that the operation
     * is to be applied to. You do not have to worry preserving about subsequent entries. For
     * example, if the array is {a,b,a,c,_) and the size is 4, then you can return (d,d,d,d,c).
     * You can assume there is enough space in the array to hold the final result.
     * Hint: Consider performing multiples passes on s.
     */

    private static void P4_replaceAndRemove() {
        char[] a = new char[]{'a', 'c', 'b', 'a', 'a', '\0', '\0', '\0'};

        int i = 0, countA = 0;                  //keep another index to keep track of edited character array.
        for (int j = 0; j < a.length; j++) {

            if (a[j] != 'b') {                      // copy back characters back with new index for all character except 'b'.
                a[i++] = a[j];
            }
            if (a[j] == 'a') {
                countA++;
            }
        }

        //backward iteration replace 'a' with 'dd' starting from end.
        int mid = i - 1; // -1 because after last iteration above i++ will take 1 value next.
        // now for filling 'dd' with a, we just have to have new size of array twice to count of a.
        int end = mid + countA;      //count A + new index after deleting b would be new size.

        while (mid > 0) {
            if (a[mid] == 'a') {
                a[end--] = 'd';
                a[end--] = 'd';
            } else {
                a[end--] = a[mid];
            }
            mid--;
        }

        System.out.println(Arrays.toString(a));
    }


    /**
     * Implement a function which takes as input a string s and returns true if s is a palin¬
     * dromic string.
     * Hint: Use two indices.
     * <p>
     * For the purpose of this problem, define a palindromic string to be a string which
     * when all the nonalphanumeric are removed it reads the same front to back ignoring
     * case. For example, "A man, a plan, a canal, Panama." and "Able was I, ere I saw
     * Elba!" are palindromic, but "Ray a Ray" is not.
     */

    private static void P7_isPalindrome() {
        String s = "A man, a plan, a canal, Panama";
        //String s = "Ray a Ray";

        int i = 0, j = s.length() - 1;

        while (i < j) {     //Two pointer method
            while (!Character.isLetterOrDigit(s.charAt(i)) && i < j) {             // check for non alphabets and move i forward + Make sure i<j
                i++;
            }
            while (!Character.isLetterOrDigit(s.charAt(j)) && i < j) {// check for non alphabets and move j backward + Make sure i<j
                j--;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                System.out.println(" Not a Palindrome");
            }
            i++;
            j--;
        }

        System.out.println(" Is it Palindrome");
    }
    // Time: O(n) and Space: O(1)

    /**
     * Given a string containing a set of words separated by whitespace, we would like to
     * transform it to a string in which the words appear in the reverse order. For example,
     * "Alice likes Bob" transforms to "Bob likes Alice". We do not need to keep the original
     * string.
     * Implement a function for reversing the words in a string s.
     * Hint: It's difficult to solve this with one pass.
     */

    private static void P8_reverseWords() {
        String input = "Alice likes Bob";

        /*
            Approach 1: split the string using String.split() into array of strings.
            Run the reverse() using, StringBuilder for each string
            join all Strings back adding space between strings to form a final string.
            e.g. "Alice likes Bob"
            "Alice", "likes", "Bob"
            //"ecilA sekil boB"  --  Then reverse the whole string
            Expected: "Bob likes Alice"

            TimeComplexity of all the methods in String/StringBuilder and StringBuffer:
            https://github.com/nikhilbagde/TimeComplexityOfPredefinedMethodsInJava/blob/master/String%2C%20StringBuilder%20and%20StringBuffer%20class%20methods
         */
        String[] inputSplit = input.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < inputSplit.length; i++) {
            StringBuilder sb = new StringBuilder(inputSplit[i]);
            //sb.reverse();
            //if(i!= inputSplit.length-1) {
            result.insert(0, sb.toString());         //Approach changed: directly append at zero without reversing.
            result.insert(0, " ");              // Append space to keep space in between words.
            //}
        }
        System.out.println(result.replace(0, 1, "").toString());
        //result.reverse();

        /*
            StringBuilder.insert() uses System.copy() - which takes O(N) n is length of the string.
            Hence for each string it will take O(N) hence combined complexity is O(N)
            Time: O(N)
            Space: O(N)
         */

        // follow up how to eliminate Space O(n)
        /* Approach 2:
            1. Reverse whole string first - write method to reverse a string with start and end index. And do it in n/2 iteration cycle.
                E.g. "Alice likes Bob" -> "boB sekil ecilA"
            2. then Reverse each word - using same reverse method based on index start and end.
                e.g. "boB sekil ecilA" -> "Bob likes Alice"
         */

        char[] inputArr = input.toCharArray();
        reverse(inputArr, 0, inputArr.length);

        int start = 0, end;
        while ((end = find(inputArr, ' ', start)) != -1) {
            //Reverse each word in the string
            reverse(inputArr, start, end);
            start = end + 1;
        }

        //reverse the last word.
        reverse(inputArr, start, inputArr.length);

    }

    private static int find(char[] input, char space, int start) {
        for (int i = start; i < input.length; i++) {
            if (input[i] == space) return i;
        }
        return -1;
    }

    public static void main(String[] args) {

        String s = "String if what";
        char charAtString = s.charAt(0);

        int compareString = s.compareTo("string");

        String concatedString = s.concat(" is amazing");

        boolean containsResult = s.contains("ri");
        boolean containsResult2 = s.contains("rig");
        boolean containsResult3 = s.startsWith("St");
        boolean containsResult4 = s.startsWith("S");
        boolean endsWithString = s.endsWith("ring");
        boolean endsWithString2 = s.endsWith("ng");
        int indexOfResult = s.indexOf("ng");
        int indexOfResult2 = s.indexOf("n");
        int indexOfResult3 = s.indexOf("g");
        int indexOfResult4 = s.indexOf("g", 5);
        int indexOfResult5 = s.indexOf("g", 2);
        int indexOfResult6 = concatedString.lastIndexOf("g");
        int lengthOfString = s.length();
        s = s.replace("a", "A");

        String s1 = "foo::bar::abc";
        String[] splitResult = s1.split("::");

        String subString1 = concatedString.substring(1);
        String subString2 = concatedString.substring(1, 5);
        char[] charArray = concatedString.toCharArray();

        //StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("Appending");
        char aa = sb.charAt(1);
        aa = sb.charAt(2);
        sb.delete(2, 4);
        sb.deleteCharAt(2);
        sb.insert(0, 1);
        sb.insert(0, 'd');
        sb.insert(0, "as");
        sb.replace(2, 4, "replaced");
        String ss = sb.toString();


        P1_isPalindromic();

        //unicode characters
        char zero = '0';
        char one = '1';
        int sum = zero + one;
        System.out.println("sum = " + sum);
        System.out.println("sum = (char) " + (char) sum);

        /**
         * Unicode Character map:
         *
         *      0   1   2   3   4   5   6   7   8   9   A   B   C   D   E   F
         *      0   1   2   3   4   5   6   7   8   9   10  11  12  13  14  15
         *      -----------------------------------------------------------------
         *      *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   (0 to 15)
         *      *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   (16 to 31)
         *      *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   (32 to 47)
         *      0   1   2   3   4   5   6   7   8   9   :   ;   <   =   >   ?   (48 to 63)
         *      @   A   B   C   D   E   F   G   H   I   J   K   L   M   N   O   (64 to 79)
         *      P   Q   R   S   T   U   V   W   X   Y   Z   [   \   ]   ^   _   (80 to 95)
         *      `   a   b   c   d   e   f   g   h   i   j   k   l   m   n   o   (96 to 101)
         *      p   q   r   s   t   u   v   w   x   y   z   {   |   }   ~   ␡  (102 to 127)
         */

        P2_intToString();
        // P8_reverseWords();
        P9_phoneMnemonic();
    }

    //Time: O(n) space: O(1)

    private static void reverse(char[] input, int start, int end) {
        if (start >= end) return;

        end = end - 1;
        for (int i = start; i <= start + (end - start) / 2; i++) {          //start + (end-start)/2 b/c for each string start position would be diff.
            char temp = input[i];
            input[i] = input[end - i + start];
            input[end - 1 + start] = temp;
        }
    }

    /**
     * Each digit, apart from 0 and 1, in a phone keypad corresponds to one of three or four
     * letters of the alphabet, as shown in Figure 7.1 on the next page. Since words are easier
     * to remember than numbers, it is natural to ask if a 7 or 10-digit phone number can
     * be represented by a word. For example, "2276696" corresponds to "ACRONYM" as
     * well as "ABPOMZN".
     * Write a program which takes as input a phone number, specified as a string of digits,
     * and returns all possible character sequences that correspond to the phone number.
     * The cell phone keypad is specified by a mapping that takes a digit and returns the
     * corresponding set of characters. The character sequences do not have to be legal
     * words or phrases.
     */


    private static void P9_phoneMnemonic() {
        String phoneNumber = "2276696";
        char[] partialMnemonics = new char[phoneNumber.length()];
        List<String> mnemonics = new ArrayList<>();

        recursiveFunction(phoneNumber, 0, partialMnemonics, mnemonics);

        System.out.println(mnemonics);
    }

    private static void recursiveFunction(String phoneNumber, int digit, char[] partialMnemonics, List<String> mnemonics) {
        if (digit == phoneNumber.length()) {
            mnemonics.add(new String(partialMnemonics));
        } else {
            for (int i = 0; i < MAPPING[(phoneNumber.charAt(digit) - '0')].length(); ++i) {
                char c = MAPPING[phoneNumber.charAt(digit) - '0'].charAt(i);
                partialMnemonics[digit] = c;
                recursiveFunction(phoneNumber, digit + 1, partialMnemonics, mnemonics);
            }
        }
    }

    //Time: O(4 ^n)
}
