package Algorithm.DynamicProgramming.OverlappingSubProblems.TopDownRec;

/**
 * Created by Nikhil on 1/6/2017 10:04 AM.
 */
public class LongestCommonSubsquenceRecursive {
    public static void main(String[] args) {
        String X = "AGGTAB";
        String Y = "GXTXAYB";

        int m = X.length();
        int n = Y.length();

        System.out.println("Length of LCS = " + lcsRecursive(X.toCharArray(),Y.toCharArray(),m,n));
    }
    /*
    If last characters of both sequences match (or X[m-1] == Y[n-1]) then
    L(X[0..m-1], Y[0..n-1]) = 1 + L(X[0..m-2], Y[0..n-2])

    If last characters of both sequences do not match (or X[m-1] != Y[n-1]) then
    L(X[0..m-1], Y[0..n-1]) = MAX ( L(X[0..m-2], Y[0..n-1]), L(X[0..m-1], Y[0..n-2])
     */
    private static int lcsRecursive(char[] X, char[] Y, int m, int n){
        if(m==0 || n==0){
            return 0;
        }
        if(X[m-1] == Y[n-1]){                                   //compare last element of both string. if equal 1 +..remining string
            return 1 + lcsRecursive(X, Y, m-1, n-1);
        }else {                                                 // if not equal, calculate for 2 subProblem, with 1 reduced element of X
            return Math.max(lcsRecursive(X,Y,m, n-1), lcsRecursive(X,Y,m-1, n));            //or 1 less element of Y. Get max of that.
        }
    }
}

/*
                        lcs("AXYT", "AYZX")
                       /                 \
         lcs("AXY", "AYZX")            lcs("AXYT", "AYZ")
         /            \                  /               \
lcs("AX", "AYZX") lcs("AXY", "AYZ")   lcs("AXY", "AYZ") lcs("AXYT", "AY")
 */