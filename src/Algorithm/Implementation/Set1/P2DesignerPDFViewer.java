package Algorithm.Implementation.Set1;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import static java.lang.System.in;

/**
 * Created by Nikhil on 2/13/2017 7:34 PM.
 * When you select a contiguous block of text in a PDF viewer,
 * the selection is highlighted with a blue rectangle. In a new kind of PDF viewer,
 * the selection of each word is independent of the other words;
 * this means that each rectangular selection area forms independently around each highlighted word.
 * For example: PDF-highighting.png
 * In this type of PDF viewer, the width of the rectangular selection area is equal to the number of letters
 * in the word times the width of a letter, and the height is the maximum height of any letter in the word.
 * Consider a word consisting of lowercase English alphabetic letters, where each letter is  wide.
 * Given the height of each letter in millimeters (), find the total area that will be highlighted by blue rectangle in
 * when the given word is selected in our new PDF viewer.
 * Input Format
 * The first line contains  space-separated integers describing the respective heights of each consecutive lowercase
 * English letter (i.e., ).
 * The second line contains a single word, consisting of lowercase English alphabetic letters.
 * Constraints
 * where  is an English lowercase letter.  Word contains no more than  letters.
 * Output Format
 * Print a single integer denoting the area of highlighted rectangle when the given word is selected.
 * The unit of measurement for this is square millimeters (), but you must only print the integer.
 */
public class P2DesignerPDFViewer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);
        //int letterCount = 26;
        Map<Character, Integer> heightMap = new TreeMap<>();
        //char first = 'a';

        int[] characters = new int[26];
        for (int letter = 0; letter < 26; ++letter) {
            characters[letter] = scanner.nextInt();
        }
        String word = scanner.next();
        int maxHeight = 0, maxWidth = 1;
        for (char ch : word.toCharArray()) {
            //System.out.println(characters[ch - 'a']);
            maxHeight = Math.max(maxHeight, characters[ch - 'a']);
        }
        /*for (int i = 0; i < characters.length; ++i) {
            System.out.print(characters[i] + " ");
        }
        System.out.println();
        char a = 'a';
        for (int i = 0; i < characters.length; ++i) {
            System.out.print(a++ + " ");
        }*/

        System.out.println(maxHeight * maxWidth * word.length());

    }
}
