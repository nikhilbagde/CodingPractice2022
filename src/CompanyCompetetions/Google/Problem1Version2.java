package CompanyCompetetions.Google;

/**
 * Created by Nikhi on 12/24/2016 12:56 PM.
 */
public class Problem1Version2 {
    public static void main(String[] args) {
        int x= 623315;
        solution(x);
    }
    public static int solution(int X) {
        // write your code in JavaReview SE 8
        int max = 0;
        String inputNumber = String.valueOf(X);
        for(int index=0;index<inputNumber.length()-1;index++){
            String remaining = inputNumber.substring(index+2, inputNumber.length());
            int number1= (int) inputNumber.charAt(index);
            int number2= (int) inputNumber.charAt(index + 1);
            int roundedNumber=Math.round((float)(number1+number2-96)/2);
            String out = inputNumber.substring(0,index) + String.valueOf(roundedNumber)+ remaining;
            if(Integer.valueOf(out)>max){
                max=Integer.valueOf(out);
            }
        }
        return max;
    }
}
