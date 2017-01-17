package Algorithm.Strings;

/**
 * Created by Nikhil on 1/13/2017 3:43 AM.
 */
//all substring
public class AllPermutationOfString {
    public static void main(String[] args) {
        allPermutation("", "123");
    }
    private static void allPermutation(String per, String a){
        if(a.isEmpty()){
            System.out.println(per + a);
        }else{
            for (int i = 0; i < a.length(); i++) {
                allPermutation(per + a.charAt(i) , a.substring(0, i) + a.substring(i+1));
            }
        }
    }
}
