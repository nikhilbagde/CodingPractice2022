package GeeksForGeeks.JavaReview.MemoryLeak;

/**
 * Created by Nikhil on 3/5/2017 12:39 AM.
 */
public class RuntimeTotalMemoryFreeMemory {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        long freem = runtime.freeMemory();
        long totalm = runtime.totalMemory();

        System.out.println("Total " + totalm / Math.pow(10, -6) + " MB");
        System.out.println("Free " + freem / Math.pow(10, -6) + " MB");
        System.out.println("Used " + (totalm - freem) / Math.pow(10, -6) + " MB");
    }

    private static void function1() {

    }

    private static void function2() {

    }

    private static void function3() {

    }
}
