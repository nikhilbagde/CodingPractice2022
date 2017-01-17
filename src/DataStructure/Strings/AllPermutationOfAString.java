package DataStructure.Strings;

/**
 * Created by Nikhil on 1/15/2017 2:39 PM.
 */
public class AllPermutationOfAString {
    private static void permutation(String a){
        permutationRec("", a);
    }
    private static void permutationRec(String pre, String a){
        int n = a.length();
        if(n == 0){
            System.out.println(pre);
        }else{
            for (int i = 0; i < a.length(); i++) {
                permutationRec(pre + a.charAt(i), a.substring(0,i) + a.substring(i+1));
            }
        }
    }

    public static void main(String[] args) {
        permutation("abc");
    }
}
