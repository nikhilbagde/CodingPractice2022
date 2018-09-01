package Algorithm.Implementation.Easy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by nbagde on 9/1/2018.
 */
public class UtopianTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();



        while(testCases-->=0){
            utopianTree(scanner.nextInt());
        }
    }
    static int utopianTree(int n) {
        int [] heightArray  = computeHeight();
        return heightArray[n];
    }
    private static int[]  computeHeight(){
        int [] heightArray = new int[61];
        heightArray[0]= 1;
        for (int i = 1; i < heightArray.length; i++) {
            if(i%2!=0){ //spring it doubles
                heightArray[i] =  heightArray[i-1]*2;
            }else{//summer it increases by 1
                heightArray[i] = heightArray[i-1]+1;
            }
        }
        System.out.println(Arrays.toString(heightArray));
        return heightArray;
    }
}
