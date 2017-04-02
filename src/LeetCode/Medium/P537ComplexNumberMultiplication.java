package LeetCode.Medium;

/**
 * Created by Nikhil on 4/2/2017 2:10 PM.
 */
public class P537ComplexNumberMultiplication {
    public static void main(String[] args) {
        String a = "1+1i", b = "1+1i";
        String c = "1-1i", d = "1-1i";
        //System.out.println(complexNumberMultiply(a,b));
        System.out.println(complexNumberMultiply(c, d));
    }

    private static String complexNumberMultiply(String a, String b) {
        String[] sign = new String[4];
        if (a.length() > 4) {
            sign[0] = "-";
            sign[1] = String.valueOf(a.charAt(2));
        } else {
            sign[0] = "+";
            sign[1] = String.valueOf(a.charAt(1));
        }

        if (b.length() > 4) {
            sign[2] = "-";
            sign[3] = String.valueOf(b.charAt(2));
        } else {
            sign[2] = "+";
            sign[3] = String.valueOf(b.charAt(1));
        }

        String[] aa, bb;
        a = a.length() > 4 ? a.substring(1) : a;
        b = b.length() > 4 ? b.substring(1) : a;

        aa = a.split("[+-]");
        bb = b.split("[+-]");

        if (aa.length > 2) {
            System.arraycopy(aa, 1, aa, 0, 2);
        }
        if (bb.length > 2) {
            System.arraycopy(bb, 1, bb, 0, 2);
        }

        int sum[] = new int[4];

        sum[0] = Integer.parseInt(aa[0]) * Integer.parseInt(bb[0]);             //This will be real number only.
        sum[1] = Integer.parseInt(aa[0]) * Integer.parseInt(bb[1].substring(0, 1));  //this is must imaginary number (contains i)
        sum[2] = Integer.parseInt(aa[1].substring(0, 1)) * Integer.parseInt(bb[0]);  //this must be imaginary number (contains i)
        sum[3] = Integer.parseInt(aa[1].substring(0, 1)) * Integer.parseInt(bb[1].substring(0, 1));   // this must be real only. i*i=-1 (i gone)
        // 0  1        2  3
        //String a =  "5+6i", b = "7+8i";
        //Sign         +  +        +  +
        //sum         35 40i      42i (48i^2= -48)
        //num          R  i        I      R
        //tricky

        int realPart = sign[0].equals("-") || sign[2].equals("-") ? -sum[0] : sum[0];
        realPart += -1 * (sign[1].equals("-") || sign[3].equals("-") ? -sum[3] : sum[3]);      //as it would always give i*i=-1 hence mul by -1

        int imaginaryPart = sign[0].equals("-") || sign[3].equals("-") ? -sum[1] : sum[1];
        imaginaryPart += sign[1].equals("-") || sign[2].equals("-") ? -sum[2] : sum[2];

        return "" + realPart + "" + (imaginaryPart < 0 ? (imaginaryPart + "i") : "+" + (imaginaryPart + "i"));
    }
}
