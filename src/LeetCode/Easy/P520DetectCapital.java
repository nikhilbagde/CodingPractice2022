package LeetCode.Easy;

/**
 * Created by Nikhil on 3/31/2017 12:49 PM.
 */
public class P520DetectCapital {
    public static void main(String[] args) {
        System.out.println(detectCapitalUse("USA"));
        System.out.println(detectCapitalUse("Usa"));
        System.out.println(detectCapitalUse("uSA"));
    }

    private static boolean detectCapitalUse(String word) {
        int length = word.length();
        int capLength = 0;
        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c))
                capLength++;
        }
        return length == capLength
                || capLength == 1 && Character.isUpperCase(word.charAt(0))
                || capLength == 0;
    }
}
