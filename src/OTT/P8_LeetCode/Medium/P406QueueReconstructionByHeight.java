package LeetCode.Medium;

/**
 * Created by Nikhil on 4/2/2017 9:05 PM.
 */
public class P406QueueReconstructionByHeight {
    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        reconstructQueue(people);
    }

    private static int[][] reconstructQueue(int[][] people) {
        if (people.length <= 1) return people;

        java.util.Arrays.sort(people, (o1, o2) -> o1[1] > o2[1] ? 1 : (o1[1] < o2[1] ? -1 : (o1[0] > o2[0] ? 1 : -1)));
        System.out.println(java.util.Arrays.deepToString(people));
        return null;
    }
}
