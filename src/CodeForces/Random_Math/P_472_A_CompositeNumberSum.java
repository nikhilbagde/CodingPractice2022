package CodeForces.Random_Math;

import java.util.*;

public class P_472_A_CompositeNumberSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();

        List<Integer> primtList = calculatePrimeNumbers();
        System.out.println(primtList);
        int currentNumber = primtList.get(0);
        int index = 0;
        //find the middle number in prime list
        while( currentNumber  <= (sum/2)){
            currentNumber = primtList.get(index++);
        }
        int leftIndex = index-1, rightIndex = index-1;
        while(leftIndex>=0 && primtList.get(rightIndex) < sum && rightIndex < primtList.size()){
            if(primtList.get(leftIndex) + primtList.get(rightIndex) == sum){
                System.out.println(primtList.get(leftIndex) + " " + primtList.get(rightIndex));
                break;
            }
            if(primtList.get(leftIndex)+ primtList.get(rightIndex) <sum){
                rightIndex++;
            }else if(primtList.get(leftIndex)+ primtList.get(rightIndex) >sum){
                leftIndex--;
            }
        }



    }
    public static List<Integer> calculatePrimeNumbers(){
        List<Integer> primeList = new ArrayList<>();
        for (int i = 4; i*i < 10000000; i++) {
            boolean isPrime = true;
            for (int j = 2; j*j <= i; j++) {
                if(i%j==0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime&& i>1){
                primeList.add(i);
            }

        }
        return primeList;
    }
}
