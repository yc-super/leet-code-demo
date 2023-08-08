package 代码随想录.动态规划专练.最长回文子序列;

public class Solution {
    public static void main(String[] args) {
        //aabbaaca
        //bbbab
        //cbbd
//        String s = "abac";
//        String s = "bbbab";
        String s = "aabba";
        System.out.println(new Solution().longestPalindromeSubseq(s));
    }

    //dp，dp[i][j]=max(dp[i-1][j-1],dp[i][j-1],dp[i-1][j])
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        int a;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                a = j - i;
                if (a <= 1) {
                    dp[i][j] = 1;
                    if (a == 1 && s.charAt(i) == s.charAt(j)) {
                        dp[i][j]++;
                    }
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = Math.max(dp[i + 1][j - 1] + 2, dp[i][j]);
                    }
                }
            }
        }
        return dp[0][len - 1];
    }
}
