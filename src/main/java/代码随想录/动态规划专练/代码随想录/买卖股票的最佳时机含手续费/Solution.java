package 代码随想录.动态规划专练.代码随想录.买卖股票的最佳时机含手续费;

public class Solution {
    public static void main(String[] args) {
//        int[] prices={2,1,4,4,2,3,2,5,1,3};//5
        int[] prices={2,1,4,4,2,3,2,5,1,2};//5
        System.out.println(new Solution().maxProfit(prices,1));
    }
    public int maxProfit(int[] prices, int fee) {
        //dp[i][0]:表示第i天持有第i天的股票，有多少钱（第0天为0，如果第一天买了股票，那第一天有的钱就是-prices[0]）
        //dp[i][1]:表示第i天不持有第i天的股票，有多少钱
        int[][] dp=new int[prices.length][2];
        dp[0][0]=-prices[0];
        dp[0][1]=0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i]-fee);
        }

        return dp[prices.length-1][1]>0?dp[prices.length-1][1]:0;
    }
}
