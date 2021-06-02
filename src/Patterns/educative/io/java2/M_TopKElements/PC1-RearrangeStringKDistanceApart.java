package Patterns.educative.io.java2.M_TopKElements;

import java.util.*;

class RearrangeStringKDistanceApart {

    public static String reorganizeString(String str, int k) {
        if (k == 0) return str;
        Map<Character, Integer> map = new HashMap<>();
        for (char c: str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        Queue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a,b) -> b.getValue()-a.getValue());
        queue.addAll(map.entrySet());
        StringBuilder res = new StringBuilder();
        Queue<Map.Entry<Character, Integer>> kQueue = new LinkedList<>();
        while (!queue.isEmpty()) {
            Map.Entry<Character, Integer> curr = queue.poll();      //remove , append, decrease count, add to K queue, don't
            res.append(curr.getKey());
            curr.setValue(curr.getValue()-1);

            kQueue.add(curr);           // Add it to another LinkedList Queue. in same order. keep adding till size becomes K

            if (kQueue.size() == k) {   //when size is k then only add back that one entry which was added 1st. FIFO to the original PQ
                Map.Entry<Character, Integer> temp = kQueue.poll();
                if (temp.getValue() > 0) queue.add(temp);
            }
        }
        if (res.length() != str.length()) return "";
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println("Reorganized string: " +
            RearrangeStringKDistanceApart.reorganizeString("mmpp", 2));
        System.out.println("Reorganized string: " +
            RearrangeStringKDistanceApart.reorganizeString("Programming", 3));
        System.out.println("Reorganized string: " +
            RearrangeStringKDistanceApart.reorganizeString("aab", 2));
        System.out.println("Reorganized string: " +
            RearrangeStringKDistanceApart.reorganizeString("aappa", 3));
    }
}
