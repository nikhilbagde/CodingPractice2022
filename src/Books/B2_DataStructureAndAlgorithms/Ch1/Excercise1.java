package Books.B2_DataStructureAndAlgorithms.Ch1;

import java.util.Scanner;

/*
Write a short Java method, inputAllBaseTypes, that inputs a different value of
each base type from the standard input device and prints it back to the standard
output device.
 */
public class Excercise1 {
    public static void main(String[] args) {
        inputAllBaseTypes();
    }

    public static void inputAllBaseTypes(){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            System.out.println(scanner.next());
            /*System.out.println(scanner.nextBoolean());
            System.out.println(scanner.nextByte());
            System.out.println(scanner.nextDouble());
            System.out.println(scanner.nextFloat());
            System.out.println(scanner.nextInt());
            System.out.println(scanner.nextLine());
            System.out.println(scanner.nextShort());
            System.out.println(scanner.nextLong());*/

        }
    }
}
