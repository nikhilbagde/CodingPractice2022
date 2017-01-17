package Java;

/**
 * Created by Nikhil on 1/13/2017 3:21 PM.
 */
public class Test {
    String input = "hello"; //holle "Helloa"    halloe
    String subString = "bn"; //nb false; bn -> true;

    private static void reverseVowels(String a){
        //Hello
        int length = a.length();
        for (int i = 0; i < a.length(); i++) {

        }
        int index = 0;
        int reverseIndex  = length-1;
        StringBuilder stringBuilder = new StringBuilder(a);
        while(index < length){
            stringBuilder.append(a.charAt(index));
            /*if( isVowel(a.charAt(index)) && isVowel(a.charAt(reverseIndex))){
                char temp = a.charAt(index);

            }*/
            if(isVowel(stringBuilder.charAt(index)) && isVowel(stringBuilder.charAt(reverseIndex))){

            }
        }

    }
    private static boolean isVowel(char c){
        return c == 'a' || c == 'i' || c== 'o' || c=='e' || c=='u';
    }
    private static void checkSubString(String input, String subString){
        char [] inputArray = input.toCharArray();
        char [] subStringArray = subString.toCharArray();
        int index  = 0;
        for (int i = 0; i < input.length(); i++) {
            input.indexOf(i);
        }

    }
    private static int  findMax(int a, int b){
        return (a > b) ? a : b;
    }
    //String  = abc -> acb , bac , bca, cab, cba
    private static void permutation(String a){
        permuationRec("", a);
    }
    private static void permuationRec(String pre, String a){
        int n = a.length();
        if(n == 0){
            System.out.println(pre);
        }else{
            for (int i = 0; i < a.length(); i++) {
                permuationRec(pre + a.charAt(i), a.substring(0,i) + a.substring(i+1));
            }
        }
    }

    public static void main(String[] args) {
        permutation("ab");
    }

}


/*
a = 2
b = 4
for( a = 1

 */
