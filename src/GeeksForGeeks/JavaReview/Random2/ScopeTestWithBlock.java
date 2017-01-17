package GeeksForGeeks.JavaReview.Random2;

/**
 * Created by Nikhil on 1/7/2017 2:32 AM.
 */
public class ScopeTestWithBlock {
    public static void main(String[] args) {
        int x = 5;
        for (int xX = 0; xX < 5; xX++) {
            System.out.println(x);
            System.out.println(xX);
        }
        {
            int y = 50;
            {
                int yy = 10;
                System.out.println(y);
                System.out.println(yy);
            }
        }
    }
}
