package 代码随想录.动态规划专练.代码随想录.爬楼梯;

public class Solution {
    public int climbStairs(int n) {
        //完全背包，排列问题。
        //将问题简化为从数组{1,2}中任意取（可以重复），和为target的排列数
        int[] nums = {1, 2};
        int[] dp = new int[n + 1];
        dp[0]=1;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                if (i >= nums[j])
                    dp[i] += dp[i - nums[j]];
            }
        }
        return dp[n];
    }
}
