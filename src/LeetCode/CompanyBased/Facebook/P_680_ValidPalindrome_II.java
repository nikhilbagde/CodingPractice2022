package LeetCode.CompanyBased.Facebook;


public class P_680_ValidPalindrome_II {
    public static void main(String[] args) {
        //String input = "abca";
        //String input = "abcdecba";
       // String input = "abcdecdba";    // a =2 b = 2 , c =2,  d=2, e =1
        String input = "tebbem";    // a =2 b = 2 , c =2,  d=2, e =1
        boolean answer = validPalindrome(input);
        boolean answer2 = validPalindrome2(input);
        System.out.println("answer1 = " + answer);
        System.out.println("answer2 = " + answer2);
    }

    /**
     * Time: O(n) Space: O(1)
     * @param s
     * @return
     */
    public static  boolean validPalindrome(String s) {
        int low = 0, high = s.length()-1;
        while(low<high){
            char c1 = s.charAt(low);
            char c2 = s.charAt(high);

            if(c1 == c2){
                low++;
                high--;
            }else{
                boolean flag1 = true, flag2 = true;

                for (int i = low, j= high-1; i < j ; i++, j--) {
                    if(s.charAt(i)!= s.charAt(j)){
                        flag1= false;                                   //add break to make it faster.
                        break;
                    }
                }

                for (int i = low+1, j= high; i < j ; i++, j--) {
                    if(s.charAt(i)!= s.charAt(j)){
                        flag2= false;
                        break;
                    }
                }

                return flag1 || flag2;
            }

        }
        return true;
    }

    /*
    Time: O(N) Space: O(N)
     We can not reshuffle the letter mind you. Hence this solution is wrong. I am just checking if I have more than 2 odd count. But it does not look for the position of letters
     E.g. tebbem  B and E are balanced. but If  I remove either t or m, it wont be palindrome as m is not balanced. So above solution only works.
     */
    public static boolean validPalindrome2(String s){
        java.util.Map<Character, Integer> map = new java.util.HashMap<>();
        for ( char c:  s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        System.out.println("map = " + map);

        int oddCount = 0;
        for ( Integer count :  map.values()) {
            if(count % 2 != 0){
                ++oddCount;
                if(oddCount>=2){
                    return false;
                }
            }
        }
        return true;
    }
}
