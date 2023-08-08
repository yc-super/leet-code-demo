package 代码随想录.动态规划专练.判断子序列;

public class Solution {
    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        System.out.println(new Solution().isSubsequence2(s,t));
    }
    // 第一想到的是双指针
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }

    // 动态规划没思路。看了代码随想录才知道，dp[i][j]表示以i-1为结尾的s和以j-1为结尾的t，最长公共子序列的长度。
    //这道题目类似 最长重复子数组
    public boolean isSubsequence2(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }
                else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j],dp[i + 1][j]);
                }
            }
        }
        return dp[len1][len2] == len1;
    }

}
