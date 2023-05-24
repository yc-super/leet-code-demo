package 代码随想录.动态规划专练.代码随想录.买卖股票的最佳时机;

public class Solution {
    public static void main(String[] args) {
        int[] prices={7,1,5,3,6,4};
        System.out.println(new Solution().maxProfit2(prices));
    }
    //贪心
    public int maxProfit(int[] prices) {
        int minValue = prices[0];
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            result = Math.max(result, prices[i] - minValue);
            minValue = Math.min(minValue, prices[i]);
        }
        return result;
    }

    //动态规划
    public int maxProfit2(int[] prices) {
        //dp[i][0]:表示第i天持有第i天的股票，有多少钱（第0天为0，如果第一天买了股票，那第一天有的钱就是-prices[0]）
        //dp[i][1]:表示第i天不持有第i天的股票，有多少钱
        int[][] dp=new int[prices.length][2];
        dp[0][0]=-prices[0];
        dp[0][1]=0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0]=Math.max(dp[i-1][0],-prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
        }

        return dp[prices.length-1][1];
    }
}
