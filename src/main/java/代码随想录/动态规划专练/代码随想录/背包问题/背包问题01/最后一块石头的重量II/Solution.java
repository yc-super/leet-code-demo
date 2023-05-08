package 代码随想录.动态规划专练.代码随想录.背包问题.背包问题01.最后一块石头的重量II;

public class Solution {
    public static void main(String[] args) {

    }

    public int lastStoneWeightII(int[] stones) {
        int len = stones.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += stones[i];
        }
        int target = sum >> 1;
        int[] dp = new int[target + 1];
        dp[0] = 0;
        for (int i = 0; i < len; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - 2 * dp[target];
    }
}
