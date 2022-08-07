package OTT.P8_LeetCode.Tags.Random_Math;

import java.util.Scanner;

public class P_4A_EvenNumberSumToGivenWeight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int weight = scanner.nextInt();

        // weight 8
        // first I need to find all even numbers which can sum to 8.
        // two numbers even its same number it should add up to 8 (W).
        // 2+ 2 = !4
        // 2+ 4 = !6
        // 2 + 6 = 8 YES
        // 2 + 8 <

        //first find all even numbers less than given weight
        //8 -> 2 4 6
        // combinations  num1 + numb 2
        // 2 + (2/4/6) = 8? YES
        // 4 + (2/4/6) =?
        // 6 + (2/4/6) = ?
        boolean solutionfound = false;
        for (int i = 2; i < weight; i= i+2) {
            for (int j = 2; j < weight; j=j+2) {
                if(i+j==weight){
                    //System.out.println("YES");
                    solutionfound = true;
                    break;
                }
            }
        }
        if(solutionfound){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }

    }
}
