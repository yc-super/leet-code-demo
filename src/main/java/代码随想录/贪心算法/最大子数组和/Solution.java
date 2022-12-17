package 代码随想录.贪心算法.最大子数组和;

public class Solution {
    //先是想到了动态规划，自己想出来的（实际不用维护一个动态数组dp，直接维护两个变量就行了，因为计算dp[i]只和\dp[i-1]比较）
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int result = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = nums[i];
            if (dp[i - 1] > 0) {
                dp[i] += dp[i - 1];
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    //动态规划优化
    public int maxSubArray2(int[] nums) {
        int len = nums.length;
        int pre = nums[0];
        int result = nums[0];
        for (int i = 1; i < len; i++) {
            pre = Math.max(nums[i], pre + nums[i]);
            result = Math.max(result, pre);
        }
        return result;
    }

    //代码随想录，贪心
    //最直观的想这道题，就是从下表为0全部遍历一遍。贪心是在这个基础上，如果遇到count小于0,那么就舍弃之前的值，把count置为0，期间不断更新result
    public int maxSubArray3(int[] nums) {
        int result = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            result = Math.max(result, count);
            if (count < 0)
                count = 0;
        }
        return result;
    }
}
