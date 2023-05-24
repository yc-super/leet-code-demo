package 代码随想录.动态规划专练.代码随想录.买卖股票的最佳时机IV;

public class Solution {
    public static void main(String[] args) {
//        int[] prices = {7, 1, 5, 3, 6, 4,5};
//        int[] prices = {7, 1, 5,  4, 3,2};
        int[] prices = {2, 1};
        System.out.println(new Solution().maxProfit(2, prices));
    }

    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        // dp[i][0]：第1次持有股票有多少钱
        // dp[i][1]：第1次不持有股票
        // dp[i][2]：第2次持有股票
        // dp[i][3]：第2次不持有股票
        if (len <= 1)
            return 0;
        if (k > len / 2)
            k = len / 2;
        int[][] dp = new int[len][2 * k];
        for (int i = 0; i < 2 * k; i += 2) {
            dp[0][i] = -prices[0];
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < 2 * k; j++) {
                if (j == 0) {
                    dp[i][j] = Math.max(dp[i - 1][0], -prices[i]);
                } else if (j % 2 == 1) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                }
            }
//            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
//            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
//            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] - prices[i]);
//            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] + prices[i]);
//            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] - prices[i]);
//            dp[i][5] = Math.max(dp[i - 1][5], dp[i - 1][4] + prices[i]);
        }
        return dp[len - 1][2 * k - 1];
    }
}
