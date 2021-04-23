package LeetCode.CompanyBased.Facebook;

public class P_11_ContainerWithMostWater_Easy {
    public static void main(String[] args) {

    }

    public static int maxArea(int[] height) {
        //O(n)^2, two for loops i and j, for each i we will calculate area,
        // by taking [min of i and j] and multiplying by the [ j-i] difference.
        // And taking max value at each iteration

        // O(N) two pointers : i and j, calculate area for i and j range first. records at max
        // then move pointer which has smaller  height to get maximum output

        int max = Integer.MIN_VALUE;

        int i = 0, j= height.length-1;

        while(i<j) {
            int minHeight =  Math.min(height[i], height[j]);
            max = Math.max( max, minHeight * (j-i));

            if(height[i]<height[j]){
                i++;
            }else {
                j++;
            }
        }
        return max;
    }
}
