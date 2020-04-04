package Books.CrackingTheCodingInterview.Chapter1ArrayAndString;

/**
 * Created by Nikhil on 10/26/2016.
 * Write a method to compress a string aabcccccaa to a2b1c5a3
 */
public class Question5CompressString {
    public static void main(String[] args) {
        String str = "aabcccccaa";
        compress(str);
    }
    //aabbbcccccaa
    //a2b3c5a2
    private static void compress(String str){
        StringBuilder stringBuilder = new StringBuilder(); //Better

        for (int i = 0; i < str.length(); i++) {
            int counter = 1;
            stringBuilder.append(str.charAt(i)); //Better     1.first Added letter
            while(i < str.length()-1 && str.charAt(i) ==  str.charAt(i+1)) {    // 2. while i<length and next char is same as previous
                counter++;
                i++;
            }
            stringBuilder.append(counter); //Better    3. Now append that number
        }
    }
    private static void compressExplained(String str){
        String newstr = ""; // Bad programming
        StringBuilder stringBuilder = new StringBuilder(); //Better

        //aabbbcccccaa
        //a2b3c5a2
        for (int i = 0; i < str.length(); i++) {
            int counter = 1;
            newstr = newstr + str.charAt(i); //Bad
            stringBuilder.append(str.charAt(i)); //Better
            while(i < str.length()-1 && str.charAt(i) ==  str.charAt(i+1)) {
                counter++;
                i++;
            }
            newstr = newstr + counter; //Bad
            stringBuilder.append(counter); //Better
        }
    }
}
