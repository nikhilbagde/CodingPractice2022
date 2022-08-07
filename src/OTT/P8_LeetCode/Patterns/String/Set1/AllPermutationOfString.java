package LeetCode.Patterns.String.Set1;

/**
 * Created by Nikhil on 1/26/2017 7:43 PM.
 */
public class AllPermutationOfString {
    private static void permutation(String a){
        permuatationRec("", a);
    }
    private static void permuatationRec(String pre, String a){
        int n = a.length();
        if(n == 0){
            System.out.println(pre);
        }else{
            for (int i = 0; i < a.length(); i++) {
                permuatationRec(pre + a.charAt(i), a.substring(0,i) + a.substring(i+1));
            }
        }
    }
    public static void main(String[] args) {
        permutation("abcd");
    }


}
