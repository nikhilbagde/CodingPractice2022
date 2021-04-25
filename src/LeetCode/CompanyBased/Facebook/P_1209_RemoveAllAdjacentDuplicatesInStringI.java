package LeetCode.CompanyBased.Facebook;

/**
 * @author Nikhil Bagde
 * @date 4/25/2021- 2:17 AM
 **/
public class P_1209_RemoveAllAdjacentDuplicatesInStringI {
    public static void main(String[] args) {
        /*
        Input: s = "deeedbbcccbdaa", k = 3
        Output: "aa"
        Explanation:
        First delete "eee" and "ccc", get "ddbbbdaa"
        Then delete "bbb", get "dddaa"
        Finally delete "ddd", get "aa"
         */
        String result = removeDuplicates("deeedbbcccbdaa", 3);
        System.out.println("result = " + result);
    }
    public static String removeDuplicates(String s, int k) {
        int count = 1;
        for(int i = 1; i < s.length() && s.length() < k; i++){
            if(s.charAt(i-1) == s.charAt(i)) count++;
            else count = 1;
            if(count == k) s = removeDuplicates(s.substring(0, i - k + 1) + s.substring(i + 1), k);
        }
        return s;
    }
}
