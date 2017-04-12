package CompanyCompetetions.Amazon.Interview1;

/**
 * Created by Nikhil on 4/6/2017 6:53 PM.
 */
public class POW {
    private static int pow4(int base, int power) {
        if (power == 0) return 1;
        if (power == 2) return base * base;
        if (power % 2 == 0) {                                                //for all power which are divisible by 2
            return pow4(pow4(base, power / 2), 2);                    // [pow(base , half power) , power]
        } else if (power > 0) {                                             //for all positive powers
            return base * pow4(pow4(base, power / 2), 2);             // base * (half),2
        } else {                                                            //for all negative powers
            return 1 / base * pow4(pow4(base, power / 2), 2);         //1/ base * (half),2
        }
    }
}
