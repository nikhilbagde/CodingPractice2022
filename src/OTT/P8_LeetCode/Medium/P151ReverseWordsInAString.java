package LeetCode.Medium;

/**
 * Created by Nikhil on 4/5/2017 6:10 PM.
 */
public class P151ReverseWordsInAString {
    public static void main(String[] args) {
        String temp = "2+3*4-1";
        String[] multiply = temp.split("[*]");
        String[] add = temp.split("[+]");
        String[] sub = temp.split("[-]");
        System.out.println(java.util.Arrays.toString(multiply));
        System.out.println(java.util.Arrays.toString(add));
        System.out.println(java.util.Arrays.toString(sub));
    }

    private static String reverseWords(String s) {
        if (s.length() == 0) return "";
        String[] ss = s.trim().split("\\s+");
        if (ss.length == 1) return s.trim();
        StringBuilder sb = new StringBuilder();
        for (int i = ss.length - 1; i > 0; i--) {
            sb.append(ss[i]).append(" ");
        }
        return sb.append(ss[0]).toString();
    }

}
