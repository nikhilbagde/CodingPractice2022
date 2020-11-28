package Books.ElementsOfProgrammingInterview.DataStructure.Strings;

import java.util.Arrays;

public class Ch_3_Strings {
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
    }

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
        int front = i - 1; // -1 because after last iteration above i++ will take 1 value next.
        // now for filling 'dd' with a, we just have to have new size of array twice to count of a.
        int back = countA + (i - 1);      //count A + new index after deleting b would be new size.

        while (front > 0) {
            if (a[front] == 'a') {
                a[back--] = 'd';
                a[back--] = 'd';
            } else {
                a[back--] = a[front];
            }
            front--;
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
}
