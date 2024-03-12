package LeetCode_Hot100.除自身以外数组的乘积;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 4};
        int[] ints = new Solution().productExceptSelf(nums);
        System.out.println();
    }

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len + 1];
        left[0] = 1;
        right[len - 1] = 1;
        right[len] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }
}
