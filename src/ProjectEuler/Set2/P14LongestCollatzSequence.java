package ProjectEuler.Set2;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Nikhil on 2/4/2017 6:49 PM.
 */
public class P14LongestCollatzSequence {
    final static int MAX = 5000000 + 7;
    static int[] array = new int[MAX];
    static long[] arrayAnswers = new long[MAX];

    public static void main(String[] args) {
        array[0]=1;

        for (int i = 2; i < MAX; i++) {
            Stack<Long> stack = new Stack<>();
            int temp = i;
            while(temp>1 && (temp >= MAX || array[temp]==0)){
                stack.push((long) temp);
                if((temp & 1) == 0) temp = temp/2;
                else temp = temp * 3 +1;
            }

            int steps = array[temp];
            for (; !stack.isEmpty() ; ++steps) {
                long value = stack.peek();
                stack.pop();
                if(value < MAX)
                    array[(int)value] = steps;
            }
        }

        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i < MAX; i++) {
            int act = array[i];
            int givenNumber = (int) arrayAnswers[i-1];
            if(act >= array[givenNumber]){
                arrayAnswers[i] = i;
            }else {
                arrayAnswers[i] = arrayAnswers[i-1];
            }
        }
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            System.out.println("result = " + arrayAnswers[N]);
        }
    }
}
