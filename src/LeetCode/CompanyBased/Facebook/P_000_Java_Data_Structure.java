package LeetCode.CompanyBased.Facebook;

public class P_000_Java_Data_Structure {
    public static void main(String[] args) {
        boolean isDigit = Character.isDigit('3');
        System.out.println("isDigit = " + isDigit);
        int numericValue = Character.getNumericValue('3');
        System.out.println("numericValue = " + numericValue);

        //String
        String a = "String";
        a = a.substring(0, a.length() / 2);  //subString with small s
        a = "abacd";
        int index = a.indexOf('a');  //=0
        //but to get 2nd index of 1, we need to start from some index. we use, overloaded method
        // of s.indexOf(character to find, the index); and not otherwise. index comes later as paramter
        index = a.indexOf('a', 1);  //=2

    }
}
