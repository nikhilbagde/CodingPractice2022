package OTT.P8_LeetCode.Tags.Random_Math;

import java.util.Scanner;

public class P_1A_TheaterSquare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input n width of rectangle n*m
        long n = scanner.nextInt();
        //input m breadth of rectangle
        long m = scanner.nextInt();

        //input size of square tile a*
        long a = scanner.nextInt();

        //output how many tiles of size a*a can FULLY cover rectangle.
        //System.out.println( (long) (Math.ceil(n/a) * Math.ceil(m/a)));
        long i = (n%a==0)? (n/a) : ((n/a)+1);           //adding one extra if not fully divisible
        long j = (m%a==0)? (m/a) : ((m/a)+1);       //adding one extra if not fully divisible
        System.out.println(i*j);
    }
}
