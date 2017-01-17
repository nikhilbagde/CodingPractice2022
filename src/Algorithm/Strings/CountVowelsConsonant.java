package Algorithm.Strings;

/**
 * Created by Nikhil on 1/13/2017 3:16 AM.
 */
public class CountVowelsConsonant {
    public static void main(String[] args) {
        countVowelsConsonant("How many vowels in this String");
    }
    private static void countVowelsConsonant(String a){
        char[] chars = a.toLowerCase().toCharArray();
        int vowels = 0;
        int consonants = 0;
        for (char c: chars) {
            if(c == 'a' || c == 'e' ||c == 'i' || c == 'o' || c == 'u'){
                vowels++;
            }else
                consonants++;
        }
        System.out.println("Vowels = " + vowels + " Consonant = " + consonants);
    }
}
