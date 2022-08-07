package OTT.P1_ACM.Competition2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Nikhil on 2/28/2017 7:30 PM.
 */
public class Problem2 {
    static Map<String, Integer> numbers = new HashMap<>();

    public static void main(String[] args) {
        fillAllValues();

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] allSplit = input.split("\\s+");
        if (allSplit.length == 1) {
            //has only 1 number
            System.out.println(numbers.get(allSplit[0].trim()));
        } else {

            String[] splitOnAdd = input.split("plus");
            //[seventeen ,  thirty eight divided by two minus zero times sixty nine]
            String[] splitOnMinus = splitOnAdd[1].split("minus");
            //[ thirty eight divided by two ,  zero times sixty nine]

            System.out.println(Arrays.toString(splitOnAdd));
            System.out.println(Arrays.toString(splitOnMinus));

            String[] splitOnDivide, splitOnMul;
            boolean divideNegative = false;
            if (splitOnMinus[0].contains("divided")) {
                splitOnDivide = splitOnMinus[0].split("divided by");    //[ thirty eight ,  two ]
                splitOnMul = splitOnMinus[1].split("times");            //[ zero ,  sixty nine]

            } else {
                divideNegative = true;
                splitOnMul = splitOnMinus[0].split("times");
                splitOnDivide = splitOnMinus[1].split("divided by");
            }
            //System.out.println(Arrays.toString(inputArray));
            System.out.println(Arrays.toString(splitOnDivide));
            System.out.println(Arrays.toString(splitOnMul));

            long divResult = numbers.get(splitOnDivide[0].trim()) / numbers.get(splitOnDivide[1].trim());
            long mulResult = numbers.get(splitOnMul[0].trim()) * numbers.get(splitOnMul[1].trim());

            splitOnMinus[0] = String.valueOf(divideNegative ? divResult * (-1) : divResult);
            splitOnMinus[1] = String.valueOf(divideNegative ? mulResult : (-1) * mulResult);

            long addSecond = Integer.parseInt(splitOnMinus[0]) + Integer.parseInt(splitOnMinus[1]);

            long resultFinal = numbers.get(splitOnAdd[0].trim()) + addSecond;
            System.out.println(resultFinal);
        }
    }

    public static int getValue(String string) {
        return numbers.get(string);
    }

    private static void fillAllValues() {
        numbers.put("zero", 0);
        numbers.put("one", 1);
        numbers.put("two", 2);
        numbers.put("three", 3);
        numbers.put("four", 4);
        numbers.put("five", 5);
        numbers.put("six", 6);
        numbers.put("seven", 7);
        numbers.put("eight", 8);
        numbers.put("nine", 9);
        numbers.put("ten", 10);
        numbers.put("eleven", 11);
        numbers.put("twelve", 12);
        numbers.put("thirteen", 13);
        numbers.put("fourteen", 14);
        numbers.put("fifteen", 15);
        numbers.put("sixteen", 16);
        numbers.put("seventeen", 17);
        numbers.put("eighteen", 18);
        numbers.put("nineteen", 19);
        numbers.put("twenty", 20);
        numbers.put("twenty one", 21);
        numbers.put("twenty two", 22);
        numbers.put("twenty three", 23);
        numbers.put("twenty four", 24);
        numbers.put("twenty five", 25);
        numbers.put("twenty six", 26);
        numbers.put("twenty seven", 27);
        numbers.put("twenty eight", 28);
        numbers.put("twenty nine", 29);
        numbers.put("thirty", 30);
        numbers.put("thirty one", 31);
        numbers.put("thirty two", 32);
        numbers.put("thirty three", 33);
        numbers.put("thirty four", 34);
        numbers.put("thirty five", 35);
        numbers.put("thirty six", 36);
        numbers.put("thirty seven", 37);
        numbers.put("thirty eight", 38);
        numbers.put("thirty nine", 39);
        numbers.put("forty", 40);
        numbers.put("forty one", 41);
        numbers.put("forty two", 42);
        numbers.put("forty three", 43);
        numbers.put("forty four", 44);
        numbers.put("forty five", 45);
        numbers.put("forty six", 46);
        numbers.put("forty seven", 47);
        numbers.put("forty eight", 48);
        numbers.put("forty nine", 49);
        numbers.put("fifty", 50);
        numbers.put("fifty one", 51);
        numbers.put("fifty two", 52);
        numbers.put("fifty three", 53);
        numbers.put("fifty four", 54);
        numbers.put("fifty five", 55);
        numbers.put("fifty six", 56);
        numbers.put("fifty seven", 57);
        numbers.put("fifty eight", 58);
        numbers.put("fifty nine", 59);
        numbers.put("sixty", 60);
        numbers.put("sixty one", 61);
        numbers.put("sixty two", 62);
        numbers.put("sixty three", 63);
        numbers.put("sixty four", 64);
        numbers.put("sixty five", 65);
        numbers.put("sixty six", 66);
        numbers.put("sixty seven", 67);
        numbers.put("sixty eight", 68);
        numbers.put("sixty nine", 69);
        numbers.put("seventy", 70);
        numbers.put("seventy one", 71);
        numbers.put("seventy two", 72);
        numbers.put("seventy three", 73);
        numbers.put("seventy four", 74);
        numbers.put("seventy five", 75);
        numbers.put("seventy six", 76);
        numbers.put("seventy seven", 77);
        numbers.put("seventy eight", 78);
        numbers.put("seventy nine", 79);
        numbers.put("eighty", 80);
        numbers.put("eighty one", 81);
        numbers.put("eighty two", 82);
        numbers.put("eighty three", 83);
        numbers.put("eighty four", 84);
        numbers.put("eighty five", 85);
        numbers.put("eighty six", 86);
        numbers.put("eighty seven", 87);
        numbers.put("eighty eight", 88);
        numbers.put("eighty nine", 89);
        numbers.put("ninety", 90);
        numbers.put("ninety one", 91);
        numbers.put("ninety two", 92);
        numbers.put("ninety three", 93);
        numbers.put("ninety four", 94);
        numbers.put("ninety five", 95);
        numbers.put("ninety six", 96);
        numbers.put("ninety seven", 97);
        numbers.put("ninety eight", 98);
        numbers.put("ninety nine", 99);
        numbers.put("one hundred", 100);

    }

}
/*
ten
=10
zero times ninety five divided by five plus eleven
= 11
twenty two divided by thirty three times forty four plus fifty five minus sixty six plus seventy seven minus eighty eight plus ninety nine divided by eleven
= 16
forty divided by two
= 20
 */