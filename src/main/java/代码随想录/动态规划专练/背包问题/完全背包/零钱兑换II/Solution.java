package 代码随想录.动态规划专练.背包问题.完全背包.零钱兑换II;

public class Solution {
    //完全背包，求组合个数
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        //金额为0时只有1种情况，就是什么都不装
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {//遍历物品
            for (int j = coins[i]; j <= amount; j++) {//正序遍历背包
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
