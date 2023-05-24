package 代码随想录.动态规划专练.代码随想录.买卖股票的最佳时机III;

public class Solution {
    public static void main(String[] args) {
//        int[] prices = {7, 1, 5, 3, 6, 4,5};
        int[] prices = {7, 1, 5,  4, 3,2};
        System.out.println(new Solution().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int len = prices.length;
        // dp[i][0]：第1次持有股票有多少钱
        // dp[i][1]：第1次不持有股票
        // dp[i][2]：第2次持有股票
        // dp[i][3]：第2次不持有股票
        int[][] dp = new int[len][4];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = -prices[0];
        dp[0][3] = 0;
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] - prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] + prices[i]);
        }
        return dp[len - 1][3] ;
    }
}
