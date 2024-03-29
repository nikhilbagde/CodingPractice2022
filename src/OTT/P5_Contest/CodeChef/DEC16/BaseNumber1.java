package OTT.P5_Contest.CodeChef.DEC16;

/**
 * Created by Nikhil on 12/4/2016.
 * //given number is 6
 OTT.Algorithm
 1. Loop over 2 to given number
 2. Loop Index = base
 3. Get value of Number in Index Base or Loop from 1-6 to calculate its representation for given base from outer loop
 4. Integer.toString( InnerLoopIndex (1-6) or just 6th, base) -> get value in String.
 5. Convert it to integer value
 6. Get MSB value -> Check if its 1.
 7. Store that Base in set.
 8. Return count of set.
 http://stackoverflow.com/questions/2858065/base-n-series-generator-for-a-given-number-in-java
 https://docs.google.com/viewer?url=http://websupport1.citytech.cuny.edu/faculty/dkahrobaei/Integers%2520and%2520Algorithms.pdf
 */
public class BaseNumber1 {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int testCasesCount = sc.nextInt();
        /*if(1 <= testCasesCount && testCasesCount <= LeetCode.Math.pow(10,5)){
            for (int testCount = 0; testCount < testCasesCount ; testCount++) {
                int number = sc.nextInt();
                if(0<= number && number<= LeetCode.Math.pow(10,12)){
                    System.out.println(getCountOfOneInDifferentBaseOfNumber(number));
                }
            }
        }*/
        if(1 <= testCasesCount && testCasesCount <= Math.pow(10,5)){
            for (int testCount = 0; testCount < testCasesCount ; testCount++) {
                //int number = sc.nextInt();
                java.math.BigInteger bigInteger = new java.math.BigInteger(sc.next());
                //if( (bigInteger.compareTo(BigInteger.ZERO)==1
                //      || bigInteger.compareTo(BigInteger.ZERO)==0)
                //    && (bigInteger.compareTo(new BigInteger(Double.toString(LeetCode.Math.pow(10,12)))) == -1
                //  || bigInteger.compareTo(new BigInteger(Double.toString(LeetCode.Math.pow(10,12)))) == 0) ) {

                if (bigInteger.compareTo(new java.math.BigInteger(Integer.toString(Integer.MAX_VALUE))) == 1) {
                    System.out.println("INFINITY");
                } else if (bigInteger.compareTo(new java.math.BigInteger(Integer.toString(Integer.MAX_VALUE))) == -1) {
                    System.out.println(getCountOfOneInDifferentBaseOfNumber(Integer.parseInt(bigInteger.toString())));
                }
                //}
            }
        }
    }
    private static int getCountOfOneInDifferentBaseOfNumber(int number){
        java.util.List<Integer> listBaseNumber = new java.util.ArrayList<>();
        for (int base = 2; base <= number; base++) {
            String newBaseValue = "";
            if(base<=36) {
                //This base value works for <36
                //newBaseValue = Integer.toString(number, base);  //for Radix = 2,3.. number
                if (Integer.toString(number, base).replaceAll("[a-zA-Z]", "").charAt(0) == '1') {    //for Radix = 2,3.. number
                    listBaseNumber.add(base);
                   // continue;
                }
            }else{//construct algorithm.
                //getBaseNumber(number, base, newBaseValue);
                //newBaseValue = getBaseNumber(number, base);
                //newBaseValue = isBaseNumberHasOne(number, base) ? newBaseValue + "1": newBaseValue+"0";
                if(isBaseNumberHasOneIterative(number, base)) listBaseNumber.add(base);
                //continue;
            }
            if(listBaseNumber.size()>Math.pow(10,6)) return listBaseNumber.size();
            /*newBaseValue = newBaseValue.replaceAll("[a-zA-Z]", ""); //case when new base value has a-z characters.
            //MAX Int value has 10 digits only.
            if(newBaseValue.length()>10)newBaseValue = newBaseValue.substring(0,10);
            if (newBaseValue.length() < Integer.MAX_VALUE && getMostSignificantDigit(Integer.parseInt(newBaseValue), newBaseValue.length()) == 1) {
                listBaseNumber.add(base);
            }*/
        }
        return listBaseNumber.size();
    }
    private static int getMostSignificantDigit(int number, int length){
        for (int i = 0; i < length-1; i++) {
            number/=10;
        }
        return number;
    }
    private static String getBaseNumber(int number, int base, String newBaseValue ){
        if(number == 0){
            return new StringBuilder(newBaseValue).reverse().toString();
        }
        newBaseValue += number % base;
        getBaseNumber(number/base, base, newBaseValue);
        return "";
    }
    private static String getBaseNumber(int number, int base){
        String newNumber = "";
        if(number>0){
            getBaseNumber(number/base, base);
            newNumber = number%base + " ";
        }
        return newNumber.trim();
    }
    private static boolean isBaseNumberHasOne(int number, int base){
        if(number == 1 ){
            return true;
        }else if (number == 2){
            return false;
        }
        isBaseNumberHasOne(number/base, base);
        return false;
    }
    private static boolean isBaseNumberHasOneIterative(int number, int base){
        String newNumber = "";
        int givenNumber = number;
        while(givenNumber!=0){
            newNumber = givenNumber%base + "" + newNumber;
            givenNumber = Math.floorDiv(givenNumber, base);
        }
        return newNumber.trim().charAt(0) == '1';
    }
}
/*
OTT.Algorithm for base b expansion
OTT.Algorithm: Constructing Base b Expansions
Procedure base b expansion(n: positive integer)
q:=n
k:=0
While q!=0
    begin
    ak := q mod b
    q:= floor( q/b)
    k:= k+1
    end
{the base b expansion of n is (ak-1 ... a1 a0)b}
 */