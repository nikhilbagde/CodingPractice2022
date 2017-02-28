package GeeksForGeeks.DataStructure.Queue;

/**
 * Created by Nikhil on 2/25/2017 10:01 PM.
 */
public class P2GenerateBinaryNumbers {
    public static void main(String[] args) {
        generateBinaryNumber(5);
    }

    private static void generateBinaryNumber(int n) {
        for (int i = 1; i <= n; ++i) {
            System.out.println(Integer.toBinaryString(i));
        }
    }
}
