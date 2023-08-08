package 代码随想录.动态规划专练.背包问题.背包问题01.一和零;

public class Solution {
    // 01背包变形，只不过有2个维度的重量，并且价值都是1
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        int zeroCount, oneCount;
        for (String str : strs) {//遍历物品
            zeroCount = 0;
            oneCount = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    zeroCount++;
                }
            }
            oneCount = str.length() - zeroCount;

            //遍历重量，2个维度的重量。记得从后往前遍历
            for (int i = m; i >= zeroCount; i--) {
                for (int j = n; j >= oneCount; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroCount][j - oneCount] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
