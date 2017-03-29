package Algorithm.Implementation.Easy;

import java.util.Scanner;

/**
 * Created by Nikhil on 3/29/2017 8:28 AM.
 */
public class P13CatsAndAMouse {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            int catA = in.nextInt();
            int catB = in.nextInt();
            int mouse = in.nextInt();
            System.out.println(Math.abs(mouse - catA) > Math.abs(mouse - catB) ? "Cat B" : (Math.abs(mouse - catA) < Math.abs(mouse - catB)) ? "Cat A" : "Mouse C");
        }

    }
}
