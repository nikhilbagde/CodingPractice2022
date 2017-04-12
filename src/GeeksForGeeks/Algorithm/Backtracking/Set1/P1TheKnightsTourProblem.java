package GeeksForGeeks.Algorithm.Backtracking.Set1;

/**
 * Created by Nikhil on 4/5/2017 12:40 AM.
 */
public class P1TheKnightsTourProblem {
}

/* consider x[0] y[0] together
int xMove[8] = { 2, 1, -1, -2, -2, -1, 1, 2 };
int yMove[8] = { 1, 2, 2, 1, -1, -2, -2, -1 };

Value of these array depends upon that which direction Knight can move
like
1. go down and right // row + 2, column + 1
2. go right and down // row + 1, column + 2
3. go right and up // row - 1, column + 2
4. go up and right //row - 2, column + 1
5. go up and left // row - 2, column - 1
6. go left and up //row - 1, column - 2
7. go left and down //row + 1, column - 2
8. go down and left //row + 2, column - 1
 */