package LeetCode_Hot100.轮转数组;

public class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        int[] temp = new int[k];
        int index = 0;
        for (int i = len - k; i < len; i++) {
            temp[index++] = nums[i];
        }
        index = len - 1;
        for (int i = len - k - 1; i >= 0; i--) {
            nums[index--] = nums[i];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }

    //翻转法，不太好想出来
    public void rotate2(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        revert(nums, 0, len - k - 1);
        revert(nums, len - k, len - 1);
        revert(nums, 0, len - 1);
    }

    private void revert(int[] nums, int start, int end) {
        int temp;
        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
