package Contest.CodeForces.Contets753;

import java.util.*;

/**
 * Created by Nikhil on 12/29/2016 4:47 AM.
 */
public class SantaClauseAndCandies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        divide(number);
    }
    private static void divide(int number){

        Set<Integer> set = getPrimeNumberList();
        for (Iterator<Integer> iterator = set.iterator(); iterator.hasNext() ; ) {
            int reminder = number % iterator.next();
                if(reminder == 1 || reminder == 2){
                    break;
                }
            System.out.println(reminder);

        }
    }
    private static Set<Integer> getPrimeNumberList(){
        Set<Integer> set = new LinkedHashSet<>();
        set.add(2);
        for (int number = 3; number*number <=1000 ; number++) {
            if(number % 2 != 0){
                for (int i = 3; i < number; i++) {
                    if(number%i !=0){
                        set.add(number);
                    }
                }
            }
        }
        System.out.println(set);
        return set;
    }
}
