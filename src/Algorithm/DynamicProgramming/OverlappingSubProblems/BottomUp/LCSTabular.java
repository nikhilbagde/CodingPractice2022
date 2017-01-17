package Algorithm.DynamicProgramming.OverlappingSubProblems.BottomUp;

import java.time.Year;

/**
 * Created by Nikhil on 1/6/2017 10:34 AM.
 */
public class LCSTabular {
    public static void main(String[] args) {
        String X1 = "AGGTAB";
        String Y2 = "GXTXAYB";

        String X = "BDCABA";
        String Y = "ABCBDAB";

        int m = X.length();
        int n = Y.length();

        System.out.println("Length of LCS = " + lcs(X.toCharArray(),Y.toCharArray(),m,n));

        LCS(X.toCharArray(),Y.toCharArray(),m,n);
    }
    private static int lcs(char[] X, char[]Y, int m, int n){
        int[][] L = new int[m+1][n+1];
        for (int i = 1; i <=m ; i++) {
            for (int j = 1; j <=n ; j++) {
                if(X[i-1] == Y[j-1]){
                    L[i][j] = 1 + L[i-1][j-1];
                }else{
                    L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
                }
            }
        }
        return L[m][n];
    }
    private static void LCS(char[] X, char[] Y, int n, int m){
        int[][]lcs = new int[n+1][m+1];
        char[][]path = new char[n+1][m+1];      //FIXME: update changed from n->n+1 ,m->m+1 line 51, array bound error

        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
                if(X[i-1] == Y[j-1]) {          //instead of checking X[i]==Y[j] check for X[i-1] and Y[i-1]
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;  //we found a matching letter, then store lcs as diagonal value + 1
                    path[i][j] = 'D';//which means diagonally value contains all previous lcs count. hence add 1.
                }
                else if(lcs[i-1][j]>= lcs[i][j]){       //not equal then check if previously found lcs value and choose for greater one
                    lcs[i][j] = lcs[i-1][j];           // previously found lcs is greater compared to current lcs.
                    path[i][j] = 'T';
                }else{          //not current lcs is of getter length hence choose the left one instead of above.
                    lcs[i][j] = lcs[i][j-1];
                    path[i][j] = 'L';
                }
            }
        }
        System.out.println("Length of Longest Common Sub-squence = " + lcs[n][m]);  //last value. as we consider all element. and keep copying max
        printPathCRec(path, X, n, m);          //X String  n=size of X | m=size of Y

    }
    private static void printPathCRec(char[][] path, char[] X, int n, int m ){
        if(n ==0 || m ==0){
            return;
        }
        if(path[n][m] == 'D'){
            printPathCRec(path, X, n-1, m-1);      //recurse till n>0 and m>0
            System.out.print(X[n]);
        }else if(path[n][m] == 'T'){
            printPathCRec(path, X, n-1, m);
        }else if(path[n][m] == 'L'){  //for 'L'
            printPathCRec(path, X, n, m-1);
        }
    }


}
