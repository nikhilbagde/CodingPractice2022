package GeeksForGeeks.JavaReview.Random2;

/**
 * Created by Nikhil on 1/7/2017 2:40 AM.
 */
public class ChracterToIntMagic {
    public static void main(String[] args) {
        char first = '0';       //ASCII value of 0->48 9->57
        char second = '1';
        char third = '9';

        char four = 'a';        //a->97 z->97+26
        char five = 'z';
        char six = 'A';         //A->65, Z->65+26
        char seven = 'Z';


        byte eight = -128;
        short nine = 1234;
        char ten = 'n';         //97+14     96=0 97=1(A) + 14 =15 | 96+14=n
        char eleven = 'p';      //97+16
        System.out.println(eight + eight);
        System.out.println(nine + nine);
        System.out.println((int) ten );
        System.out.println((int) eleven );
        System.out.println( eleven + ten);

        System.out.println(first +  second + third);
        System.out.println(four + " " +  five+ " " + six + " " + seven);
        System.out.println((int)four + " " + (int) five+ " " + (int)six + " " + (int)seven);
    }
}
