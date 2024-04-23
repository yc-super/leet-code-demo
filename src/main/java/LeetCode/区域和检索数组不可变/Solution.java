package LeetCode.区域和检索数组不可变;

public class Solution {
    class NumArray {
        private int[] nums;
        private int[] tempNum;

        public NumArray(int[] nums) {
            this.nums = nums;
            tempNum = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if (i != 0) {
                    tempNum[i] = tempNum[i - 1] + nums[i];
                } else {
                    tempNum[i] = nums[i];
                }
            }
        }

        public int sumRange(int left, int right) {
            return tempNum[right] - tempNum[left] + nums[left];
        }
    }
}
