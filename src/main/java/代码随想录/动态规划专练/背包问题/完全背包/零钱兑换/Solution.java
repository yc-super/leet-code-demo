package 代码随想录.动态规划专练.背包问题.完全背包.零钱兑换;

public class Solution {
    public static void main(String[] args) {
        int[] conins = {2, 5};
        int amount = 10;
        System.out.println(new Solution().coinChange(conins, amount));
    }

    //完全背包。
    // dp[j]代表容量为j的背包，放满最小需要的硬币个数
    // 递推公式：dp[j]=Math.min(dp[j],dp[j-coins[i]]+1;
    // 顺序：都行；
    // 初始化：dp[0]=0,其他设置为Integer.MAX_VALUE，不然不能取到最小值
    public int coinChange(int[] coins, int amount) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            dp[i] = max;
        }
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != max)//只有不是max的才需要更新最小值，不然就越界了
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }
}
