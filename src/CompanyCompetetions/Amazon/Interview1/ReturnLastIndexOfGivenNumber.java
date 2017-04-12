package CompanyCompetetions.Amazon.Interview1;

/**
 * Created by Nikhil on 4/6/2017 4:29 PM.
 */
public class ReturnLastIndexOfGivenNumber {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 3, 4, 4, 4, 4, 5, 6, 7, 7, 7};
        int numberToFind = 7;
        System.out.println(returnLastIndex(a, numberToFind) + "th last position ");
    }

    private static int returnLastIndex(int[] a, int x) {
        //since array is already sorted.
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] == x) {
                return i + 1; //to adjust 0.
            }
        }
        return -1;
    }
}
