package Algorithm.Implementation.Easy;

import java.util.*;

/**
 * Created by Nikhil on 1/1/2017 8:29 PM.
 *
 */
public class BetweenTwoSets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int setASize = scanner.nextInt();
        int setBSize = scanner.nextInt();
        int[] setA = new int[setASize];
        int[] setB = new int[setBSize];
        for (int i = 0; i < setASize; i++) {
            setA[i] = scanner.nextInt();
        }
        for (int i = 0; i < setBSize ; i++) {
            setB[i] = scanner.nextInt();
        }

        int[] setAProductSet = new int[setASize*setASize];
        int index = 0;
        for (int num = 0; num < setASize; num++) {
            for (int num2 = num; num2 < setASize; num2++) {
                setAProductSet[index++] = setA[num]*setA[num2];     //generate all product set of Set A
            }
        }
        //check if all productSet is any element is factor of all elements from SetB
        int count = 0;
        boolean isFactor = false;
        for (int i = 0; i < setAProductSet.length; i++) {
            if(setAProductSet[i] == 0) continue;
            isFactor = true;
            for (int j = 0; j < setB.length; j++) {
                //if its not factor of any element then just break and move to next element from productSet
                if(setB[j]% setAProductSet[i] != 0){
                    isFactor = false;
                    break;
                }
            }
            if (isFactor) count++;
        }
        System.out.println(count);
    }
}
