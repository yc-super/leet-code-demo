package 代码随想录.动态规划专练.代码随想录.背包问题.完全背包.组合总和IV;

public class Solution {
    public int combinationSum4(int[] nums, int target) {
        //完全背包，排列问题-->注意遍历顺序，要先遍历背包，再遍历物品
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j])
                    dp[i] += dp[i - nums[j]];//这边递推公式，永远是dp[背包下标]+=dp[背包下标-nums[物品下标]]
            }
        }
        return dp[target];
    }
}
