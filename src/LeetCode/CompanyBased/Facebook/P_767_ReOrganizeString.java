package LeetCode.CompanyBased.Facebook;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class P_767_ReOrganizeString {
    public static void main(String[] args) {
        String result = reorganizeString("aab");
        System.out.println("result = " + result);
    }

    public static String reorganizeString2(String S) {
        int[] arr = new int[26];

        for (char c : S.toCharArray()) {
            arr[c - 'a']++;
        }
        System.out.println(Arrays.toString(arr));


        return "";
    }

    /**
     * 93 % slow
     *
     * @param S
     * @return
     */
    public static String reorganizeString(String S) {
        Map<Character, Integer> map = new HashMap<>();

        //Time: O(N,) Space O(N)
        for (char c : S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        System.out.println(map);

        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) ->
                map.get(b) - map.get(a)
        );

        pq.addAll(map.keySet());

        System.out.println(pq);

        //aab
        StringBuilder sb = new StringBuilder();
        while (pq.size() > 1) {
            char first = pq.poll();
            char second = pq.poll();

            sb.append(first).append(second);

            map.put(first, map.get(first) - 1);
            map.put(second, map.get(second) - 1);

            if (map.get(first) > 0) pq.offer(first);
            if (map.get(second) > 0) pq.offer(second);

            if (map.get(first) == 0) map.remove(first);
            if (map.get(second) == 0) map.remove(second);
        }

        if (!pq.isEmpty()) {
            char lastChar = pq.poll();
            if (map.get(lastChar) > 1) {
                return "";
            }
            sb.append(lastChar);
        }

        //if(!map.isEmpty()) return "";

        return sb.toString();
    }
}
