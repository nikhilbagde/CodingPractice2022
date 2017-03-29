package Algorithm.Implementation.Easy;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * Created by Nikhil on 3/29/2017 6:22 AM.
 * https://www.hackerrank.com/challenges/counting-valleys
 */
public class P11CountingValleys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);
        int totalSteps = scanner.nextInt();
        char[] path = scanner.next().toCharArray();
        int[] _level = new int[path.length];
        int level = 0, count = 0;

        //directly considering count in first following loop was difficult
        // as checking last char U wont give concrete proof that we are going up or down.
        //keep track of level -1, 0, 1 in _level array.
        for (int i = 0; i < path.length; ++i) {
            switch (path[i]) {
                case 'U':
                    ++level;
                    break;
                case 'D':
                    --level;
                    break;
            }
            _level[i] = level;
        }
        //how can I check if I am going down, check when last element was zero
        //and handle special for i==0.
        for (int i = 0; i < _level.length; ++i) {
            if (_level[i] == -1 && (i == 0 || (i > 0 && _level[i - 1] == 0)))
                ++count;
        }
        System.out.println(count);
    }
}
