package OTT.P7_GeeksForGeeks.JavaReview.String;

import java.util.Arrays;
import java.util.regex.Pattern;

public class StringManipulation {

	public static void main(String[] args) {
		String one =  "one";
		String two = "one";
		String three = new String("one");
		String four = new String("one");
		System.out.println(one == two);
		System.out.println(one.equals(two));
		System.out.println(three == four);
		System.out.println(three.equals(four));
		System.out.println(one.length());
		
		//spilt and join 
		String a = "1,2,3,4,5,6";
		String[] aa = a.split(Pattern.quote(","));
		System.out.println(Arrays.toString(a.split(Pattern.quote(","))));
		System.out.println(Arrays.toString(aa));
		
		String b = String.join("->", aa);
		System.out.println(b);
		
	}

}

