package Mathematics.Set1;

/**
 * Created by Nikhil on 1/21/2017 12:57 PM.
 */
public class ReverseInteger {
    private static int reverseInteger(int number){
        boolean isNegative = false;
        if(number<0){
            isNegative = true;
            number = Math.abs(number);
        }
        String numberInString = String.valueOf(number);
        int result = Integer.parseInt(new StringBuilder(numberInString).reverse().toString());

        return isNegative ? -result: result;
    }

    private static int reverseInteger2(int number){
        boolean isNegative = false;
        if(number<0){
            isNegative = true;
            number = 0 - number;            //new way to make number negative without using LeetCode.Math.abs() or * -1
        }

        int result = 0;
        while(number>0){
            int unitplace  = number%10;             //123%10 =  3 get reminder (basically number at units place) | 12%10=2  | 1%10=1
            number = number/10;                     //123/10 = 12 cut down unit digit number                     | 12/10 = 1 | 1/10=0
            result = result * 10 + unitplace;       // 0 *10 + 3=3, 3*10+2=32 | 32*10+1= 321
        }
        return isNegative? 0-result: result;
    }

    private static int reverseInteger3(int number) { //123->12->1
        int result = 0;
        while(number!=0){
            result = result * 10 + number % 10;       //3 -> 2+30=32 -> 320+1=321
            number /= 10;                            //12 -> 1 ->0
        }
        return result;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int reverse = reverseInteger(-123);
        System.out.println("reverse = " + reverse);
        long endTime = System.currentTimeMillis();

        System.out.println("totalTime = " + (endTime-startTime));

        int reverse2 = reverseInteger2(-123);
        System.out.println("reverse = " + reverse2);

        int reverse3 = reverseInteger3(-123);
        System.out.println("reverse = " + reverse3);
    }
}
