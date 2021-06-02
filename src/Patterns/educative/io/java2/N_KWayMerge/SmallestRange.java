package Patterns.educative.io.java2.N_KWayMerge;

import java.util.*;

class Element {
    int index;
    int listIndex;

    public Element(int index, int listIndex) {
        this.index = index;
        this.listIndex = listIndex;
    }
}

class SmallestRange {
    public static int[] findSmallestRange(List<Integer[]> lists) {
        Queue<Element> minHeap = new PriorityQueue<>((a,b) ->
            lists.get(a.index)[a.listIndex]-lists.get(b.index)[b.listIndex]);
        int start = 0, end = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                minHeap.add(new Element(i, 0));
                max = Math.max(max, lists.get(i)[0]);
            }
        }
        while (minHeap.size() == lists.size()) {
            Element temp = minHeap.poll();
            if (end-start > max-lists.get(temp.index)[temp.listIndex]) {
                end = max;
                start = lists.get(temp.index)[temp.listIndex];
            }
            temp.listIndex++;
            if (temp.listIndex < lists.get(temp.index).length) {
                minHeap.add(temp);
                max = Math.max(max,lists.get(temp.index)[temp.listIndex]);
            }
        }
        return new int[] { start, end};
    }

    public static void main(String[] args) {
        Integer[] l1 = new Integer[] { 1, 5, 8 };
        Integer[] l2 = new Integer[] { 4, 12 };
        Integer[] l3 = new Integer[] { 7, 8, 10 };
        List<Integer[]> lists = new ArrayList<Integer[]>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        int[] result = SmallestRange.findSmallestRange(lists);
        System.out.print("Smallest range is: [" + result[0] + ", " + result[1] + "]");
    }
}
