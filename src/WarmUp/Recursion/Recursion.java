package WarmUp.Recursion;

public class Recursion {
    public static int TAIL_NUM_RESULT = 0;

    public static void main(String[] args) {

        // --------------- Simple Additional of all number below a given number -------------------------------
        int headNumResult = headNum(5);
        System.out.println("headNumResult = " + headNumResult);

        tailNum(5, TAIL_NUM_RESULT);

        System.out.println("tailNumResult = " + TAIL_NUM_RESULT);

        System.out.println("Integer MAX_VALUE = " + Integer.MAX_VALUE);
        System.out.println("2 ^ 32 = " + Math.pow(2,32));

        //--------------- factorial -----------------------------------
        long headFactorialResult = headFactorial2(5 );
        System.out.println("headFactorialResult = " + headFactorialResult);

        TAIL_NUM_RESULT = 1;
        tailFactorial(5, TAIL_NUM_RESULT);
        System.out.println("TAIL_NUM_RESULT = " + TAIL_NUM_RESULT);

        //---------------Fibonacci --------------------------------------
        int headFibResult = headFib(10);
        System.out.println("headFibResult = " + headFibResult);

        int tailFibResult = tailFib(10, 0, 1);

    }

    /*
    fib 0 = 0
    fib 1 = 1
    fib 2 = 1
    fib 3 = 2
     */
    private static int tailFib(int n, int accumulator1, int accumulator2) {
            if(n==0) return accumulator1;
            if(n==1) return accumulator2;
          return tailFib(n-1, accumulator2, accumulator1+ accumulator2);
    }

    private static int headFib(int n) {
        if(n<2) return n;
        return headFib(n-1) + headFib(n-2);
    }

    private static void tailFactorial(int n, int result) {
        if(n==1) {
            TAIL_NUM_RESULT = result;
            return;
        }
        tailFactorial(n-1, result * n);
    }

    private static int headFactorial1(int num) {
        if (num == 1) return 1;

        int previousProduct = headFactorial1(num - 1);

        int result = num * previousProduct;

        return result;
    }

    private static int headFactorial2(int num) {
        if (num == 1) return 1;

        return num * headFactorial2(num - 1);
    }

    public static int headNum(int n) {
        if (n == 0) {
            return 0;
        }
        return n + headNum(n - 1);      //after we get results from recursion then we perform the operation of addition
    }

    public static void tailNum(int n, int result) {
        if (n == 0) {
            TAIL_NUM_RESULT = result;
            return;
        }

        tailNum(n - 1, result + n);
    }
}
