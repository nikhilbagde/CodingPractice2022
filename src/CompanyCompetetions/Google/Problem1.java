package CompanyCompetetions.Google;

/**
 * Created by Nikhi on 12/24/2016 12:56 PM.
 * 48 -> 0, 49-> 1......57->9
 */
public class Problem1 {
    public static void main(String[] args) {
        System.out.println(solution(623315));
    }
    public static int solution(int number){
        int maxNumber = 0;
        String numberStr = String.valueOf(number);
        for (int index = 0; index < numberStr.length()-1; index++) {
            String prevString = numberStr.substring(0,index);

            int number1 = (int) numberStr.charAt(index)-48;
            int number2 = (int) numberStr.charAt(index+1)-48;

            String remainingString = Math.round((float)(number1+number2)/2) + numberStr.substring(index+2);

            String finalString = prevString + remainingString;
            if( maxNumber < Integer.parseInt(finalString)){
                maxNumber = Integer.parseInt(finalString);
            }
        }
        return maxNumber;
    }
}
