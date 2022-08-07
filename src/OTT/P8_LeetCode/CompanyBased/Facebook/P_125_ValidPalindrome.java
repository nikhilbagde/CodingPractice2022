package LeetCode.CompanyBased.Facebook;

public class P_125_ValidPalindrome {
    public static void main(String[] args) {

    }

    /**
     * Input: s = "A man, a plan, a canal: Panama"
     * Output: true
     * Explanation: "amanaplanacanalpanama" is a palindrome.
     */
    public static boolean isValidPalindrom(String s){
        //Error checks
        //two index, start from zero and last element.
        // while both does not cross
        // while i < j and we dont have character keep moving i++ and same while for j-- keeping i<j in bound.
        // Now check if both char are not equal then return false
        // at last when while loop ends return true
        //REMEMBER: Character class has a method: isLetterOrDigit()  , toLowerCase(), getNumericValue()
        if(s == null || s.length()==0) return true;
        int i =0, j= s.length()-1;

        while(i<j){
            while( i<j && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while( i<j && !Character.isLetterOrDigit(s.charAt(j))){
                i++;
            }
            if( i < j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){       // add case check, convert to lowercase and check.
                return false;
            }
        }
        return true;
    }
}
