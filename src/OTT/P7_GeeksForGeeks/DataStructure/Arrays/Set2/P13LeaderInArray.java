package OTT.P7_GeeksForGeeks.DataStructure.Arrays.Set2;

/**
 * Created by Nikhil on 2/27/2017 7:54 PM.
 * Write a program to print all the LEADERS in the array.
 * An element is leader if it is greater than all the elements to its right side.
 * And the rightmost element is always a leader.
 * For example int the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.
 */
public class P13LeaderInArray {
    public static void main(String[] args) {
        int[] array = {16, 17, 4, 3, 5, 2};
        printLeader(array);
    }

    //start from end and use Kanode algorithm, just maxSoFar variable will do.
    private static void printLeader(int[] array) {
        int maxSoFar = 0;
        for (int i = array.length - 1; i >= 0; --i) {
            if (array[i] > maxSoFar) {
                System.out.println(array[i]);
                maxSoFar = array[i];
            }
        }
    }
}
