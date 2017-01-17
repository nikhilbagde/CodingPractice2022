package Algorithm.Implementation.Medium;

import java.util.Scanner;

/**
 * Created by Nikhi on 12/26/2016 10:09 PM.
 */
public class LarrySArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCount = scanner.nextInt();

        for(int i = 0; i< testCount ; i++){
            int N = scanner.nextInt();
            int[] arrayInt = new int[N];
            int[] invarientCount = new int[N];
            for(int j=0; j<N; j++){
                arrayInt[j] = scanner.nextInt();
            }
            int totalInversion = 0;
            for(int z=0; z< arrayInt.length-1; z++){
                int invarient = 0;
                for(int inner = z+1; inner < arrayInt.length; inner++ ){
                    if(arrayInt[z] > arrayInt[inner]){
                        invarient+=1;
                        totalInversion +=1;
                    }
                }
                invarientCount[z] = invarient;
            }
            //I think position of hole could be considered as 3 as we are rotating by 3 elements.
            //So position of hole is always ODD.
            if( (N%2!=0&& totalInversion%2!=0) || (N%2 == 0 && totalInversion%2==0)){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }

        }
    }
}

/*
Test
3
3
3 1 2
4
1 3 4 2
5
1 2 3 5 4
 */