package CompanyCompetetions.Amazon.Interview1;

/**
 * Created by Nikhil on 4/6/2017 11:00 PM.
 */
public class FindFrequencyInLOGN {
    public static void main(String[] args) {
        int b[] = {2, 2, 2, 2, 2, 2, 4, 4, 4, 4, 10, 10, 10, 18, 18, 20, 20, 20, 20, 20};
        int find = 2;
    }

    private int searchLastOccurrence(int a[], int target) {
        int low = 0;
        int high = a.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = (high + low) / 2;
            if (target == a[mid]) {
                result = mid;
                low = mid + 1;
            } else if (target > a[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    private int searchFirstOccurrence(int a[], int target) {
        return 0;
    }

    private int countOccurrence(int a[], int target) {
        return searchLastOccurrence(a, target) - searchFirstOccurrence(a, target) + 1;
    }
}
