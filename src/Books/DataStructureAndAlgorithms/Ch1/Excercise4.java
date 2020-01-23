package Books.DataStructureAndAlgorithms.Ch1;

/*
Write a short Java method, isEven, that takes an int i and returns true if and only
if i is even. Your method cannot use the multiplication, modulus, or division
operators, however.
 */
public class Excercise4 {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(i + " = " + isEven(i));     //right
        }
        for (int i = 0; i < 100; i++) {
            System.out.println(i + " = " + isEven2(i));    //wrong
        }

    }

    public static boolean isEven(int i) {
        return !((i & 1) == 1);
    }

    public static boolean isEven2(int i) {
        return (i & 0) == 0;       //wrong any number & 0 will always be zero.
    }
}
