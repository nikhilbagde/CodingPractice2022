package Algorithm.DynamicProgramming.OverlappingSubProblems.BottomUp;

/**
 * Created by Nikhil on 1/6/2017 8:53 PM.
 * Given two strings str1 and str2 and below operations that can performed on str1.
 * Find MINIMUM number of edits (operations) required to convert ‘str1’ into ‘str2’.
    Insert
    Remove
    Replace
 All of the above operations are of equal cost.
 */
public class EditTwoString {
    public static void main(String[] args) {
        String one = "sunday";
        String two = "saturday";

        int editCount = editTwoStringCountTabular(one.toCharArray(), two.toCharArray(), one.length(), two.length());
        System.out.println(editCount);
    }
    //Bottom Up Tabular
    private static int editTwoStringCountTabular(char[] X, char[] Y, int m, int n) {
        int[][] dpEditDist = new int[m + 1][n + 1];     //+1 because case 0 , we count from 0 to n ot 0tom

        for (int i = 0; i <= m; i++) {      //i and j would be lengths of strings.
            for (int j = 0; j <= n; j++) {
                if (i==0) {       //X empty, we can only insert all chars of Y.
                    dpEditDist[i][j] = j;
                } else if (j==0) {       //Y empty, we can only insert all chars of X.
                    dpEditDist[i][j] = i;
                } else if (X[i-1]==Y[j-1]) {     //if last char same, ignore last char // and recur for remaining string
                    dpEditDist[i][j] = dpEditDist[i-1][j-1];    //do nothing just copy last diagonal
                } else {  //If last character are different, consider all possibilities and find minimum
                    dpEditDist[i][j] = 1 + min(dpEditDist[i][j-1],    //insert
                            dpEditDist[i-1][j],                       //remove
                            dpEditDist[i-1][j-1]);                  //replace
                }
            }       //add 1 for char being not same.
        }
        return dpEditDist[m][n];
    }
    private static int min(int a, int b, int c){
        if(a<b && a<c) return a;
        if(b<a && b<c) return b;
        return c;
    }
}
/*
What are the subproblems in this case?
The idea is process all characters one by one staring from either from left or right sides of both strings.
Let we traverse from right corner, there are two possibilities for every pair of character being traversed.

m: Length of str1 (first string)
n: Length of str2 (second string)
If last characters of two strings are same, nothing much to do. Ignore last characters and get count for remaining strings. So we recur for lengths m-1 and n-1.
Else (If last characters are not same), we consider all operations on ‘str1’, consider all three operations on last character of first string, recursively compute minimum cost for all three operations and take minimum of three values.
Insert: Recur for m and n-1
Remove: Recur for m-1 and n
Replace: Recur for m-1 and n-1
 */