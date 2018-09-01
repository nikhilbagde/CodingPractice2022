package Algorithm.Implementation.Easy;


import java.util.Scanner;

/**
 * Created by nbagde on 8/18/2018.
 */
public class DayOfTheProgrammer {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int year = scanner.nextInt();
        String date = findDayOfTheProgrammer(year);
        System.out.println(date);
    }
    private static String findDayOfTheProgrammer(int year){
        if(year<1918){
            if(year%4==0){
                return "12.09."+year+"";
            }else{
                return "13.09."+year+"";
            }
        }else if(year>1918){
            if(year%400==0 || (year%4==0 && year%100!=0) ){
                return "12.09."+year+"";
            }else{
                return "13.09."+year+"";
            }
        }else{
                return "26.09."+year+"";
        }
    }
}
