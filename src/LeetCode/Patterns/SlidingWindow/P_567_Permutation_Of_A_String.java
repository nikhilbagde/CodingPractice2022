package LeetCode.Patterns.SlidingWindow;

/**
 * @author Nikhil Bagde
 * @date 5/9/2021- 10:14 PM
 **/
public class P_567_Permutation_Of_A_String {
    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
        boolean b = checkInclusion(s1, s2);  // best solution 1st attempt : 3ms : Well done.
        System.out.println("b = " + b);
    }
    public static boolean checkInclusion( String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for( char c: s1.toCharArray()){
            count1[c - 'a']++;
        }
        int start = 0;
        for( int end=0; end < s2.length(); end++){
            count2[s2.charAt(end) -'a']++;
            if((end-start) +1 == s1.length()){
                if(checkPermutation(count1, count2)){
                    return true;
                }else {
                    count2[s2.charAt(start) -'a']--;
                    start++;
                }
            }
        }
        return false;
    }
    public static boolean checkPermutation(int[] c1, int[] c2){
        for(int i=0; i< 26; i++){
            if(c1[i] !=c2[i]){
                return false;
            }
        }
        return true;
    }
}
