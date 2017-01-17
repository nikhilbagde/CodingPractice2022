package GeeksForGeeks.JavaReview.Random3;

import GeeksForGeeks.JavaReview.Random2.ScopeTest;
/**
 * Created by Nikhil on 1/7/2017 2:22 AM.
 */
public class ScopeTestChild extends ScopeTest {
    public static void main(String[] args) {
        System.out.println(protectedVariable);
    }
}
