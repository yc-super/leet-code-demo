package LeetCode_Hot100.乘积最大子数组;

public class MyCode2 {
    public static void main(String[] args) {
//        int[] nums = {-2,0,1,2,0,9,-1,3};
//        int[] nums = {2,3,0,-1,4,2,-2,-1,193};
        int[] nums = {2,3,-2,4};
        int i = maxProduct(nums);
        System.out.println(i);
    }

    private static int maxProduct(int[] nums) {
        if(nums.length==1)
            return nums[0];
        int len=nums.length;
        int[] min_array=new int[len];
        int[] max_array=new int[len];

        min_array[0]=nums[0];
        max_array[0]=nums[0];

        for (int i = 1; i < len; i++) {
           min_array[i]=Math.min(min_array[i-1]*nums[i],Math.min(max_array[i-1]*nums[i],nums[i]));
           max_array[i]=Math.max(min_array[i-1]*nums[i],Math.max(max_array[i-1]*nums[i],nums[i]));
        }

        int max=max_array[0];
        for (int i = 1; i < len; i++) {
            if(max<max_array[i])
                max=max_array[i];
        }
        return max;
    }
}
