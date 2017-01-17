package Algorithm.Bitwise;

/**
 * Created by Nikhi on 10/19/2016.
 * ASCI team did one awesome job, all small letter from a to z have their 6th bit as 0
 * and all upper letter A to Z have their 6th digit as 1. keeping all other bits same.
 * So to convert lower case to upper case, we just have to change its 6th bit.
 *
 * Now to change 6th bit, we will have to use EXOR as .  0 ^ 1 = 1 ( 0 changed to 1)   again same 1 ^ 1 = 0 (original zero)
 *                                                       1 ^ 1 = 0 (1 changed to 0) again same 0 ^ 1 = 1 (original 1)
 *
 *  But from where we can get 1 as 6th bit and all other zero consider 64 bit number.
 *  we have space  ' ' character value as 32 and it has only 6th bit as 1 and all other zero.
 *  Hence we can use it to exOr with 6th digit as 1.
 */
public class UpperCase {
    public static void main(String[] args) {
        char x = 'a';
        char y = 'B';

        /*char z = toggleCase(x);
        char z1 = toggleCase(y);
        */
        char z = toggleCase2(x);
        char z1 = toggleCase2(y);

        System.out.println(z);
        System.out.println(z1);
    }
    private static char toggleCase(char x){
        int y = 32;    // in bits = 00100000
        int x1  = (int) x;
        int  z =  x1 ^ y;
        return (char) z;
    }

    private static char toggleCase2(char x){
        return (char ) ((int) x ^ 32);
    }
}
