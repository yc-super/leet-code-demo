package LeetCode.递增的三元子序列;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(new Solution().increasingTriplet(nums));
    }

    public boolean increasingTriplet(int[] nums) {
        boolean flag = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                flag = true;
            }
        }
        if (!flag)//说明全部倒序
            return false;

        Integer minTwo = Integer.MAX_VALUE;
        Integer minOne = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] < minOne) {
                int j;
                for (j = i + 1; j < nums.length - 1; j++) {
                    if (nums[j] > nums[i] && nums[j] < minTwo) {
                        int k;
                        for (k = j + 1; k < nums.length; k++) {
                            if (nums[k] > nums[j]) {
                                return true;
                            }
                        }
                        minTwo = Math.min(minTwo, nums[j]);
                    }
                }
                minOne = Math.min(minOne, nums[i]);
            }
        }
        return false;
    }
}
