package Algorithm.DynamicProgramming.OverlappingSubProblems.TopDownRec;

/**
 * Created by Nikhil on 1/6/2017 9:12 PM.
 * Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
     Insert
     Remove
     Replace
     All of the above operations are of equal cost.
 */
public class EditTwoString {
    public static void main(String[] args) {
        String one = "sunday";
        String two = "saturday";

        int editCount = editTwoStringCountRecursive(one.toCharArray(), two.toCharArray(), one.length(), two.length());
        System.out.println(editCount);
    }
    private static int editTwoStringCountRecursive(char[] X, char[] Y, int m, int n){
        if(m==0) return n;
        if(n==0) return m;
        if(X[m-1]==Y[n-1]) return editTwoStringCountRecursive(X,Y,m-1,n-1); //do nothing ignore.
        return 1 + min( editTwoStringCountRecursive(X,Y,m,n-1),   //insert last char of first String
                editTwoStringCountRecursive(X,Y,m-1,n),     //remove last char of first String
                editTwoStringCountRecursive(X,Y,m-1,n-1));  //replace last char of first String
    }
    private static int min(int a, int b, int c){
        if(a<b && a<c) return a;
        if(b<a && b<c) return b;
        return c;
    }

}

/*
this is not efficient as it will calculate some instances more than once. Use bottom up
dp[m+1][n+1]
for i 0->m
       for j 0->n
        if(m==0) return n -> dp[i][j]=n;
        if(n==0) return m -> dp[i][j]=m;
        if(X[m-1]==Y[n-1]) return editTwoStringCountRecursive(X,Y,m-1,n-1); //do nothing ignore.
            ->dp[i][j]=dp[i-1][j-1];
        return 1 + min( editTwoStringCountRecursive(X,Y,m,n-1),   //insert last char of first String
                editTwoStringCountRecursive(X,Y,m-1,n),     //remove last char of first String
                editTwoStringCountRecursive(X,Y,m-1,n-1));  //replace last char of first String
                dp[i][j] = 1 + min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1]);
 */