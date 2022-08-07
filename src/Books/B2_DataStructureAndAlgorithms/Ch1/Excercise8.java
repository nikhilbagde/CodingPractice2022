package Books.B2_DataStructureAndAlgorithms.Ch1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * R-1.8 Write a short Java method that counts the number of vowels in a given character
 * string.
 * #String to character collection
 */
public class Excercise8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.next();

        //Java 7
        List<Character> characterList = StringToCharacterList1(inputString);
        System.out.println(characterList);

        //Java8 Stream API
        characterList = inputString
                .chars()
                .mapToObj(o -> (char) o)
                .collect(Collectors.toList());
        System.out.println(characterList);

        int vowelsCount = (int) characterList
                .stream()
                .filter(o -> (o == 'a' || o == 'e' || o == 'i' || o == 'o' || o == 'u'
                        || o == 'A' || o == 'E' || o == 'I' || o == 'O' || o == 'U'))
                .count();
        System.out.println("Count of vowel in given string are " + vowelsCount);
    }

    private static List<Character> StringToCharacterList1(String inputString) {
        char[] array1 = inputString.toCharArray();
        List<Character> characterList = new ArrayList<>();
        for (Character ch : array1) {
            characterList.add(ch);
        }
        return characterList;
    }

}

