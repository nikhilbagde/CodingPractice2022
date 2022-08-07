package Books.B0_CompetitiveProgrammingBook.Chapter1;

/**
 * Created by Nikhi on 12/11/2016 1:54 AM.
 */
public class Problem1 {
    public static void main(String[] args) {
        //left shift and right shift practice.

        System.out.println(1<<0);   //=1
        System.out.println(1<<1);   //=2         01->10     = 2
        System.out.println(1<<2);   //=4         0001->0100 = 4
        System.out.println(1<<3);   //=8         0001->1000 = 8
        System.out.println(1<<4);   //=16        0001->10000= 16
        System.out.println(1<<5);   //32         0001->100000 = 32
        System.out.println(1<<6);   //64         0001->100 0000 = 64
        //2^3 = 8
        System.out.println(1<<8);    //256       0001->1 0000 0000
        System.out.println(1 << 16);   //‭65536‬         0001->‭ 0001 0000 0000 0000 0000‬= ‭65536‬
        System.out.println(1 << 62);   //         0001->‭ 0100 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000‬= ‭4,611,686,018,427,387,904‬
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);

        
    }
}
