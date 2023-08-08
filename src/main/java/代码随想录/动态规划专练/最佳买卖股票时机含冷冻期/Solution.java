package 代码随想录.动态规划专练.最佳买卖股票时机含冷冻期;

public class Solution {
    public static void main(String[] args) {
//        int[] prices = {7, 1, 5, 3, 6, 4,5};
//        int[] prices = {7, 1, 5,  6, 1,3};
        int[] prices = {1,4,6};
        System.out.println(new  Solution().maxProfit(prices));
    }
    public int maxProfit(int[] prices) {
        //dp[i][0]:表示第i天持有第i天的股票，有多少钱（第0天为0，如果第一天买了股票，那第一天有的钱就是-prices[0]）
        //dp[i][1]:表示第i天不持有第i天的股票，有多少钱
        int[][] dp=new int[prices.length+1][2];
//        dp[0][0]=-prices[0];
        dp[0][1]=0;
        dp[1][0]=-prices[0];
        dp[1][1]=0;
        for (int i = 2; i <= prices.length; i++) {
            dp[i][0]=Math.max(dp[i-1][0],dp[i-2][1]-prices[i-1]);//和II不同的是，买入前只能加上前前一天卖出的，而不能是前一天卖出的钱
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i-1]);
        }

        return dp[prices.length][1];
    }
}
