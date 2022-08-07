package LeetCode.Easy;

/**
 * Created by Nikhil on 3/31/2017 1:00 PM.
 */
public class P389FindtheDifference {
    public static void main(String[] args) {

        //System.out.println(findTheDifference("abcd", "abcde"));
        System.out.println(findTheDifference2("abcd", "abcde"));
        System.out.println(findTheDifference2("a", "aa"));
    }

    //"a" "aa" fails for this.
    private static char findTheDifference(String s, String t) {
        char[] ss = s.toCharArray();
        java.util.Arrays.sort(ss);

        char[] tt = t.toCharArray();
        java.util.Arrays.sort(tt);

        java.util.ArrayList<Character> list_s = new java.util.ArrayList<>();
        java.util.ArrayList<Character> list_t = new java.util.ArrayList<>();

        for (char c : ss) {
            list_s.add(c);
        }
        for (char c : tt) {
            list_t.add(c);
        }
        list_t.removeAll(list_s);
        return list_t.get(0);
    }

    private static char findTheDifference2(String s, String t) {
        int[] letters = new int[26];
        if (s.length() == 0) return t.charAt(0);
        for (int i = 0; i < s.length(); i++) {      //"a"
            letters[s.charAt(i) - 'a']++;    // 0->1 all other are zero.
        }
        for (int i = 0; i < t.length(); i++) {      //"aa"
            if (--letters[t.charAt(i) - 'a'] < 0) {   //0->0, 0->-1
                return t.charAt(i);
            }
        }
        return '0';
    }
}

/*
Input:
s = "abcd"
t = "abcde"

Output:
e

Explanation:
'e' is the letter that was added.
 */