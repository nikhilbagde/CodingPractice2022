package LeetCode.CompanyBased.Facebook;

public class P_896_MonotonicArray_Easy {
    public boolean isMonotonic(int[] A) {
        if(A.length==0) return true;

        boolean increasing = true, decreasing = true;

        for (int i = 1; i < A.length; i++) {
            if(A[i-1] > A[i]) {                         //BUG: change from A[i+1] to A[i] we should use, A[i-1]
                increasing = false;
                break;
            }
        }

        for (int i = 1; i < A.length; i++) {
            if(A[i-1] > A[i]){
                decreasing = false;
                break;
            }
        }

        return increasing || decreasing;
    }
}
