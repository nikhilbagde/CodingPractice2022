package Patterns.educative.io.java2.E_CyclicSort;

class CyclicSort {

    public static void sort(int[] nums) {       // {10, 5, 2, 3}
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1) {                               //10 != 1
                nums[nums[i]-1] = nums[i];            //nums[0]=10 -1=0     num[10]
                nums[i] = i+1;
            }
        }
        return;
    }

    public static void main(String[] args) {

        sort(new int[] {10,5,2,3});
    }
}
