package Books.DataStructureAndAlgorithms.Ch1;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * R-1.9 Write a short Java method that uses a StringBuilder instance to remove all the
 * punctuation from a string s storing a sentence, for example, transforming the
 * string "Let’s try, Mike!" to "Lets try Mike".
 */
public class Excercise9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String inputString = scanner.nextLine();
            StringBuilder stringBuilder = new StringBuilder();

            /*removeAllSpecialCharactersFromInputString_1(inputString, stringBuilder);
            System.out.println(stringBuilder.toString());

            removeAllSpecialCharactersFromInputString_2(inputString);*/

            removeAllSpecialCharactersFromInputString_3(inputString);

        }

    }

    /**
     * https://theasciicode.com.ar/ ASCII table.
     *
     * @param inputString
     * @param stringBuilder
     */
    private static void removeAllSpecialCharactersFromInputString_1(String inputString, StringBuilder stringBuilder) {
        for (char ch : inputString.toCharArray()) {
            int intValOfChar = ch;
            if ((intValOfChar >= 65 && intValOfChar <= 90)           //A - Z
                    || (intValOfChar >= 97 && intValOfChar <= 122)) { // a-z
                stringBuilder.append(ch);
            }
        }
    }

    private static void removeAllSpecialCharactersFromInputString_2(String inputString) {
        List<Character> list = inputString
                .chars()
                .mapToObj(o -> (char) o)
                .mapToInt(o -> o)
                .filter(o -> ((o >= 65 && o <= 90) || (o >= 97 && o <= 122)))
                .mapToObj(o -> (char) o)
                .collect(Collectors.toList());
        System.out.println("Stream " + list);
    }

    /**
     * @param inputString
     * @return PASSED!
     */
    private static StringBuilder removeAllSpecialCharactersFromInputString_3(String inputString) {
        StringBuilder stringBuilder = inputString
                .chars()
                /*.mapToObj( o -> (char)o)
                .mapToInt( o -> o)*/
                .filter(o -> ((o >= 65 && o <= 90) || (o >= 97 && o <= 122) || o == 32))
                .mapToObj(o -> (char) o).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append);

        System.out.println("String builder output : " + stringBuilder.toString());
        return stringBuilder;
    }

    /**
     * Debug 3rd method:
     * 1)  What you think about that? I said,"Okay, let me think about it!. Will you wait?";
     * String builder output : WhatyouthinkaboutthatIsaidkayletmethinkaboutitWillyouwait
     * Problem:
     *  Space is not getting calculated
     * Solution:
     *  Add space in the filter option.
     *
     * 2) String.chars() generates input stream No need to to mapToObj(o->(Char)o).mapToInt(o->o)
     */
}
