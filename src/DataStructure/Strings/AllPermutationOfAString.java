package DataStructure.Strings;

/**
 * Created by Nikhil on 1/15/2017 2:39 PM.
 */
public class AllPermutationOfAString {
    private static void permutation(String input){
        permutationRec("", input);
    }
    private static void permutationRec(String pre, String input){
        int length = input.length();
        if(length == 0){
            System.out.println(pre);
        }else{
            for (int i = 0; i < input.length(); i++) {
                String firstPart = pre + input.charAt(i);
                String secondPart = input.substring(0,i) + input.substring(i+1);
                permutationRec(firstPart, secondPart);
            }
        }
    }

    public static void main(String[] args) {
        permutation("abcdefghijk");
    }
}
