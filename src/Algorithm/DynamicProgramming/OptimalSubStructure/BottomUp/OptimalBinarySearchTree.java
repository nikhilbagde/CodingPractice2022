package Algorithm.DynamicProgramming.OptimalSubStructure.BottomUp;

/**
 * Created by Nikhil on 12/28/2016 10:32 PM.
 * Search Probabilities of each node of BST is given.
 * Objective is to create a BST with minimum search probabilities.
 */
public class OptimalBinarySearchTree {
    public static void main(String[] args) {

    }
}

/*
Void optsearchtree(int n, const float p[], flot& minavg, index R[][])
{
integer i, j, k, diagonal;
float A[1..n+1][0..n];
for (i = 1; i <= n; i++) //initialization
{
    A[i][i-1] = 0;
    R[i][i-1] = 0;
    A[i][i] = p[i];
    R[i][i] = i;
}
A[n+1] [n] = 0;
R[n+1][n] = 0;

for (diagonal = 1; diagonal <= n-1; diagonal++)
    for (i = 1; i <= n - diagonal; i++)
    {
        j = i + diagonal;
        R[i][j] = a value of k that gave the minimum
    }
    minavg = A[1][n];
}

Time Complexity: Θ(n3)
- The nested loop iterates Θ(n2) and each iteration takes Θ(n) to find the
minimum
 */