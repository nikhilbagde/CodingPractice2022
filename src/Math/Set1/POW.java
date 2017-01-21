package Math.Set1;

/**
 * Created by Nikhil on 1/21/2017 1:43 PM.
 */
public class POW {
    //not working : stack overflow error!
    private static int pow(int base, int power){
        if(power == 0) return 1;
        if(power == 1) return base;
        if(power < 1) return 1/pow(base, power);
        return base * pow(base, power-1);
    }
    private static int pow2(int base, int power){
        if(power == 0) return  1;
        if(power == 1) return base;
        //if(base == 1) return 1;

        //int tempBase = base;
        int result = base%2==0 ? 1:base;
        power = power/2;

        while(power>0){
            base =  base * base;
            if(power%2==1) result = result * base;
            power = power /2;
        }
        return result;
    }

    private static int pow3(int base, int power){
        if(power == 0) return 1;
        if(power == 1) return  base;
        if(base == 1) return 1;
        int result = 1;
        while(power>0){
            result = result * base;
            power--;
        }
        return result;
    }
    private static int pow4(int base, int power){
        if (power == 0) return 1;
        if (power == 2) return base * base;
        if (power % 2 == 0){                                                //for all power which are divisible by 2
            return pow(pow(base, power / 2), 2);                    // [pow(base , half power) , power]
        } else if (power > 0) {                                             //for all positive powers
            return base * pow(pow(base, power / 2), 2);             // base * (half),2
        } else {                                                            //for all negative powers
            return 1 / base * pow(pow(base, power / 2), 2);         //1/ base * (half),2
        }
    }
    public static void main(String[] args) {
        //int result = pow(10,-2);
        //System.out.println("result = " + result);

        int result2 = pow2(10,3);
        System.out.println("result = " + result2);

        int result3 = pow3(10,3);
        System.out.println("result = " + result3);

        int result4 = pow4(10,3);
        System.out.println("result = " + result4);
    }
}
