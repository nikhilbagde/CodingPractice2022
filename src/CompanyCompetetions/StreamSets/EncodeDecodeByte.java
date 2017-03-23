package CompanyCompetetions.StreamSets;

/**
 * Created by Nikhil on 3/23/2017 1:01 PM.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * encode(byte []) -> byte [], such that there are no zero bytes (0x00)
 * Work with arbitrary byte arrays: size, content
 * Fully reversible: decode(encode(A)) = A
 */

// 0 - 255 (unsigned)
// -128 - 127 (signed)

// 0x00 (binary) = 0 (decimal)
// 0xFF (binary) = 255 (decimal)

// A
//input = [0       1  255]
//input = [0x00 0x01 0xFF] ->  [0x01 0xFF, -1,  ]
//input = [0x00 0x01 0xFF 0x00 0x02 ] -> [0x01 0xFF, 0x02, 0x00, 0x00, 0x03 ]
//          x


public class EncodeDecodeByte {
// encode(input) = [data_without_zeros metadata]
// 1) Where data ends, metadata starts -> length of input ()
// [one byte - count, data, metadata]
// [0x00 0x01 0xFF] = [ ??? ] = [1,  0x01 0xFF,
// [0x00 0x01 0xFF 0x00 0x02 ]  = [2, 0x01, 0xFF, 0x02, loc1, loc2]
// 2) Can't zero as an index  protocol = (1-index)

    public static Byte[] encode(byte[] input) {

        int count = 0;

        List<Byte> locationList = new ArrayList<>();
        List<Byte> newList = new LinkedList<>();

        for (int i = 0; i < input.length; i++) {
            if (input[i] == (byte) 0x00) {
                count++;                      //header
                locationList.add(((byte) (i + 1)));      //protocol  - metadata
            } else {
                newList.add(input[i]);      //data
            }
        }

        newList.add(0, (byte) count);    //add at the head    header-data

        for (Byte loc : locationList) {
            newList.add(loc);
        }

        return newList.toArray(new Byte[newList.size()]);
    }

    public static void main(String[] args) {
        test(new byte[]{(byte) 0x00, (byte) 0x01, (byte) 0xFF});
        test(new byte[]{(byte) 0xFF, (byte) 0x00, (byte) 0xFF});
    }

    private static void test(byte[] bytes) {
        System.out.print("Input: ");
        printBytes(bytes);
        System.out.println();
        System.out.print("Output: ");
        printBytes(encode(bytes));
        System.out.println();
        System.out.println();
    }

    private static void printBytes(byte[] bytes) {
        for (byte b : bytes) {
            System.out.printf("0x%02X ", b);
        }
    }

    private static void printBytes(Byte[] bytes) {
        for (Byte b : bytes) {
            System.out.printf("0x%02X ", (byte) b);
        }
    }
} // Class solution

/*
Nikhil Bagde ran 83 lines of Java (finished in 1.63s):

Input: 0x00 0x01 0xFF
Output: 0x01 0x01 0xFF 0x01

Input: 0xFF 0x00 0xFF
Output: 0x01 0xFF 0xFF 0x02

 */