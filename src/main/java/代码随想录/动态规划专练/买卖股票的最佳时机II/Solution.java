package 代码随想录.动态规划专练.买卖股票的最佳时机II;

public class Solution {
    //动态规划（和买卖股票的最佳时机I相比，只是第i天持有的话，不再是-prices[i]了，而是还要加上上一天不持有股票的钱）
    public int maxProfit2(int[] prices) {
        //dp[i][0]:表示第i天持有第i天的股票，有多少钱（第0天为0，如果第一天买了股票，那第一天有的钱就是-prices[0]）
        //dp[i][1]:表示第i天不持有第i天的股票，有多少钱
        int[][] dp=new int[prices.length][2];
        dp[0][0]=-prices[0];
        dp[0][1]=0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
        }

        return dp[prices.length-1][1];
    }
}
