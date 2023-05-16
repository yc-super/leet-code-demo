package 代码随想录.动态规划专练.代码随想录.背包问题.完全背包.完全平方数;

public class Solution {
    public int numSquares(int n) {
        int[] nums = new int[100];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (i + 1) * (i + 1);
        }
        int[] dp = new int[n + 1];
        int max = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            dp[i] = max;
        }
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > n)
                continue;
            for (int j = nums[i]; j <= n; j++) {
                if (dp[j - nums[i]] != max)
                    dp[j] = Math.min(dp[j], dp[j - nums[i]] + 1);
            }
        }
        return dp[n];
    }
    //稍微优化下，nums数组不要了
    public int numSquares2(int n) {
        int[] dp = new int[n + 1];
        int max = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            dp[i] = max;
        }
        dp[0] = 0;
        int iValue;
        for (int i = 1; i <=100; i++) {
            iValue=i*i;
            if (iValue > n)
                continue;
            for (int j = iValue; j <= n; j++) {
                if (dp[j - iValue] != max)
                    dp[j] = Math.min(dp[j], dp[j - iValue] + 1);
            }
        }
        return dp[n];
    }
}
