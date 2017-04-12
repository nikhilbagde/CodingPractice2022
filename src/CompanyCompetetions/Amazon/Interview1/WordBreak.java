package CompanyCompetetions.Amazon.Interview1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nikhil on 4/6/2017 12:50 AM.
 */
public class WordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        Set<String> dict = new HashSet<>(Arrays.asList("leet", "code"));
        wordBreaak(s, dict);
    }

    private static boolean wordBreaak(String s, Set<String> dict) {
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (f[j] && dict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
    }
}
