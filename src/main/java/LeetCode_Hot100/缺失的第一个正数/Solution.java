package LeetCode_Hot100.缺失的第一个正数;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 9, 4, -9, -1};
        System.out.println(new Solution().firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        int temp;

        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1 && nums[i] > 0 && nums[i] <= len) {
                temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                myMethod(nums, temp, nums[i] - 1);
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }

    private void myMethod(int[] nums, int target, int index) {
        if (target != index + 1 && target > 0 && target <= nums.length) {
            int temp = nums[target - 1];
            nums[target - 1] = target;
            myMethod(nums, temp, target - 1);
        }
    }
}
