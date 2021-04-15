package CompanyCompetetions.Facebook.CareerCup.Interview;

/**
 * @author Nikhil Bagde
 * @package CompanyCompetetions.Facebook.CareerCup.Interview
 * @created 03/25/2021
 * @date 3/25/2021- 9:12 PM
 * @project HackerRank2017
 **/
public class P1_GeneratePallindromSubsets {
    /*Welcome to Facebook!

                This is just a simple shared plaintext pad, with no execution capabilities.

                When you know what language you would like to use for your interview,
        simply choose it from the dropdown in the top bar.

        Enjoy your interview!


                Given a string 's', find the longest string that can be formed using
        (a subset of) characters inside 's', that is also a palindrome.

        s = "engineer" --> Ans = "enene"  "engne" "enine" "neien"

        s = "baba" --> Ans = "abba"


        hashMap char -> count e  = 3
        n  = 2
        b  = 5
        g = 1
        i = 1
        r = 1

        keys has values more than >= 2

        1. max freuently occuring char which is odd - () e = 3
        If not ->
        2. find all even occuring char

        3. I need to form a String - which has size 5
        for loop go over all character which has values >= 2 ( n done, b done)
        StringBuild sb.append(key)  -> update hasmap map.put(key,
                map.get(char) - 1);          -> e

        sb.append(0,char) also sb.append(char)
                    -> bnenb
        update HashMap.put(char, 0);
        ///done
        //

        for max count character: get its reamining count value,

        for( count/2)
            sb.append(0, char);
        sb.append(char);*/
    public static void main(String[] args) {

        String result = findLongestPalindrome("engineernnn");
        System.out.println("result = " + result);

    }
    public static String findLongestPalindrome(String input) {

        //Error cheching
        if (input == null || input.length() == 0) {                                 // BUG 1: string.length() not string.length
            return "";
        }

        java.util.HashMap<Character, Integer> map = new java.util.HashMap<>();

        for (Character c : input.toCharArray()) {           // BUG 2: string does not work on foreach, use string.toCharArray()
                                                                                                                                    //Time:  O(N) n np of char
            map.put(c, map.getOrDefault(c, 0) + 1);                       //Space: O(N)
        }

        StringBuilder sb = new StringBuilder();
        Character toAppendAtTheMiddle = null;
        for (java.util.Map.Entry<Character, Integer> entry : map.entrySet()) {      // Time: O(N)               BUG 3: map.entrySet() not map.EntrySet()
            if (entry.getValue() == 1) {
                toAppendAtTheMiddle = entry.getKey();
            }
            if (entry.getValue() >= 2) {    //to form palindrome                                         //BUG 4: should be >=2
                int count = entry.getValue();
                while (count >= 2) {                                                                                         // Constant. Ignore
                    //sb.append(0, entry.getKey());                                                                 //b   BUG 5: sb.insert(0,entry.getKey()); not sb.append(0,
                    sb.insert(0,entry.getKey());
                    sb.append(entry.getKey());                                                                     //bb

                    count = count - 2;                                                                                    //BUG
                    map.put(entry.getKey(), entry.getValue() - 2);
                }
            }
        }

        // see if map is not null.
        sb.insert(sb.length() / 2, toAppendAtTheMiddle != null ? String.valueOf(toAppendAtTheMiddle) : "");
                                                                                                                                     //finally we are  //BUG 6: sb.length() not sb.size()
        //putting any key which has f = 1, at the middle of the SB.                             //BUG 7: sb.insert()

        return sb.toString();
    }
}
