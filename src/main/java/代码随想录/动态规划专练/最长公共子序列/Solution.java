package 代码随想录.动态规划专练.最长公共子序列;

public class Solution {
    public static void main(String[] args) {
        String text1 = "abcde", text2 = "azcce";
        System.out.println(new Solution().longestCommonSubsequence2(text1, text2));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length(), len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }

    // 一维dp数组。不太好理解，还涉及到了pre这个参数
    public int longestCommonSubsequence2(String text1, String text2) {
        int len1 = text1.length(), len2 = text2.length();
        int[] dp = new int[len2 + 1];
        for (int i = 1; i <= len1; i++) {
            int pre = dp[0];//相当于dp[i-1][j-1]，不太好理解
            for (int j = 1; j <= len2; j++) {//看来也不是、二维转化一维就一定是内循环倒序
                int cur = dp[j];//用于给pre赋值
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[j] = pre + 1;//这里不能用dp[j - 1] + 1
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                pre = cur;
            }

        }
        return dp[len2];
    }
}
