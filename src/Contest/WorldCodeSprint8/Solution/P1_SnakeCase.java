package Contest.WorldCodeSprint8.Solution;

import java.util.Scanner;

/**
 * Created by Nikhi on 12/17/2016 12:10 PM.
 */
public class P1_SnakeCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(s.split("_").length);
    }

}
