package 代码随想录.动态规划专练.背包问题.背包问题01.一和零;

public class Solution2 {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < len; i++) {//遍历物品
            //统计strs[i]中0和1的个数，作为重量
            int zero = 0, one = 0;
            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) == '0')
                    zero++;
            }
            one = strs[i].length() - zero;
            //遍历重量
            for (int j = m; j >= zero ; j--) {
                for (int k = n; k >=one ; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zero][k - one] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
