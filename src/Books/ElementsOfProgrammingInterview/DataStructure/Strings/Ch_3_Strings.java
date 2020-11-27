package Books.ElementsOfProgrammingInterview.DataStructure.Strings;

public class Ch_3_Strings {
    public static void main(String[] args) {

        String s = "String if what";
        char charAtString = s.charAt(0);

        int compareString = s.compareTo("string");

        String concatedString = s.concat(" is amazing");

        boolean containsResult = s.contains("ri");
        boolean containsResult2 = s.contains("rig");
        boolean containsResult3 = s.startsWith("St");
        boolean containsResult4 = s.startsWith("S");
        boolean endsWithString = s.endsWith("ring");
        boolean endsWithString2 = s.endsWith("ng");
        int indexOfResult = s.indexOf("ng");
        int indexOfResult2 = s.indexOf("n");
        int indexOfResult3 = s.indexOf("g");
        int indexOfResult4 = s.indexOf("g", 5);
        int indexOfResult5 = s.indexOf("g", 2);
        int indexOfResult6 = concatedString.lastIndexOf("g");
        int lengthOfString = s.length();
        s = s.replace("a", "A");

        String s1 = "foo::bar::abc";
        String[] splitResult = s1.split("::");

        String subString1 = concatedString.substring(1);
        String subString2 = concatedString.substring(1, 5);
        char[] charArray = concatedString.toCharArray();

        //StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("Appending");
        char aa = sb.charAt(1);
        aa = sb.charAt(2);
        sb.delete(2, 4);
        sb.deleteCharAt(2);
        sb.insert(0, 1);
        sb.insert(0, 'd');
        sb.insert(0, "as");
        sb.replace(2, 4, "replaced");
        String ss = sb.toString();


        P1_isPalindromic();
    }

    private static void P1_isPalindromic() {
        String input = "aabbssssbbaa";
        String input_1 = "aabaa";
        String input_2 = "aabbaa";
        String input_3 = "";

        for (int i = 0, j = input.length() - 1; i < j; i++, j--) {
            if (input.charAt(i) != input.charAt(j)) {
                System.out.println(" Not a Palindromic");
            }
        }
        System.out.println("It is Palindromic");
    }
    //Time: O(N) and Space: O(1)
}
