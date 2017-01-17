package Contest.WorldCodeSprint8.Solution;

import javax.lang.model.type.IntersectionType;
import java.util.*;

/**
 * Created by Nikhi on 12/17/2016 4:26 PM.
 */
public class P5_DecibinaryNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            long x = in.nextLong();
            System.out.println(calculateDeciBinary(x));
        }
    }
    private static long calculateDeciBinary(long x){
        return getSum(x);
    }
    private static long getSum(long num){
        int power = 0;
        long sum = 0;
        while(num>0){
            sum+= (num%10) * Math.pow(2,power++);
            num/=10;
        }
        return sum;
    }
}