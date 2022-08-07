package LeetCode.Easy;

/**
 * Created by Nikhil on 4/9/2017 8:55 PM.
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 */
public class P557ReverseWordsinaStringIII {
    public static void main(String[] args) {
        reverseWords("Let's take LeetCode contest");
    }

    private static String reverseWords(String s) {
        String[] a = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            if (i == a.length - 1)
                sb.append(new StringBuilder(a[i]).reverse().toString());
            else
                sb.append(new StringBuilder(a[i]).reverse().toString()).append(" ");
        }
        return sb.toString();
    }

}
